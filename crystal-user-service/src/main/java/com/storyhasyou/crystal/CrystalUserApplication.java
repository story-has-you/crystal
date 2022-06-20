package com.storyhasyou.crystal;

import com.storyhasyou.kratos.annotation.EnableBladesOfChaos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fangxi created by 2022/6/20
 */
@EnableBladesOfChaos
@SpringBootApplication
public class CrystalUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrystalUserApplication.class, args);
    }

}