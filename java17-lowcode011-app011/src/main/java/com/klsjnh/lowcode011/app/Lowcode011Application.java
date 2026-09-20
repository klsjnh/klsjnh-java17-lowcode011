package com.klsjnh.lowcode011.app;

/*                Lowcode011Application class
 *
 *      @author     xiangrkrs@163.com
 *      @version    ver 0.0.1
 *      @createdate 2026.09.19
 *      @modifydate
 *
 *===========================================
 *          modify history
 *
 *      2026.09.19  lowcode 011 application class
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;

/**
 * klsjnh Java17 low-code product boot entry, the only main of this project. It
 * depends on the framework011 base artifacts and hosts the low-code domain.
 */

@SpringBootApplication(scanBasePackages = "com.klsjnh")
@MapperScan({ "com.klsjnh.infrastructure.iam", "com.klsjnh.infrastructure.persistence.mapper",
        "com.klsjnh.infrastructure.system011", "com.klsjnh.infrastructure.datasource",
        "com.klsjnh.infrastructure.aicenter", "com.klsjnh.infrastructure.storagecenter",
        "com.klsjnh.infrastructure.messagecenter", "com.klsjnh.lowcode011.infrastructure.mapper",
        "com.klsjnh.lowcode011.infrastructure.modeling.mapper" })
public class Lowcode011Application {

    /**
     * Boot entry point.
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        SpringApplication.run(Lowcode011Application.class, args);
    }
}
