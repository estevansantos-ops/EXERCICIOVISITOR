package br.com.exercicio.visitor.report;

import br.com.exercicio.visitor.exporter.ReportExporter;

public class ImageReport implements Report {

    private final String title;
    private final String imageUrl;
    private final String caption;

    public ImageReport(String title, String imageUrl, String caption) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.caption = caption;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    @Override
    public void accept(ReportExporter exporter) {
        exporter.export(this);
    }
}
