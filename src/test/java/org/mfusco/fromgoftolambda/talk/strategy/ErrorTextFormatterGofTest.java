package org.mfusco.fromgoftolambda.talk.strategy;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mfusco.fromgoftolambda.examples.strategy.StrategyGof.ErrorTextFormatter;

public class ErrorTextFormatterGofTest {

    @Test
    public void filter_error() {
        // given
        ErrorTextFormatter formatter = new ErrorTextFormatter();
        String expectedErrorText = "ERROR I am an error";

        // when
        boolean filtered = formatter.filter(expectedErrorText);

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
    public void format_error_to_upper_case() {
        // given
        ErrorTextFormatter formatter = new ErrorTextFormatter();
        String errorText = "ERROR I am an error";
        String expectedErrorText = "ERROR I AM AN ERROR";

        // when
        String formatted = formatter.format(errorText);

        // then
        Assertions.assertThat(formatted).isEqualTo(expectedErrorText);
    }
}