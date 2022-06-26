package com.storyhasyou.crystal.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.storyhasyou.crystal.components.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author fangxi created by 2022/6/25
 */
@Slf4j
@RestController
@RequestMapping("/notify")
public class NotifyController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    private RedisService redisService;

    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            String text = defaultKaptcha.createText();
            redisService.setCaptcha(text);
            BufferedImage bufferedImage = defaultKaptcha.createImage(text);
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpg", outputStream);
            outputStream.flush();
        } catch (IOException e) {
            log.error("验证码获取失败", e);
        }
    }


}
