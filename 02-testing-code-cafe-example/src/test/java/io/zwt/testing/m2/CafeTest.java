package io.zwt.testing.m2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static io.zwt.testing.m2.CoffeeType.Espresso;
import static io.zwt.testing.m2.CoffeeType.Latte;

/**
 * Created by Tao on 2019-11-29.
 */
class CafeTest {

    public static final int NO_BEANS = 0;
    public static final int NO_MILK = 0;
    public static final int ESPRESSO_BEANS = Espresso.getRequiredBeans();

    private Cafe cafe;

    @BeforeEach
    public void before() {
        cafe = new Cafe();
    }

    @Test
    public void canBrewEspresso() {
        withBeans();

        Coffee coffee = cafe.brew(Espresso);

        assertThat(coffee, hasProperty("beans", equalTo(ESPRESSO_BEANS)));
        assertThat(coffee, hasProperty("milk", equalTo(NO_MILK)));
        assertEquals(Espresso, coffee.getType(), "Wrong coffee type");
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        withBeans();

        Coffee coffee = cafe.brew(Espresso);

        assertEquals(NO_BEANS, cafe.getBeansInStock());
    }

    @Test
    public void canBrewLatte() {
        withBeans();
        cafe.restockMilk(Latte.getRequiredMilk());

        Coffee coffee = cafe.brew(Latte);

        assertEquals(Latte, coffee.getType(), "Wrong coffee type");
    }

    @Test
    public void lattesRequiresMilk() {
        withBeans();

        assertThrows(IllegalStateException.class,
                () -> cafe.brew(Latte));
    }

    @Test
    public void mustRestockMilk() {
        assertThrows(IllegalArgumentException.class,
                () -> cafe.restockMilk(NO_MILK));
    }

    @Test
    public void mustRestockBeans() {
        assertThrows(IllegalArgumentException.class,
                () -> cafe.restockBeans(NO_BEANS));
    }

    private void withBeans() {
        cafe.restockBeans(ESPRESSO_BEANS);
    }
}
