package com.fishep.fusion.common.type;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class AbstractNumber {

    protected String value;

    protected Integer length;

    protected String prefix;

    protected String date;

    protected String fill;

    static protected Long serial = 0L;

    public AbstractNumber(String value) {
        this.value = value;
    }

    public AbstractNumber() {
        String p = this.prefix();
        Integer l = this.length();
        String d = this.date();
        Long s = this.serial();
        String f = this.fill();

        value = p + d + f + s;
    }

    protected String key() {
        return "key";
    }

    protected String prefix() {
        return prefix = "XX";
    }

    protected Integer length() {
        return length = 16;
    }

    protected String date() {
        return date = new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    // @TODO 重启之后重新编号bug
    protected Long serial() {
        return serial += 1;
    }

    protected String fill() {
        int length = this.prefix.length() + this.date.length() + serial.toString().length();
        if (length > this.length) {
            throw new RuntimeException("number is too long ,length is " + length);
        }

        fill = "0".repeat(this.length - length);

        return fill;
    }

    public String getValue() {
        return value;
    }
}
