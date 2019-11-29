package io.zwt.testing.m5;

/**
 * Created by Tao on 2019-11-29.
 */
// 一个简单 POJO 代表一笔销售
// 4 个字段，产品，商铺，数量，单价
public class Sale {

    private final String product;
    private final String store;
    private final int number;
    private final int pricePerItem;

    public Sale(String product, String store, int number, int pricePerItem) {
        this.product = product;
        this.store = store;
        this.number = number;
        this.pricePerItem = pricePerItem;
    }

    public String getProduct() {
        return product;
    }

    public String getStore() {
        return store;
    }

    public int getNumber() {
        return number;
    }

    public int getPricePerItem() {
        return pricePerItem;
    }

    public int getValue() {
        return getNumber() * getPricePerItem();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "product='" + product + '\'' +
                ", store='" + store + '\'' +
                ", number=" + number +
                ", pricePerItem=" + pricePerItem +
                '}';
    }
}
