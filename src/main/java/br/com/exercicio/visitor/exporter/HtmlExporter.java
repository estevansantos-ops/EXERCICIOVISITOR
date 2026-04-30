package br.com.exercicio.visitor.exporter;

import br.com.exercicio.visitor.report.ChartReport;
import br.com.exercicio.visitor.report.ImageReport;
import br.com.exercicio.visitor.report.TextReport;

public class HtmlExporter implements ReportExporter {

    @Override
    public void export(TextReport report) {
        System.out.println("=== HTML | Relatório de Texto ===");
        System.out.println("<html>");
        System.out.println("  <body>");
        System.out.printf("    <h1>%s</h1>%n", report.getTitle());
        System.out.printf("    <p>%s</p>%n", report.getBody());
        System.out.println("  </body>");
        System.out.println("</html>");
        System.out.println();
    }

    @Override
    public void export(ImageReport report) {
        System.out.println("=== HTML | Relatório com Imagem ===");
        System.out.println("<html>");
        System.out.println("  <body>");
        System.out.printf("    <h1>%s</h1>%n", report.getTitle());
        System.out.printf("    <img src=\"%s\" alt=\"%s\"/>%n", report.getImageUrl(), report.getCaption());
        System.out.printf("    <p>%s</p>%n", report.getCaption());
        System.out.println("  </body>");
        System.out.println("</html>");
        System.out.println();
    }

    @Override
    public void export(ChartReport report) {
        System.out.println("=== HTML | Relatório de Gráfico ===");
        System.out.println("<html>");
        System.out.println("  <body>");
        System.out.printf("    <h1>%s</h1>%n", report.getTitle());
        System.out.println("    <table border=\"1\">");
        System.out.println("      <tr><th>Label</th><th>Valor</th></tr>");
        for (int i = 0; i < report.getLabels().size(); i++) {
            System.out.printf("      <tr><td>%s</td><td>%.2f</td></tr>%n",
                    report.getLabels().get(i), report.getValues().get(i));
        }
        System.out.println("    </table>");
        System.out.println("  </body>");
        System.out.println("</html>");
        System.out.println();
    }
}
