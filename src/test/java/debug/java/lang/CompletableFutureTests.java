package debug.java.lang;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompletableFutureTests {

    @Test
    void testSupplyAsync() throws Exception {

        System.out.println("main job threadName=" + Thread.currentThread().getName() + ", threadId=" + Thread.currentThread().getId());

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("async job threadName=" + Thread.currentThread().getName() + ", threadId=" + Thread.currentThread().getId());
            return "Hello";
        });

        System.out.println("main job threadName=" + Thread.currentThread().getName() + ", threadId=" + Thread.currentThread().getId());

        String result = future.get();

        System.out.println("main job threadName=" + Thread.currentThread().getName() + ", threadId=" + Thread.currentThread().getId());

        assertEquals("Hello", result);
    }

    @Test
    void testThenApply() throws Exception {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello").thenApply(String::toUpperCase);

        assertEquals("HELLO", future.get());
    }

    @Test
    void testThenAccept() {

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "hello").thenAccept(System.out::println);

        future.join();
    }

    @Test
    void testThenCombine() throws Exception {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Java");

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "21");

        CompletableFuture<String> result = future1.thenCombine(future2, (a, b) -> a + " " + b);

        assertEquals("Java 21", result.get());
    }

    @Test
    void testAllOf() {

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            sleep(100);
            return "A";
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            sleep(200);
            return "B";
        });

        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            sleep(300);
            return "C";
        });

        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);

        all.join();

        assertEquals("A", f1.join());
        assertEquals("B", f2.join());
        assertEquals("C", f3.join());
    }

    @Test
    void testExceptionally() throws Exception {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 1 / 0).exceptionally(ex -> -1);

        assertEquals(-1, future.get());
    }

    @Test
    void testHandle() throws Exception {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 1 / 0).handle((result, ex) -> {
            if (ex != null) {
                return -1;
            }
            return result;
        });

        assertEquals(-1, future.get());
    }

    @Test
    void testWhenComplete() throws Exception {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "success").whenComplete((result, ex) -> {
            System.out.println("result = " + result);
            System.out.println("ex = " + ex);
        });

        assertEquals("success", future.get());
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
