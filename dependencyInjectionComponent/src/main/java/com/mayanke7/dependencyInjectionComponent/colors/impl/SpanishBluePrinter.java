package com.mayanke7.dependencyInjectionComponent.colors.impl;

import com.mayanke7.dependencyInjectionComponent.colors.BluePrinter;
import org.springframework.stereotype.Component;

@Component
public class SpanishBluePrinter implements BluePrinter {

    @Override
    public String print() {
        return "Azul";
    }
}
