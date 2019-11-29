package io.zwt.testing.m5;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Map;

/**
 * Created by Tao on 2019-11-29.
 */
public class SalesReport {

    private final PrintStream output;
    private final SalesAnalysisService analyser;

    public SalesReport(PrintStream output, SalesAnalysisService analyser) {
        this.output = output;
        this.analyser = analyser;
    }

    public void report() {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));

        output.printf("\n销售报告 %s\n%n", dateTime);

        printTable("店铺", analyser.tallyStoreSales());
        printTable("产品", analyser.tallyProductSales());
    }


    /**
     * 负责在控制台打印销售报告
     *
     * @param title 表格的标题
     * @param values 表格内容，每行是从一个 Map 里面提取
     */
    private void printTable(String title, Map<String, Integer> values) {
        output.printf("---------- %s ----------%n", title);
        printRow(title, "数值");
        values.forEach((key, value) -> printRow(key, "" + value));
        output.println();
        output.println();
    }

    /**
     * 控制每行内容的打印格式
     * @param first
     * @param second
     */
    private void printRow(String first, String second) {
        output.printf("- %s - \t\t - %s -%n", first, second);
    }
}
