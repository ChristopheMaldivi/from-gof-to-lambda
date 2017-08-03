package org.mfusco.fromgoftolambda.talk.strategy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ErrorTextFormatterGofTest {

    @Test
    public void filter_error() {
        // given
        StrategyGof.ErrorTextFormatter formatter = new StrategyGof.ErrorTextFormatter();
        String expectedErrorText = "ERROR I am an error";

        // when
        boolean filtered = formatter.filter(expectedErrorText);

        // then
        Assertions.assertThat(filtered).isTrue();
    }

    @Test
    public void do_not_filter_normal_text() {
        // given
        StrategyGof.ErrorTextFormatter formatter = new StrategyGof.ErrorTextFormatter();
        String text = "I am not an error";

        // when
        boolean filtered = formatter.filter(text);

        // then
        Assertions.assertThat(filtered).isFalse();
    }

    @Test
    public void format_error_to_upper_case() {
        // given
        StrategyGof.ErrorTextFormatter formatter = new StrategyGof.ErrorTextFormatter();
        String errorText = "ERROR I am an error";
        String expectedErrorText = "ERROR I AM AN ERROR";

        // when
        String formatted = formatter.format(errorText);

        // then
        Assertions.assertThat(formatted).isEqualTo(expectedErrorText);
    }
}