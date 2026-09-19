-- ============================================================
-- 低代码产品表：逻辑删除唯一键迁移（生成列 alive_*，墓碑不挡重插）
-- 说明：平台基表（july_user/july_menu/...）的唯一键治理归框架仓库，见其 docs/sql。
-- ============================================================

ALTER TABLE july_metadata
    ADD COLUMN alive_object_name VARCHAR(60) GENERATED ALWAYS AS (IF(dr = '0', object_name, NULL)) STORED,
    DROP INDEX uk_object_name,
    ADD UNIQUE KEY uk_object_name (alive_object_name);

ALTER TABLE july_business_modeling
    ADD COLUMN alive_model_code VARCHAR(60) GENERATED ALWAYS AS (IF(dr = '0', model_code, NULL)) STORED,
    ADD COLUMN alive_object_name VARCHAR(60) GENERATED ALWAYS AS (IF(dr = '0', object_name, NULL)) STORED,
    DROP INDEX uk_model_code,
    DROP INDEX uk_object_name,
    ADD UNIQUE KEY uk_model_code (alive_model_code),
    ADD UNIQUE KEY uk_object_name (alive_object_name);

ALTER TABLE july_metadata_field
    ADD COLUMN alive_key VARCHAR(200) GENERATED ALWAYS AS (IF(dr = '0', CONCAT_WS('#', pk_mt, field_code), NULL)) STORED,
    DROP INDEX uk_pk_mt_field_code,
    ADD UNIQUE KEY uk_pk_mt_field_code (alive_key);

ALTER TABLE july_metadata_display
    ADD COLUMN alive_key VARCHAR(200) GENERATED ALWAYS AS (IF(dr = '0', CONCAT_WS('#', pk_mt, display_code), NULL)) STORED,
    DROP INDEX uk_pk_mt_display_code,
    ADD UNIQUE KEY uk_pk_mt_display_code (alive_key);

ALTER TABLE july_metadata_service
    ADD COLUMN alive_key VARCHAR(200) GENERATED ALWAYS AS (IF(dr = '0', CONCAT_WS('#', pk_mt, service_code), NULL)) STORED,
    DROP INDEX uk_pk_mt_service_code,
    ADD UNIQUE KEY uk_pk_mt_service_code (alive_key);
