package br.com.exercicio.visitor.report;

import br.com.exercicio.visitor.exporter.ReportExporter;
import java.util.List;

public class ChartReport implements Report {

    private final String title;
    private final List<String> labels;
    private final List<Double> values;

    public ChartReport(String title, List<String> labels, List<Double> values) {
        this.title = title;
        this.labels = labels;
        this.values = values;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public List<String> getLabels() {
        return labels;
    }

    public List<Double> getValues() {
        return values;
    }

    @Override
    public void accept(ReportExporter exporter) {
        exporter.export(this);
    }
}
