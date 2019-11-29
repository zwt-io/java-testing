package io.zwt.testing.m5;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * Created by Tao on 2019-11-29.
 */
// 做销售分析的业务逻辑
public class SalesAnalysisService {

    private final SalesRepository repo;

    // 构造器注入一个 SalesRepository
    public SalesAnalysisService(SalesRepository repo) {
        this.repo = repo;
    }

    // 所有产品的销售
    public Map<String, Integer> tallyProductSales() {
        return tallySalesBy(Sale::getProduct);
    }

    // 所有店铺的销售
    public Map<String, Integer> tallyStoreSales() {
        return tallySalesBy(Sale::getStore);
    }

    // 私有方法，内部实现，函数式编程实现的计算，方法命名就很值观了，tallySalesBy.
    // 传入一个 Function<Sale, String> 作为一个通用的实现，根据传入的参数，分别计算按照店铺或产品销售额
    private Map<String, Integer> tallySalesBy(Function<Sale, String> classifier) {
        return repo.loadSales()
                .stream()
                .collect(groupingBy(classifier,
                        summingInt(Sale::getValue)));
    }
}
