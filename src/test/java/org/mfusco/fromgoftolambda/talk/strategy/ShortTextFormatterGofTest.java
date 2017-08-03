package org.mfusco.fromgoftolambda.talk.strategy;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mfusco.fromgoftolambda.talk.strategy.StrategyGof.ShortTextFormatter;

public class ShortTextFormatterGofTest {

    @Test
    public void long_text_min_length_should_be_20() {
        // given
        // when
        // then
        Assertions.assertThat(StrategyGof.LONG_TEXT_MIN_LENGTH).isEqualTo(20);
    }

    @Test
    public void filter_short_text_less_than_LONG_TEXT_MIN_LENGTH_chars() {
        // given
        String shortText = "ABCDEFGHIJKLMNOPQRS";
        ShortTextFormatter formatter = new ShortTextFormatter();

        // when
        boolean filtered = formatter.filter(shortText);

        // then
        Assertions.assertThat(filtered).isTrue();
    }

    @Test
    public void do_not_filter_long_text_longer_or_equal_to_LONG_TEXT_MIN_LENGTH_chars() {
        // given
        String longText = "ABCDEFGHIJKLMNOPQRST";
        ShortTextFormatter formatter = new ShortTextFormatter();

        // when
        boolean filtered = formatter.filter(longText);

        // then
        Assertions.assertThat(filtered).isFalse();
    }

    @Test
    public void format_short_text() {
        // given
        String shortText = "ABCDEFGHIJKLMNOPQRS";
        ShortTextFormatter formatter = new ShortTextFormatter();
        String expectedText = "abcdefghijklmnopqrs";

        // when
        String formatted = formatter.format(shortText);

        // then
        Assertions.assertThat(formatted).isEqualTo(expectedText);
    }
}