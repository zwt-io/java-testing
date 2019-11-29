package io.zwt.testing.m5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Tao on 2019-11-29.
 * 一个手写的测试
 */
public class SalesAnalysisServiceWithHandWrittenStubTest {

    // 这是待测试的对象，一些假的数据，Stub，桩
    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Apples", "Cardiff", 10, 2),
            new Sale("Oranges", "Cardiff", 3, 5),
            new Sale("Bananas", "Cardiff", 6, 20),
            new Sale("Oranges", "London", 5, 7)
    );

    // 期望的结果
    private static final Map<String, Integer> expectedStoreSales = new HashMap<>();
    private static final Map<String, Integer> expectedProductSales = new HashMap<>();
    static {
        expectedStoreSales.put("Cardiff", 155);
        expectedStoreSales.put("London", 35);
        expectedProductSales.put("Apples", 20);
        expectedProductSales.put("Oranges", 50);
        expectedProductSales.put("Bananas", 120);
    }

    @Test
    public void shouldAggregateStoreSales() {

        // given
        SalesRepository stubRepository = () -> exampleSales;
        SalesAnalysisService analysisService = new SalesAnalysisService(stubRepository);

        // when
        Map<String, Integer> storeSales = analysisService.tallyStoreSales();

        // then
        assertEquals(expectedStoreSales, storeSales, "Calculated wrong store sales");
    }

    @Test
    public void shouldAggregateProductSales() {

        // given
        SalesRepository stubRepository = () -> exampleSales;
        SalesAnalysisService analysisService = new SalesAnalysisService(stubRepository);

        // when
        Map<String, Integer> productSales = analysisService.tallyProductSales();

        // then
        assertEquals(expectedProductSales, productSales, "Calculated wrong store sales");
    }
}
