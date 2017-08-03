package org.mfusco.fromgoftolambda.talk.strategy;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mfusco.fromgoftolambda.talk.Console;

public class TextEditorGofTest {

    private class ConsoleImpl implements Console {
        String lastLog;

        @Override
        public void log(String message) {
            lastLog = message;
        }
    }

    @Test
    public void error_editor_publish_error_in_upper_case() {
        // given
        StrategyGof.ErrorTextFormatter formatter = new StrategyGof.ErrorTextFormatter();
        StrategyGof.TextEditor editor = new StrategyGof.TextEditor(formatter);
        String error = "ERROR text";
        String expectedError = "ERROR TEXT";

        // when
        ConsoleImpl console = new ConsoleImpl();
        editor.publishText(error, console);

        // then
        Assertions.assertThat(console.lastLog).isEqualTo(expectedError);
    }

    @Test
    public void error_editor_does_not_publish_normal_text() {
        // given
        StrategyGof.ErrorTextFormatter formatter = new StrategyGof.ErrorTextFormatter();
        StrategyGof.TextEditor editor = new StrategyGof.TextEditor(formatter);
        String normalText = "text";

        // when
        ConsoleImpl console = new ConsoleImpl();
        editor.publishText(normalText, console);

        // then
        Assertions.assertThat(console.lastLog).isNull();
    }
}

Bernard Abondance