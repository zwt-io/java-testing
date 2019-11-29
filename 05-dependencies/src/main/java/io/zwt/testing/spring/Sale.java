package io.zwt.testing.spring;

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

}
