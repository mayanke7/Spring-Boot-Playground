package com.mayanke7.dependencyInjectionComponent.colors.impl;

import com.mayanke7.dependencyInjectionComponent.colors.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishRedPrinter implements RedPrinter {

    @Override
    public String print(){
        return "Red";
    }
}
