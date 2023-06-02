package com.sicau.springbootequipmentmanager.equipmentmanager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EquipmentManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipmentManagerApplication.class, args);
        log.info("舞台已搭建，请开始你的表演:这是一个提交测试");
    }

}
