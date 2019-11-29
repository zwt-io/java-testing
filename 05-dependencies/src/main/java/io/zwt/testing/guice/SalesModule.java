package io.zwt.testing.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.io.PrintStream;

/**
 * 类似 Spring 的配置文件
 * 构造对象图的蓝图
 */
public class SalesModule extends AbstractModule {

    private final String fileLocation;

    public SalesModule(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    protected void configure() {
        bind(String.class)
                .annotatedWith(Names.named("fileLocation"))
                .toInstance(fileLocation);
        bind(PrintStream.class).toInstance(System.out);
        bind(SalesRepository.class).to(CsvSalesRepository.class);
    }
}
