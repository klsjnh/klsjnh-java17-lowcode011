package com.klsjnh.lowcode011.domain;

/*                DialectPort interface
 *
 *      @author     xiangrkrs@163.com
 *      @version    ver 0.0.1
 *      @createdate 2026.09.19
 *      @modifydate
 *
 *===========================================
 *          modify history
 *
 *      2026.09.19  target db dialect port
 *
 */

/**
 * One target database dialect: the DDL generator, the schema executor and the
 * data writer for a single {@code DatabaseType011}. The engine resolves the
 * dialect by the target db type, so adding Oracle / SQLServer means adding an
 * implementation rather than touching the use cases.
 */

public interface DialectPort {

    /**
     * DDL generator (create table / add columns).
     *
     * @return ddl generator
     */
    MetadataDdlGeneratorPort ddlGenerator();

    /**
     * Schema executor (table exists / columns / execute ddl).
     *
     * @return schema executor
     */
    MetadataDdlExecutorPort ddlExecutor();

    /**
     * Data writer (upsert into the physical table).
     *
     * @return data writer
     */
    MetadataDataWriterPort dataWriter();
}
