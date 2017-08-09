package org.mfusco.fromgoftolambda.talk.strategy;

import java.util.function.Predicate;

public class ErrorFilter implements Predicate<String>{

    @Override
    public boolean test(String message) {
        return message.startsWith("ERROR");
    }
}
