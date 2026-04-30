package br.com.exercicio.visitor;

import br.com.exercicio.visitor.exporter.CsvExporter;
import br.com.exercicio.visitor.exporter.HtmlExporter;
import br.com.exercicio.visitor.exporter.PdfExporter;
import br.com.exercicio.visitor.exporter.ReportExporter;
import br.com.exercicio.visitor.report.ChartReport;
import br.com.exercicio.visitor.report.ImageReport;
import br.com.exercicio.visitor.report.Report;
import br.com.exercicio.visitor.report.TextReport;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Report> reports = List.of(
                new TextReport(
                        "Resumo Mensal",
                        "As vendas cresceram 12% em relação ao mês anterior."
                ),
                new ImageReport(
                        "Foto do Evento",
                        "https://exemplo.com/foto.jpg",
                        "Equipe reunida na conferência anual"
                ),
                new ChartReport(
                        "Desempenho Trimestral",
                        List.of("Jan", "Fev", "Mar"),
                        List.of(4200.0, 5100.0, 4800.0)
                )
        );

        List<ReportExporter> exporters = List.of(
                new HtmlExporter(),
                new CsvExporter(),
                new PdfExporter()
        );

        for (ReportExporter exporter : exporters) {
            for (Report report : reports) {
                report.accept(exporter);
            }
        }
    }
}
