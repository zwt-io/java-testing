package io.zwt.testing.guice;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Tao on 2019-11-29.
 */
@Data
@AllArgsConstructor
public class Sale {

    private final String product;
    private final String store;
    private final int number;
    private final int pricePerItem;

    // 这个方法需要的
    public int getValue() {
        return getNumber() * getPricePerItem();
    }
}
