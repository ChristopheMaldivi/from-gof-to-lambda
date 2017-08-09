package org.mfusco.fromgoftolambda.talk.strategy;

import oracle.jvm.hotspot.jfr.ThreadGroupEntry;
import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.mfusco.fromgoftolambda.talk.Console;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ErrorFilterTest {

    @Test
    public void errorFilter_filter_error_message(){
        // Given
        ErrorFilter errorFilter = new ErrorFilter();

        // When
        String errorMessage = "ERROR - an error message";
        boolean isFiltered = errorFilter.test(errorMessage);

        // Then
        Assertions.assertThat(isFiltered).isTrue();
    }

    @Test
    public void errorFilter_does_not_filter_none_error_message(){
        // Given
        ErrorFilter errorFilter = new ErrorFilter();

        // When
        String infoMessage = "INFO - an info message which is not an ERROR";
        boolean isFiltered = errorFilter.test(infoMessage);

        // Then
        Assertions.assertThat(isFiltered).isFalse();
    }

}
