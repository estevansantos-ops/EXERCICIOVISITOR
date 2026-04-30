package br.com.exercicio.visitor.exporter;

import br.com.exercicio.visitor.report.ChartReport;
import br.com.exercicio.visitor.report.ImageReport;
import br.com.exercicio.visitor.report.TextReport;

public class CsvExporter implements ReportExporter {

    @Override
    public void export(TextReport report) {
        System.out.println("=== CSV | Relatório de Texto ===");
        System.out.println("titulo,conteudo");
        System.out.printf("\"%s\",\"%s\"%n", report.getTitle(), report.getBody());
        System.out.println();
    }

    @Override
    public void export(ImageReport report) {
        System.out.println("=== CSV | Relatório com Imagem ===");
        System.out.println("titulo,imagem_url,legenda");
        System.out.printf("\"%s\",\"%s\",\"%s\"%n",
                report.getTitle(), report.getImageUrl(), report.getCaption());
        System.out.println();
    }

    @Override
    public void export(ChartReport report) {
        System.out.println("=== CSV | Relatório de Gráfico ===");
        System.out.println("titulo,label,valor");
        for (int i = 0; i < report.getLabels().size(); i++) {
            System.out.printf("\"%s\",\"%s\",%.2f%n",
                    report.getTitle(), report.getLabels().get(i), report.getValues().get(i));
        }
        System.out.println();
    }
}
