package org.mfusco.fromgoftolambda.talk.strategy;

import java.util.function.Predicate;

public class Filters {
    private static final int SHORT_TEXT_MAX_LENGTH = 20;

    public static Predicate<String> errorFilter() {
        return text -> text.startsWith("ERROR");
    }

    public static Predicate<String> plaintextFilter() {
        return text -> true;
    }

    public static Predicate<String> shorttextFilter() {
        return text -> text.length() <= SHORT_TEXT_MAX_LENGTH;
    }
}
