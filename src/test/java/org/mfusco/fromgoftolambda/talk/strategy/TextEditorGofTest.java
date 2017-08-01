package org.mfusco.fromgoftolambda.talk.strategy;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mfusco.fromgoftolambda.talk.strategy.StrategyGof.ErrorTextFormatter;
import org.mfusco.fromgoftolambda.talk.strategy.StrategyGof.TextEditor;

import java.util.Optional;

public class TextEditorGofTest {

    @Test
    public void editor_publish_text_with_formatter() {
        // given
        ErrorTextFormatter formatter = new ErrorTextFormatter();
        TextEditor editor = new TextEditor(formatter);
        String error = "ERROR text";
        String normal = "text";

        // when
        Optional<String> publishedError = editor.publishText(error);
        Optional<String> publishedNormal = editor.publishText(normal);

        // then
        Assertions.assertThat(publishedError.isPresent()).isTrue();
        Assertions.assertThat(publishedError.get()).isEqualTo("ERROR TEXT");
        Assertions.assertThat(publishedNormal.isPresent()).isFalse();
    }

}