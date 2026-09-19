package com.klsjnh.lowcode011.infrastructure.dialect;

/*                DialectRegistry011 class
 *
 *      @author     xiangrkrs@163.com
 *      @version    ver 0.0.1
 *      @createdate 2026.09.19
 *      @modifydate
 *
 *===========================================
 *          modify history
 *
 *      2026.09.19  target db dialect registry class
 *
 */

import com.klsjnh.common.enums.DatabaseType011;

import com.klsjnh.lowcode011.domain.Dialect011;
import com.klsjnh.lowcode011.domain.DialectPort;
import com.klsjnh.lowcode011.domain.DialectResolverPort;
import com.klsjnh.lowcode011.domain.MetadataDataWriterPort;
import com.klsjnh.lowcode011.domain.MetadataDdlExecutorPort;
import com.klsjnh.lowcode011.domain.MetadataDdlGeneratorPort;

import com.klsjnh.lowcode011.infrastructure.config.LowcodeConfig011;

import org.springframework.stereotype.Component;

/**
 * Target db dialect registry: MySQL is implemented; Oracle / SQLServer fail
 * loudly until their dialects land. Resolution is by {@code DatabaseType011},
 * so callers never hard-code MySQL.
 */

@Component
public class DialectRegistry011 implements DialectResolverPort {

    /**
     * MySQL dialect (the only implementation for now).
     */
    private final Dialect011 mysql;

    /**
     * Low-code config (target db type).
     */
    private final LowcodeConfig011 lowcodeConfig011;

    /**
     * Create the registry.
     *
     * @param ddlGenerator      ddl generator bean
     * @param ddlExecutor       schema executor bean
     * @param dataWriter        data writer bean
     * @param lowcodeConfig011  low-code config (target db type)
     */
    public DialectRegistry011(MetadataDdlGeneratorPort ddlGenerator, MetadataDdlExecutorPort ddlExecutor,
            MetadataDataWriterPort dataWriter, LowcodeConfig011 lowcodeConfig011) {
        this.mysql = new Dialect011(ddlGenerator, ddlExecutor, dataWriter);
        this.lowcodeConfig011 = lowcodeConfig011;
    }

    /** {@inheritDoc} */
    @Override
    public DialectPort resolve() {
        return resolve(DatabaseType011.fromString(lowcodeConfig011.getTargetDbType()));
    }

    /** {@inheritDoc} */
    @Override
    public DialectPort resolve(DatabaseType011 type) {
        if (type == null || type == DatabaseType011.MYSQL) {
            return mysql;
        }

        throw new IllegalArgumentException("db dialect not supported yet: " + type.getCode());
    }
}
