package io.zwt.testing.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.io.PrintStream;

/**
 * Created by Tao on 2019-11-29.
 */
@Configuration
@PropertySource("application.properties")
@ComponentScan("io.zwt.testing.spring")
public class SpringReportRunner {

    private static String fileLocation;

    @Bean
    public String fileLocation() {
        return fileLocation;
    }

    @Bean
    @Profile({"out"})
    public PrintStream out() {
        return System.out;
    }

    @Bean
    @Profile("err")
    public PrintStream err() {
        return System.err;
    }

//    @Bean
//    @Profile("white")
//    public SalesRepository salesRepositoryWithStandardOutput() {
//        CsvSalesRepository csvSalesRepository = new CsvSalesRepository(fileLocation());
//        csvSalesRepository.setError(System.out);
//        return csvSalesRepository;
//    }
//
//    @Bean
//    @Profile("red")
//    public SalesRepository salesRepositoryWithErrorOutput() {
//        CsvSalesRepository csvSalesRepository = new CsvSalesRepository(fileLocation());
//        csvSalesRepository.setError(System.err);
//        return csvSalesRepository;
//    }


    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("必须在命令行参数指定要读入的数据");
            System.exit(-1);
        }

        fileLocation = args[0];

//        CsvSalesRepository repo = new CsvSalesRepository(args[0]);
//        repo.setError(System.err);

//        SalesAnalysisService analysisService = new SalesAnalysisService(repo);
//        SalesReport report = new SalesReport(System.out, analysisService);

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringReportRunner.class);
//        context.refresh();

        SalesReport report = context.getBean(SalesReport.class);
        report.report();

    }
}
