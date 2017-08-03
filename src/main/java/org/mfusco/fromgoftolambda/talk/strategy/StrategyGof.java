package org.mfusco.fromgoftolambda.talk.strategy;

import org.mfusco.fromgoftolambda.talk.Console;

public class StrategyGof {

    public static final int LONG_TEXT_MIN_LENGTH = 20;

    interface TextFormatter {
        boolean filter(String text);
        String format(String text);
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
            return text.length() < LONG_TEXT_MIN_LENGTH;

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

        public void publishText(String text, Console console) {
            if (textFormatter.filter( text )) {
                console.log(textFormatter.format(text));
            }
        }
    }

    public static void main( String[] args ) {
        TextEditor textEditor = new TextEditor( new ErrorTextFormatter() );
        Console console = new ConsoleImpl();
        textEditor.publishText( "ERROR - something bad happened", console);
        textEditor.publishText( "DEBUG - I'm here", console );
    }

    private static class ConsoleImpl implements Console {
        @Override
        public void log(String message) {
            System.out.println(message);
        }
    }
}
