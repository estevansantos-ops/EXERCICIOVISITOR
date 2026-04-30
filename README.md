# Visitor — Conversor de Relatórios

Sistema de conversão de relatórios entre diferentes formatos de saída, implementado com o padrão de projeto **Visitor**.

## Visão geral

Qualquer um dos 3 tipos de relatório pode ser exportado em qualquer um dos 3 formatos de saída:

|                  | HTML | CSV | PDF |
|------------------|:----:|:---:|:---:|
| **Texto**        | ✓    | ✓   | ✓   |
| **Com Imagem**   | ✓    | ✓   | ✓   |
| **Com Gráfico**  | ✓    | ✓   | ✓   |

## Estrutura do projeto

```
src/main/java/br/com/exercicio/visitor/
├── Main.java
├── report/
│   ├── Report.java          # interface Visitable
│   ├── TextReport.java      # relatório de texto simples
│   ├── ImageReport.java     # relatório com imagem/mídia
│   └── ChartReport.java     # relatório com gráfico de dados
└── exporter/
    ├── ReportExporter.java  # interface Visitor
    ├── HtmlExporter.java    # exporta para HTML
    ├── CsvExporter.java     # exporta para CSV
    └── PdfExporter.java     # exporta para PDF
```

## Como o padrão Visitor foi aplicado

Cada `Report` implementa `accept(ReportExporter exporter)`, que chama `exporter.export(this)`. O compilador resolve o método correto pelo tipo concreto do relatório (*double dispatch*), eliminando qualquer `instanceof` ou cast.

```
Report.accept(exporter)
    └─> exporter.export(this)   // ex: HtmlExporter.export(ChartReport)
```

## Como executar

**Pré-requisitos:** Java 17+ e Maven 3+

```bash
mvn compile exec:java -Dexec.mainClass="br.com.exercicio.visitor.Main"
```
