package io.zwt.testing.m6;

import java.io.PrintStream;

/**
 * Created by Tao on 2019-11-29.
 */
public class SalesReportRunner {

    private final PrintStream out;

    public static void main(String[] args) {
        String fileLocation = args[0];
        new SalesReportRunner(System.out).run(fileLocation);
    }

    public SalesReportRunner(final PrintStream out) {
        this.out = out;
    }

    public void run(String fileLocation) {
        SalesRepository repo = new SalesRepository(fileLocation);
        SalesAnalyser analyser = new SalesAnalyser(repo);
        SalesReport report = new SalesReport(analyser, out);
        report.run();
    }
}
