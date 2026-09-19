# docs/sql — 低代码产品 DDL

> 本目录只承载**低代码产品**的表结构；**平台基表**（`july_user` / `july_menu` / `july_role` / `july_organization` / `july_scheduler` / `july_config` / `july_dictionary` / `july_ai_model_provider` / `july_storage` / `july_datasource`）由框架仓库 `klsjnh-java17-framework011` 的 `docs/sql` 维护。

## 文件

| 文件 | 表 |
|------|----|
| `july_metadata.sql` | 低代码核心：`july_metadata` + `_field` / `_display` / `_service`（一主三子） |
| `july_metadata_publish.sql` | 发布态列（`july_metadata` ALTER）+ `july_metadata_version` + `july_metadata_open_api` |
| `july_business_modeling.sql` | 业务建模 `july_business_modeling` |
| `logic-delete-unique-fix.sql` | 低代码表的逻辑删除唯一键迁移（生成列 `alive_*`） |
| `base-entity-columns.sql` | 公共列模板（仅说明，不执行） |

## 初始化顺序

1. **平台基表**：先按框架仓库 `docs/sql` 建好 `july_*` 基表（含 `logic-delete-unique-fix.sql`）。
2. **低代码表**：`july_metadata.sql` → `july_metadata_publish.sql` → `july_business_modeling.sql`。
3. **低代码唯一键迁移**：`logic-delete-unique-fix.sql`（建表后执行一次）。

## 运行时生成的表

- 低代码发布的物理表 `<objectName>`（本产品约定：**对象名即物理表名**，不加前缀）由运行时 `publish` 自动 `CREATE` / `ALTER ... ADD COLUMN` 生成（禁 `DROP`/`MODIFY`/`RENAME`），**不是手工 DDL**。见 [../lowcode011/018.topic-publish-runtime.md](../lowcode011/018.topic-publish-runtime.md)。
