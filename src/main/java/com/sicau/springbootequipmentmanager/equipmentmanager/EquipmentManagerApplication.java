package com.sicau.springbootequipmentmanager.equipmentmanager;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan("com.sicau.*.*.*.mapper")
public class EquipmentManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipmentManagerApplication.class, args);
        log.info("舞台已搭建，请开始你的表演");

    }

}
