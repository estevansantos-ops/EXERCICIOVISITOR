package br.com.exercicio.visitor.exporter;

import br.com.exercicio.visitor.report.ChartReport;
import br.com.exercicio.visitor.report.ImageReport;
import br.com.exercicio.visitor.report.TextReport;

public class PdfExporter implements ReportExporter {

    @Override
    public void export(TextReport report) {
        System.out.println("=== PDF | Relatório de Texto ===");
        System.out.println("[PDF] Gerando documento...");
        System.out.printf("  Título  : %s%n", report.getTitle());
        System.out.printf("  Conteúdo: %s%n", report.getBody());
        System.out.println("[PDF] Documento gerado com sucesso.");
        System.out.println();
    }

    @Override
    public void export(ImageReport report) {
        System.out.println("=== PDF | Relatório com Imagem ===");
        System.out.println("[PDF] Gerando documento com imagem embutida...");
        System.out.printf("  Título : %s%n", report.getTitle());
        System.out.printf("  Imagem : %s%n", report.getImageUrl());
        System.out.printf("  Legenda: %s%n", report.getCaption());
        System.out.println("[PDF] Documento gerado com sucesso.");
        System.out.println();
    }

    @Override
    public void export(ChartReport report) {
        System.out.println("=== PDF | Relatório de Gráfico ===");
        System.out.println("[PDF] Gerando documento com gráfico de linhas...");
        System.out.printf("  Título: %s%n", report.getTitle());
        for (int i = 0; i < report.getLabels().size(); i++) {
            System.out.printf("  %s -> %.2f%n",
                    report.getLabels().get(i), report.getValues().get(i));
        }
        System.out.println("[PDF] Documento gerado com sucesso.");
        System.out.println();
    }
}
