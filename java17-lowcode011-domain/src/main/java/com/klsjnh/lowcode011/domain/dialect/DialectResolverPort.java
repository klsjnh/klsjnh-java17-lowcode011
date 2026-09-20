package com.klsjnh.lowcode011.domain.dialect;

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

/**
 * Resolves the target database dialect by an open string {@code dbType} code
 * (see {@code DatabaseTypes011}). The single home for "which dialect do we
 * speak"; unsupported types fail loudly instead of silently emitting MySQL SQL.
 * A new database is added by registering a dialect, not by editing this port.
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
     * @param dbType db type code, nullable (defaults to MySQL)
     * @return dialect
     */
    DialectPort resolve(String dbType);
}
