package com.day7.solid_principles;

// High-level module that depends on an abstraction
class ReportGenerator {
    private ReportFormatter formatter;

    public ReportGenerator(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public void generateReport(String data) {
        String formattedData = formatter.formatData(data);
        System.out.println("Generated report: " + formattedData);
    }
}

// Abstraction that defines the formatData method
interface ReportFormatter {
    String formatData(String data);
}

// Concrete implementation of the ReportFormatter interface
class PdfFormatter implements ReportFormatter {
    public String formatData(String data) {
        return "PDF format: " + data;
    }
}

// Another concrete implementation of the ReportFormatter interface
class CsvFormatter implements ReportFormatter {
    public String formatData(String data) {
        return "CSV format: " + data;
    }
}

public class DIP {
    public static void main(String[] args) {
        // Create a ReportGenerator instance that depends on a PdfFormatter
        ReportGenerator reportGenerator = new ReportGenerator(new PdfFormatter());

        // Generate a report using the PdfFormatter
        reportGenerator.generateReport("Some report data");

        // Change the formatter to a CsvFormatter
        reportGenerator = new ReportGenerator(new CsvFormatter());

        // Generate a report using the CsvFormatter
        reportGenerator.generateReport("Some other report data");
    }
}
