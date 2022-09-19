package com.fishep.fusion.common.util.impl;

import com.fishep.fusion.common.util.NumberBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class AbstractNumber implements NumberBean {

    protected RedisTemplate redisTemplate;

    @Autowired
    void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String generate() {

        String key = this.key();

        String nowDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String oldDate = (String) redisTemplate.opsForHash().get(key, "date");
        if (!nowDate.equals(oldDate)) {
            redisTemplate.opsForHash().put(key, "date", nowDate);
            redisTemplate.opsForHash().put(key, "id", 0L);
        }

        //Long id = redisTemplate.opsForHash().increment(key, "id", 1);
        Long id = (Long) redisTemplate.opsForHash().get(key, "id");
        ++id;
        redisTemplate.opsForHash().put(key, "id", id);

        String serial = id.toString();

        int length = this.prefix().length() + nowDate.length() + serial.length();
        if (length > this.length()) {
            throw new RuntimeException("number is too long ,length is " + length);
        }

        String fill = "0".repeat(this.length() - length);

        return this.prefix() + nowDate + fill + serial;
    }

    protected String key() {
        return this.getClass().getName();
    }

    abstract protected String prefix();

    abstract protected Integer length();
}
