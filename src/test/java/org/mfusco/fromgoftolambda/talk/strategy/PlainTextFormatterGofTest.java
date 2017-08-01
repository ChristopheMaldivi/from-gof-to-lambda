package org.mfusco.fromgoftolambda.talk.strategy;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mfusco.fromgoftolambda.examples.strategy.StrategyGof.PlainTextFormatter;

public class PlainTextFormatterGofTest {

    private String text = "my wonderful test will not be filtered";

    @Test
    public void filter_nothing() {
        // given
        PlainTextFormatter formatter = new PlainTextFormatter();

        // when
        boolean filtered = formatter.filter(text);

        // then
        Assertions.assertThat(filtered).isTrue();
    }

    @Test
    public void format_nothing() {
        // given
        PlainTextFormatter formatter = new PlainTextFormatter();

        // when
        String formatted = formatter.format(text);

        // then
        Assertions.assertThat(formatted).isEqualTo(text);
    }
}