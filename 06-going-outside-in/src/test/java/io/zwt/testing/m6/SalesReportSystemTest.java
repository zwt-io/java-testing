package io.zwt.testing.m6;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by Tao on 2019-11-29.
 */
public class SalesReportSystemTest {

    @Test
    public void shouldPrintStoreReportForSampleData() {
        ApplicationRunner runner = new ApplicationRunner();

        String report = runner.run("src/main/resources/example-sales.csv");

        assertThat(report, containsString("- London          -    235 -"));
    }
}
