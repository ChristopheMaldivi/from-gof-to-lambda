package org.mfusco.fromgoftolambda.talk.strategy;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mfusco.fromgoftolambda.talk.strategy.StrategyGof.PlainTextFormatter;

public class PlainTextFormatterGofTest {


    @Test
    public void filter_nothing() {
        // given
        String text = "my wonderful test will not be filtered";
        PlainTextFormatter formatter = new PlainTextFormatter();

        // when
        boolean filtered = formatter.filter(text);

        // then
        Assertions.assertThat(filtered).isTrue();
    }

    @Test
    public void format_nothing() {
        // given
        String text = "my wonderful test will not be formatted";
        PlainTextFormatter formatter = new PlainTextFormatter();

        // when
        String formatted = formatter.format(text);

        // then
        Assertions.assertThat(formatted).isEqualTo(text);
    }
}