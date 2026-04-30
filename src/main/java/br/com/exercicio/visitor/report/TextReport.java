package br.com.exercicio.visitor.report;

import br.com.exercicio.visitor.exporter.ReportExporter;

public class TextReport implements Report {

    private final String title;
    private final String body;

    public TextReport(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public void accept(ReportExporter exporter) {
        exporter.export(this);
    }
}
