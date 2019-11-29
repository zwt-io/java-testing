package io.zwt.testing.guice;


import java.util.List;

/**
 * Created by Tao on 2019-11-29.
 */
@FunctionalInterface
public interface SalesRepository {

    List<Sale> loadSales();
}
