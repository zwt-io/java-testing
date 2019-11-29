package io.zwt.testing.m5;

/**
 * Created by Tao on 2019-11-29.
 */
public class SimpleReportRunner {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("必须在命令行参数指定要读入的数据");
            System.exit(-1);
        }

        // 构造器注入，不用在内部 new，只是作为构造器的参数注入
        CsvSalesRepository repo = new CsvSalesRepository(args[0]);
        // Optional dependency，setter 注入。用于指定错误输出的目的地，这里是标准错误输出，红色
        repo.setError(System.err);

        // 构造器注入
        SalesAnalysisService analysisService = new SalesAnalysisService(repo);
        // 构造器注入，第一个参数指定报告输出的目的地，这里是标准输出，白色
        SalesReport report = new SalesReport(System.out, analysisService);
        report.report();
    }
}
