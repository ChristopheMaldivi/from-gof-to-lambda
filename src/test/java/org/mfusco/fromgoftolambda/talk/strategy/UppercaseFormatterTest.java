package org.mfusco.fromgoftolambda.talk.strategy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class UppercaseFormatterTest {

    @Test
    public void should_format_message_to_uppercase() {
        // Given
        UppercaseFormatter uppercaseFormatter = new UppercaseFormatter();

        // When
        String message = "a simple message";
        String uppercaseMessage = uppercaseFormatter.apply(message);

        // Then
        String expectedUppercaseMessage = "A SIMPLE MESSAGE";
        Assertions.assertThat(uppercaseMessage).isEqualTo(expectedUppercaseMessage);
    }
}
