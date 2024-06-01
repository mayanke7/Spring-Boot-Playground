package com.mayanke7.dependencyInjectionConfigFile.colors.impl;

import com.mayanke7.dependencyInjectionConfigFile.colors.GreenPrinter;

public class EnglishGreenPrinter implements GreenPrinter {

    @Override
    public  String print(){
        return "Green";
    }
}
