package org.mfusco.fromgoftolambda.talk.strategy;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class StrategyLambda {

    static class TextEditor {
        private final Predicate<String> predicate;
        private final UnaryOperator<String> formatter;

        public TextEditor(Predicate<String> predicate, UnaryOperator<String> formatter) {
            this.predicate = predicate;
            this.formatter = formatter;
        }

        public Optional<String> publishText(String text) {
            return predicate.test(text) ?
                Optional.of(formatter.apply(text)) :
                Optional.empty();
        }
    }

    public static void main( String[] args ) {
        TextEditor textEditor = new TextEditor( StrategyLambda::errorPredicate, StrategyLambda::errorFormatter );
        log(
            textEditor.publishText( "ERROR - something bad happened" )
        );
        log(
            textEditor.publishText( "DEBUG - I'm here" )
        );
    }

    private static String errorFormatter(String text) {
        return text.toUpperCase();
    }

    private static boolean errorPredicate(String text) {
        return text.startsWith( "ERROR" );
    }

    private static void log(Optional<String> text) {
        text.ifPresent(System.out::println);
    }
}
