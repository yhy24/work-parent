package com.redis.server.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class IdGneraterUtil {

    private RedisTemplate redisTemplate;

    public IdGneraterUtil(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取有过期时间的自增长ID
     * @param key
     * @param expireTime
     * @return
     */
    public long generate(String key, Date expireTime) {
        RedisAtomicLong counter = new RedisAtomicLong(key, this.redisTemplate.getConnectionFactory());
        Long expire = counter.getExpire();
        if(expire==-1){
            counter.expireAt(expireTime);
        }
        return counter.incrementAndGet();
    }


    public String generateOrderId() {
//生成id为当前日期（yyMMddHHmmss）+6位（从000000开始不足位数补0）
        LocalDateTime now = LocalDateTime.now();
        String orderIdPrefix = getOrderIdPrefix(now);//生成yyyyMMddHHmmss
        String orderId = orderIdPrefix+String.format("%1$06d", generate(orderIdPrefix,getExpireAtTime(now)));
        return orderId;

    }

    public static String getOrderIdPrefix(LocalDateTime now){
        return now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    public Date getExpireAtTime(LocalDateTime now){
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = now.plusSeconds(20);
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }
}
