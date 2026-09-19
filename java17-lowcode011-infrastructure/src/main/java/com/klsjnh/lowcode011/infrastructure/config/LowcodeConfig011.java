package com.klsjnh.lowcode011.infrastructure.config;

/*                LowcodeConfig011 class
 *
 *      @author     xiangrkrs@163.com
 *      @version    ver 0.0.1
 *      @createdate 2026.09.19
 *      @modifydate
 *
 *===========================================
 *          modify history
 *
 *      2026.09.19  lowcode config 011 class
 *
 */

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Low-code product settings (krt.lowcode.*), owned by this project rather than
 * the framework. Currently the DDL execution gate only.
 */

@Component
@ConfigurationProperties(prefix = "krt.lowcode")
@Data
public class LowcodeConfig011 {

    /**
     * Target database type of the object tables (krt.lowcode.target-db-type),
     * default mysql. Drives dialect resolution (052).
     */
    private String targetDbType = "mysql";

    /**
     * DDL execute gate (krt.lowcode.ddl-execute.*).
     */
    private DdlExecute ddlExecute = new DdlExecute();

    /**
     * DDL execute gate.
     */
    @Data
    public static class DdlExecute {

        /**
         * Whether publishing may execute DDL.
         */
        private boolean enabled;
    }
}
