import cn.hutool.core.date.LocalDateTimeUtil;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

public class HuTool {
    @Test
    void LocalDateTimeOfUTC() {
        long l = System.currentTimeMillis();
        System.out.println("毫秒时间戳：" + l);

        String format = LocalDateTimeUtil.ofUTC(l).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("日期格式：" + format);
    }
}
