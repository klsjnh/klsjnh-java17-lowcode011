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

import com.klsjnh.common.constant.DatabaseTypes011;

import com.klsjnh.lowcode011.domain.dialect.Dialect011;
import com.klsjnh.lowcode011.domain.dialect.DialectPort;
import com.klsjnh.lowcode011.domain.dialect.DialectResolverPort;
import com.klsjnh.lowcode011.domain.metadata.MetadataDataWriterPort;
import com.klsjnh.lowcode011.domain.metadata.MetadataDdlExecutorPort;
import com.klsjnh.lowcode011.domain.metadata.MetadataDdlGeneratorPort;

import com.klsjnh.lowcode011.infrastructure.config.LowcodeConfig011;

import org.springframework.stereotype.Component;

/**
 * Target db dialect registry: MySQL is implemented; Oracle / SQLServer fail
 * loudly until their dialects land. Resolution is by the open string db type
 * code (see {@code DatabaseTypes011}), so callers never hard-code MySQL.
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
        return resolve(lowcodeConfig011.getTargetDbType());
    }

    /** {@inheritDoc} */
    @Override
    public DialectPort resolve(String dbType) {
        String type = DatabaseTypes011.normalize(dbType);

        if (type == null || DatabaseTypes011.MYSQL.equals(type)) {
            return mysql;
        }

        throw new IllegalArgumentException("db dialect not supported yet: " + dbType);
    }
}
