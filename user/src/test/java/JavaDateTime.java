import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JavaDateTime {
    @Test
    void zonedDateTimeTest() {
        System.out.println("System.currentTimeMillis() : " + System.currentTimeMillis());
        Instant now = Instant.now();
        System.out.println("now.toEpochMilli() : " + now.toEpochMilli());
        System.out.println("now.getEpochSecond() : " + now.getEpochSecond());

        Instant ins = Instant.ofEpochSecond(now.getEpochSecond());
        System.out.println("Instant : " + ins);
        ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
        System.out.println("Instant Default Zone : " + zdt);
        ZonedDateTime udt = ins.atZone(ZoneId.of("UTC"));
        System.out.println("Instant UTC Zone : " + udt);

        long epochSecond = udt.toInstant().getEpochSecond();
        System.out.println("Instant getEpochSecond() : " + epochSecond);
    }
}
