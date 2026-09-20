# klsjnh-java17-lowcode011

Java 17 **纯血 DDD** 低代码**产品**工程 —— 元数据引擎 + 设计/发布/运行时/开放 API + 模板 + 多入口建模。**底座复用** [klsjnh-java17-framework011](../klsjnh-java17-framework011) 的 Maven 构件（common / domain / application / infrastructure / web），本项目只承载低代码域。

> AI 协作入口（门牌，先读）：[Agent.md](Agent.md) · 协议全集：[docs/011.agreements.md](docs/011.agreements.md) · 低代码知识库：[docs/lowcode011/](docs/lowcode011/) · 编码规则：[docs/016.coding-standards.md](docs/016.coding-standards.md)。

## 与框架的关系

```
┌──────────────────────────── 本项目 java17-lowcode011 ────────────────────────────┐
│  lowcode011-domain / application / infrastructure / web / app011                │
│  （元数据引擎 · 设计/发布/运行时/开放 API · 模板 · intake · 业务建模）              │
└───────────────▲──────────────────────────────────────────────────────────────────┘
                │ 依赖（Maven 构件，非源码拷贝）
┌───────────────┴────────────────── 框架 java17-framework011 ───────────────────────┐
│  common011 · domain011 · application011 · infrastructure011 · web011             │
│  （信封/异常/基座仓储/鉴权/IAM/system011/数据源内核+管理+方言/存储中心/AI 中心/导出）   │
└──────────────────────────────────────────────────────────────────────────────────┘
```

- 框架坐标：`com.klsjnh:java17-{common,domain,application,infrastructure,web}011:1.0.0`（需先 `mvn install`）。
- 本项目包名：`com.klsjnh.lowcode011.*`；端点前缀：`/klsjnh/lowcode011/**`（开放 API 另 `/klsjnh/open/**`）。

## 模块（5）

| 模块 | 层 | 内容 |
|------|-----|------|
| java17-lowcode011-domain | domain | 聚合 `JulyMetadata`（组合 `MetadataContent` 契约）· `JulyMetadataVersion/OpenApi/Source` · 模板 `TemplateCodec` · intake `ModelSourcePort` · 业务建模 `JulyBusinessModeling` · 端口/策略 |
| java17-lowcode011-application | application | 设计器 · 发布/DDL · 数据同步 · 运行时/开放 API · 模板（多格式）· intake 引擎（ai 一句话）· 业务建模（探针/执行/交接） |
| java17-lowcode011-infrastructure | infrastructure | 持久化（july_metadata* / july_business_modeling）· DDL 生成/执行 · 数据读写 · 模板编解码（JSON/CSV/Markdown）· 建模探针/推断 · 低代码配置 |
| java17-lowcode011-web | web | 各低代码 Controller + VO + 模板文件流 |
| java17-lowcode011-app011 | app | 唯一 main + 配置 + profile（端口 **11170**） |

## 技术栈

底座技术栈见框架 README；本项目额外：模板多格式编解码（JSON / CSV / Markdown，XLSX 预留）、AI 一句话开发（依赖框架 AI 中心 `aicenter` 的推理能力）。

## 快速开始

前置：JDK 17 · Maven 3.9+ · Node 18+（门禁脚本用）；并已 `mvn install` 框架构件。

```bash
mvn -o clean package -DskipTests      # 离线构建，产出 app011 可执行 jar
./script011.sh gate                   # 规范检查（正则 + AST）+ 离线编译
./script011.sh dev013                 # 杀进程 + 重新编译 + 启动（11170）
```

> 配置：`application.yml` 端口 **11170**、默认 development profile；数据库为 `klsjnh_lowcode011`（`application-development.yml` 入库，本机差异走忽略的 `application-local.yml`）。

## 能力与端点

| 能力 | 端点（前缀 `/klsjnh/lowcode011`） |
|------|-----------------------------------|
| 低代码核心 CRUD | `julyMetadata/v1/{insert,update,logicDelete,getById,getByObjectName,selectListByPage}` |
| 设计器 | `julyMetadata/v1/{listModels,load,save,previewDdl}` |
| 发布 / DDL | `julyMetadata/v1/publish` |
| 数据同步 | `julyMetadata/v1/{importDataFromSql,importStatus}` |
| 元数据模板（JSON/CSV/Markdown） | `julyMetadata/v1/{getTemplate011,downloadTemplate011,uploadTemplate011,deployObject}` |
| 多入口 intake（含 AI 一句话） | `intake/v1/{review,create}`（kind=sql/template/copy/modeling/ai） |
| 运行时数据面（JWT） | `runtime/v1/{getMeta,query,insert,update,delete}` |
| 开放 API（`X-Api-Key`） | `/klsjnh/open/v1/{getMeta,query,insert,update,delete}` |
| 业务建模（探针/执行） | `julyBusinessModeling/v1/*` |

## API 契约要点

所有端点统一六键信封（JSON 键 camelCase，禁改名/删除/重排）：`statusCode · message · errorMessage · timestamp · traceId · data`；`statusCode` 与 HTTP 一致；点查用 GET、写动作用 POST；入参具名 `*Vo011`。

## 编码规范要点

与框架一致：文件头 `/* TypeName */` 块；Javadoc 英文；`@Schema` 中文仅 web VO；DDL 注释中文；domain 零框架依赖；`@Transactional` 只在 application；PO 只在 infrastructure；逻辑删除 `dr`，唯一键只约束存活行（生成列 `alive_*`）；主键 `EntityId.generate()`。

## AI 协作（助手自述）

本仓库由 AI 编程助手协作开发，助手遵守本仓库门牌 [Agent.md](Agent.md) 与协议全集 [docs/011.agreements.md](docs/011.agreements.md)。

- **身份**：opencode —— 命令行 AI 编程助手；事实以仓库文档与实际运行结果为准，不臆测。
- **六条红线**：禁止主动提交 · 只读可自主 · 高危需授权 · 本机执行禁沙箱 · **底层只读** · 代码先行审查。
- **底层只读**：相邻的底座 / 框架工程（`klsjnh-java17-framework011` 等）**只读禁改**；底座缺陷只输出说明交底座侧处理（条款见 `docs/011.agreements.md` §011.铁律 · 019）。
- **验证纪律**：改动后必过 `./script011.sh gate`（规范 + 离线编译）并启动自测；长命令脱钩执行（后台运行 + 输出写日志）。
- **文档同步**：代码与文档（`docs/`）同改，一个事实只有一个家。

## 版本

`com.klsjnh:java17-lowcode011:1.0.0`（开发中），依赖框架 `1.0.0`（当前底座已重构为 AI 中心 `aicenter`）。
