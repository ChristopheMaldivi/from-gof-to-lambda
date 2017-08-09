package org.mfusco.fromgoftolambda.talk.strategy;

import java.util.function.UnaryOperator;

public class UppercaseFormatter implements UnaryOperator<String>{


    @Override
    public String apply(String message) {
        return message.toUpperCase();
    }
}
