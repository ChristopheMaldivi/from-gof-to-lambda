package org.mfusco.fromgoftolambda.talk.strategy;

import java.util.Optional;

public class StrategyGof {

    interface TextFormatter {
        boolean filter( String text );
        String format( String text );
    }

    public static class PlainTextFormatter implements TextFormatter {

        @Override
        public boolean filter( String text ) {
            return true;

        }
        @Override
        public String format( String text ) {
            return text;
        }
    }

    public static class ErrorTextFormatter implements TextFormatter {

        @Override
        public boolean filter( String text ) {
            return text.startsWith( "ERROR" );

        }
        @Override
        public String format( String text ) {
            return text.toUpperCase();
        }
    }

    public static class ShortTextFormatter implements TextFormatter {

        @Override
        public boolean filter( String text ) {
            return text.length() < 20;

        }
        @Override
        public String format( String text ) {
            return text.toLowerCase();
        }
    }

    public static class TextEditor {
        private final TextFormatter textFormatter;

        public TextEditor(TextFormatter textFormatter) {
            this.textFormatter = textFormatter;
        }

        public Optional<String> publishText(String text) {
            return textFormatter.filter( text ) ?
                Optional.of(textFormatter.format( text )) :
                Optional.empty();
        }
    }

    public static void main( String[] args ) {
        TextEditor textEditor = new TextEditor( new ErrorTextFormatter() );
        log(
            textEditor.publishText( "ERROR - something bad happened" )
        );
        log(
            textEditor.publishText( "DEBUG - I'm here" )
        );
    }

    private static void log(Optional<String> text) {
        text.ifPresent(System.out::println);
    }
}
