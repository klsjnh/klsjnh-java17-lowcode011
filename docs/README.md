# docs — 知识库索引（低代码产品）

> 协议全集：[011.agreements.md](011.agreements.md)（跨语言通用：协作铁律 / 七步流程 / 目录语义 / 编号规则 / 归档规则 / 代码先行审查）。

## 阅读入口

| 文档 | 内容 |
|------|------|
| [../Agent.md](../Agent.md) | **项目门牌层**（先读）：进门先看什么、按什么顺序看 |
| [011.agreements.md](011.agreements.md) | **协议全集**（跨语言通用） |
| [013.api-contract.md](013.api-contract.md) | API 契约（信封六键 + 状态码 + 鉴权） |
| [015.project-info.md](015.project-info.md) | 项目信息（定位 / 技术栈 / 构建运行 / 依赖框架） |
| [016.coding-standards.md](016.coding-standards.md) | 编码规则（真实代码示例 + 门禁映射） |
| [017.tech-debt-redlines.md](017.tech-debt-redlines.md) | 技术债红线 |
| [019.backend-api-review.md](019.backend-api-review.md) | 后端接口质量评审 |

## 低代码知识库

[lowcode011/](lowcode011/)：

| 编号 | 内容 |
|------|------|
| 011 | 体系总览（metadata011 是什么 / 全链路 / 硬约定 / 代码索引） |
| 013 | 契约与数据模型（`MetadataContent` / `JulyMetadata` / MetaDTO） |
| 015 | 字段体系（`FieldType011` 逐个 + 字典字段） |
| 016 | 展示与服务（Display + Service） |
| 017 | 设计器（listModels/load/save/previewDdl） |
| 018 | 发布·数据同步·运行时·开放 API·模板 |
| 019 | 引擎重构（042 落地记录） |
| 020 | 低代码核心（业务规则） |
| 021 | 设计器与运行时（业务规则） |
| 022 | 元数据模板（业务规则） |
| 023 | 前端对接指南 |
| 025 | AI 低代码机制 |

## 需求三档

| 目录 | 内容（自本项目独立起编，三档各自连续） |
|------|------|
| [requirement011/](requirement011/) | 业务需求：011 业务建模 · 013 多入口建模 · 015 业务字段口径 · 016 字段对照（作废） · 017 模板多格式 · 018 同步抽象 · 019 目标库方言 |
| [requirement013/](requirement013/) | 技术方案：011 业务建模 · 013 多入口建模 · 015 业务字段口径 · 017 模板多格式 · 018 同步抽象 · 019 目标库方言 · 020 低代码核心 · 021 设计器与运行时 · 022 元数据模板 · 023 引擎重构 |
| [sql/](sql/) | 低代码 DDL（平台基表见框架仓库） |

## 边界

- 本仓是**低代码产品**，依赖框架 `klsjnh-java17-framework011` 的底座（信封 / 鉴权 / IAM / 数据源 / 存储 / AI / 导出）。
- **平台主题不在本仓做专题文档**，需要时引用框架仓库的 `docs/`。
- `archive011/`：历史工作日志归档。
