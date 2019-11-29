package io.zwt.testing.m5;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tao on 2019-11-29.
 */
// 一个具体的 Repository 实现
// 这个是基于 CSV 实现的
public class CsvSalesRepository implements SalesRepository {

    private final String fileLocation;
    private PrintStream error;
    private List<Sale> sales;

    // 构造器注入
    public CsvSalesRepository(String fileLocation) {
        this.fileLocation = fileLocation;
        error = System.out;
    }

    // Setter 方法用于可选依赖的注入
    public void setError(PrintStream error) {
        this.error = error;
    }

    // 工具方法
    private int parseInt(String value) {
        return Integer.parseInt(value.trim());
    }

    // 具体的实现，基于 CSVReader 读取 csv 文件数据
    @Override
    public List<Sale> loadSales() {
        if (sales == null) {
            sales = new ArrayList<>();
            final File file = new File(fileLocation);

            if (!file.exists() || !file.canRead() || !file.isFile()) {
                System.err.println("找不到文件: " + file.getAbsolutePath());
            }

            try (CSVReader reader = new CSVReader(new FileReader(fileLocation))) {
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    String product = nextLine[0].trim();
                    String store = nextLine[1].trim();
                    int number = parseInt(nextLine[2]);
                    int pricePerItem = parseInt(nextLine[3]);

                    sales.add(new Sale(product, store, number, pricePerItem));
                }

                return sales;
            } catch (IOException | CsvValidationException e) {
                // 这边设置抛出异常时，错误信息往哪里输出
                e.printStackTrace(error);
                return null;
            }
        }

        return sales;
    }
}
