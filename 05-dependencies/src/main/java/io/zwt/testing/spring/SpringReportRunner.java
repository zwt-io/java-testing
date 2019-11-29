package io.zwt.testing.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.io.PrintStream;

/**
 * Created by Tao on 2019-11-29.
 */
@Configuration
@PropertySource("application.properties")
public class SpringReportRunner {

    private static String fileLocation;

    @Bean
    public String fileLocation() {
        return fileLocation;
    }

    @Bean
    @Profile("out")
    public PrintStream out() {
        return System.out;
    }

    @Bean
    @Profile("err")
    public PrintStream err() {
        return System.err;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("You must provide a commandline argument specifying the file to analyse");
            System.exit(-1);
        }

        fileLocation = args[0];

        ApplicationContext context = new AnnotationConfigApplicationContext("io.zwt.testing.spring");

//        CsvSalesRepository repo = new CsvSalesRepository(args[0]);
//        repo.setError(System.err);

//        SalesAnalysisService analysisService = new SalesAnalysisService(repo);
//        SalesReport report = new SalesReport(System.out, analysisService);

        SalesReport report = context.getBean(SalesReport.class);
        report.report();

    }
}
