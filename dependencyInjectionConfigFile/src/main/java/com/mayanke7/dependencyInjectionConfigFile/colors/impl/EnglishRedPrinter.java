package com.mayanke7.dependencyInjectionConfigFile.colors.impl;

import com.mayanke7.dependencyInjectionConfigFile.colors.RedPrinter;

public class EnglishRedPrinter implements RedPrinter {

    @Override
    public String print(){
        return "Red";
    }
}
