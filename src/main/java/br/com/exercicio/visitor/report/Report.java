package br.com.exercicio.visitor.report;

import br.com.exercicio.visitor.exporter.ReportExporter;

public interface Report {
    String getTitle();
    void accept(ReportExporter exporter);
}
