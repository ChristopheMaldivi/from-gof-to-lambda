package org.mfusco.fromgoftolambda.talk.strategy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FiltersTest {

    @Test
    public void errorFilter_filters_error_message(){
        // Given
        String errorMessage = "ERROR - an error message";
        // When
        boolean isFiltered = Filters.errorFilter().test(errorMessage);

        // Then
        Assertions.assertThat(isFiltered).isTrue();
    }

    @Test
    public void errorFilter_does_not_filter_none_error_message(){
        // Given
        String infoMessage = "INFO - an info message which is not an ERROR";
        // When
        boolean isFiltered = Filters.errorFilter().test(infoMessage);

        // Then
        Assertions.assertThat(isFiltered).isFalse();
    }

    @Test
    public void plainttextFilter_filters_all_messages(){
        // Given
        String infoMessage = "INFO - an info message which is not an ERROR";
        String errorMessage = "ERROR - an error message";

        // When
        boolean isFilteredInfo = Filters.plaintextFilter().test(infoMessage);
        boolean isFilteredError = Filters.plaintextFilter().test(errorMessage);

        // Then
        Assertions.assertThat(isFilteredInfo).isTrue();
        Assertions.assertThat(isFilteredError).isTrue();
    }

    @Test
    public void shorttextFilter_filters_short_messages(){
        // Given
        String shortMessage = "this is short";

        // When
        boolean isFiltered = Filters.shorttextFilter().test(shortMessage);

        // Then
        Assertions.assertThat(isFiltered).isTrue();
    }

    @Test
    public void shorttextFilter_does_not_filter_long_messages(){
        // Given
        String shortMessage = "this is not a short message";

        // When
        boolean isFiltered = Filters.shorttextFilter().test(shortMessage);

        // Then
        Assertions.assertThat(isFiltered).isFalse();
    }
}
