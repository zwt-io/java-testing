package io.zwt.testing.spring;

import io.zwt.testing.m5.Sale;

import java.util.List;

/**
 * Created by Tao on 2019-11-29.
 */
public interface SalesRepository {

    List<Sale> loadSales();
}
