package io.zwt.testing.m5;

import java.util.List;

/**
 * Created by Tao on 2019-11-29.
 */
// DDD Repository
// 具体可以替换成不同的实现
@FunctionalInterface
public interface SalesRepository {

    List<Sale> loadSales();
}
