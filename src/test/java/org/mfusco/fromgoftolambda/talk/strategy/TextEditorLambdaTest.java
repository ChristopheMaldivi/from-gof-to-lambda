package org.mfusco.fromgoftolambda.talk.strategy;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mfusco.fromgoftolambda.talk.strategy.StrategyLambda.TextEditor;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class TextEditorLambdaTest {

    @Test
    public void editor_publish_text_with_formatter() {
        // given
        Predicate<String> errorPredicate = TextEditorLambdaTest::errorPredicate;
        UnaryOperator<String> errorFormatter = TextEditorLambdaTest::errorFormatter;
        TextEditor editor = new TextEditor(errorPredicate, errorFormatter);
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

    private static String errorFormatter(String text) {
        return text.toUpperCase();
    }

    private static boolean errorPredicate(String text) {
        return text.startsWith( "ERROR" );
    }
}