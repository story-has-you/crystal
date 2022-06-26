package com.storyhasyou.crystal.components;

import cn.hutool.crypto.digest.MD5;
import com.storyhasyou.kratos.utils.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;

/**
 * @author fangxi created by 2022/6/26
 */
@Component
public class RedisService {

    private static final String ROOT_KEY_PREFIX = "user-service:";
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 获取图形验证码
     */
    public String getCaptcha() {
        return (String) redisTemplate.opsForValue().get(getCaptchaKey());
    }

    /**
     * 设置图形验证码
     */
    public void setCaptcha(String value) {
        String captchaKey = getCaptchaKey();
        redisTemplate.opsForValue().set(captchaKey, value, Duration.ofMinutes(5L));
    }

    private String getCaptchaKey() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String ip = IpUtils.getIp(request);
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);
        return ROOT_KEY_PREFIX + "captcha:" + MD5.create().digestHex(ip + userAgent);
    }

}
