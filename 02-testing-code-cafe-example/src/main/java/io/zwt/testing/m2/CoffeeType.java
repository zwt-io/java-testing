package io.zwt.testing.m2;

/**
 * Created by Tao on 2019-11-29.
 */
public enum CoffeeType {
    Espresso(7, 0),
    Latte(7, 227),
    FilteredCoffee(10, 0);

    private final int requiredBeans;
    private final int requiredMilk;

    CoffeeType(int requiredBeans, int requiredMilk) {
        this.requiredBeans = requiredBeans;
        this.requiredMilk = requiredMilk;
    }

    public int getRequiredBeans() {
        return requiredBeans;
    }

    public int getRequiredMilk() {
        return requiredMilk;
    }
}
