package io.zwt.testing.guice;

import javax.inject.Inject;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * 兼容 JSR-330 的依赖注入注解
 * Created by Tao on 2019-11-29.
 */
public class SalesAnalysisService {

    private final SalesRepository repo;


    @Inject
    public SalesAnalysisService(SalesRepository repo) {
        this.repo = repo;
    }

    public Map<String, Integer> tallyProductSales() {
        return tallySalesBy(Sale::getProduct);
    }

    public Map<String, Integer> tallyStoreSales() {
        return tallySalesBy(Sale::getStore);
    }

    private Map<String, Integer> tallySalesBy(Function<Sale, String> classifier) {
        return repo.loadSales()
                .stream()
                .collect(groupingBy(classifier,
                        summingInt(Sale::getValue)));
    }
}
