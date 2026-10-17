# 一、VS Code 配置层级

VS Code 的配置主要分为用户设置和工作区设置。用户设置通常适用于当前用户打开的所有项目；工作区设置则针对当前项目或工作区，并可在适用范围内覆盖对应的用户设置。Java 或 Quarkus 项目的编辑、调试和任务功能，会依据最终生效的 VS Code 配置提供支持。

VS Code 官方文档区分了用户设置（User Settings）与工作区设置（Workspace Settings）。通常，同一配置项的工作区设置优先于用户设置，但部分配置项受适用范围限制。

## 1. 用户设置（User Settings）

在 Windows 上，用户设置文件通常位于：

```text
C:\Users\<用户名>\AppData\Roaming\Code\User\settings.json
```

也可以按 `Ctrl + Shift + P` 打开命令面板，然后执行 **Preferences: Open User Settings (JSON)** 打开该文件。

例如：

```json
{
  "editor.fontSize": 14,
  "editor.formatOnSave": true
}
```

这些设置默认会影响当前用户打开的其他 VS Code 项目。

## 2. 工作区设置（Workspace Settings）

项目级设置通常保存在项目根目录下的 `.vscode/settings.json` 文件中。例如：

```text
D:\GitHub\dtu-pay-rebuild\
└── .vscode\
    └── settings.json
```

该文件中的设置主要作用于当前项目。假设用户设置中包含：

```json
{
  "editor.tabSize": 4
}
```

而 DTU Pay 项目的 `.vscode/settings.json` 中包含：

```json
{
  "editor.tabSize": 2
}
```

在该配置项适用于工作区的情况下，打开 DTU Pay 项目时通常会采用工作区设置中的 `2`，而不是用户设置中的 `4`。

这种方式便于团队共享项目相关的编辑器配置，同时保留每位开发者的个人用户设置。