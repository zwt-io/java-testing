package io.zwt.testing.m6;

import java.io.PrintStream;

/**
 * Created by Tao on 2019-11-29.
 */
public class SalesReport {
    private final SalesAnalyser analyser;
    private final PrintStream out;

    public SalesReport(SalesAnalyser analyser, PrintStream out) {

        this.analyser = analyser;
        this.out = out;
    }

    public void run() {
        analyser.tallyCitySales()
                .forEach((city, tally) -> {
            out.printf("- %-15s - %6.6s -%n", city, tally);
        });
    }
}
