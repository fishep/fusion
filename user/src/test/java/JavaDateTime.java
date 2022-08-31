import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class JavaDateTime {
    @Test
    void zonedDateTimeTest() {
//        System.out.println(System.currentTimeMillis());
        Instant now = Instant.now();
        System.out.println(now.getEpochSecond());
        System.out.println(now.toEpochMilli());

        Instant ins = Instant.ofEpochSecond(now.getEpochSecond());
        System.out.println(ins);
        ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
        System.out.println(zdt);
        ZonedDateTime udt = ins.atZone(ZoneId.of("UTC"));
        System.out.println(udt);

        long epochSecond = zdt.toInstant().getEpochSecond();
        System.out.println(epochSecond);
    }
}
