package br.com.exercicio.visitor.exporter;

import br.com.exercicio.visitor.report.ChartReport;
import br.com.exercicio.visitor.report.ImageReport;
import br.com.exercicio.visitor.report.TextReport;

public interface ReportExporter {
    void export(TextReport report);
    void export(ImageReport report);
    void export(ChartReport report);
}
