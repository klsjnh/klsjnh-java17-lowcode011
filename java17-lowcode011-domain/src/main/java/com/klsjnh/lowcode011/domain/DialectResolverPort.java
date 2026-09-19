package com.klsjnh.lowcode011.domain;

/*                DialectResolverPort interface
 *
 *      @author     xiangrkrs@163.com
 *      @version    ver 0.0.1
 *      @createdate 2026.09.19
 *      @modifydate
 *
 *===========================================
 *          modify history
 *
 *      2026.09.19  target db dialect resolver port
 *
 */

import com.klsjnh.common.enums.DatabaseType011;

/**
 * Resolves the target database dialect by its {@code DatabaseType011}. The
 * single home for "which dialect do we speak"; unsupported types fail loudly
 * instead of silently emitting MySQL SQL.
 */

public interface DialectResolverPort {

    /**
     * Resolve the dialect of the configured target db type.
     *
     * @return dialect
     */
    DialectPort resolve();

    /**
     * Resolve the dialect of an explicit db type.
     *
     * @param type db type, nullable (defaults to MySQL)
     * @return dialect
     */
    DialectPort resolve(DatabaseType011 type);
}
