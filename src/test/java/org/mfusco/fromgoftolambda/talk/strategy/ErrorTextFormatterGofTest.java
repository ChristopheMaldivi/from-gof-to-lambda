package org.mfusco.fromgoftolambda.talk.strategy;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mfusco.fromgoftolambda.examples.strategy.StrategyGof.ErrorTextFormatter;

public class ErrorTextFormatterGofTest {

    String errorText = "ERROR I am an error";

    @Test
    public void filter_error() {
        // given
        ErrorTextFormatter formatter = new ErrorTextFormatter();

        // when
        boolean filtered = formatter.filter(errorText);

        // then
        Assertions.assertThat(filtered).isTrue();
    }

    @Test
    public void do_not_filter_normal_text() {
        // given
        ErrorTextFormatter formatter = new ErrorTextFormatter();
        String text = "I am not an error";

        // when
        boolean filtered = formatter.filter(text);

        // then
        Assertions.assertThat(filtered).isFalse();
    }

    @Test
    public void format_error() {
        // given
        ErrorTextFormatter formatter = new ErrorTextFormatter();
        String expectedText = "ERROR I AM AN ERROR";

        // when
        String formatted = formatter.format(errorText);

        // then
        Assertions.assertThat(formatted).isEqualTo(expectedText);
    }
}