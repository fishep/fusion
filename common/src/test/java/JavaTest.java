import org.junit.jupiter.api.Test;

import java.util.Random;

public class JavaTest {

    @Test
    void random() {

        for (int i = 0; i < 20; i++)
        {
            Random random = new Random();
            System.out.println(random.nextInt(1, 100));
        }

    }
}
