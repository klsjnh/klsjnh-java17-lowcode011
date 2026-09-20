package com.klsjnh.lowcode011.domain.dialect;


import com.klsjnh.lowcode011.domain.metadata.MetadataDataWriterPort;
import com.klsjnh.lowcode011.domain.metadata.MetadataDdlExecutorPort;
import com.klsjnh.lowcode011.domain.metadata.MetadataDdlGeneratorPort;
/*                Dialect011 record
 *
 *      @author     xiangrkrs@163.com
 *      @version    ver 0.0.1
 *      @createdate 2026.09.19
 *      @modifydate
 *
 *===========================================
 *          modify history
 *
 *      2026.09.19  target db dialect record
 *
 */

/**
 * Target database dialect wiring: DDL generator + schema executor + data writer.
 *
 * @param ddlGenerator ddl generator
 * @param ddlExecutor  schema executor
 * @param dataWriter   data writer
 */

public record Dialect011(MetadataDdlGeneratorPort ddlGenerator, MetadataDdlExecutorPort ddlExecutor,
        MetadataDataWriterPort dataWriter) implements DialectPort {
}
