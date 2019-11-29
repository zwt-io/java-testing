package io.zwt.testing.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * 演示使用 Google Guice 做依赖注入
 * Created by Tao on 2019-11-29.
 */
public class GuiceReportRunner {


    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("必须在命令行参数指定要读入的数据");
            System.exit(-1);
        }

        Injector injector = Guice.createInjector(new SalesModule(args[0]));
        SalesReport report = injector.getInstance(SalesReport.class);
        report.report();


//        CsvSalesRepository repo = new CsvSalesRepository(args[0]);
//        repo.setError(System.err);

//        SalesAnalysisService analysisService = new SalesAnalysisService(repo);
//        SalesReport report = new SalesReport(System.out, analysisService);

    }
}
