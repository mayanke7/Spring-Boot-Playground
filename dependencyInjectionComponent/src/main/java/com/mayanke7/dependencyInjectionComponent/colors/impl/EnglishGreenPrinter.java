package com.mayanke7.dependencyInjectionComponent.colors.impl;

import com.mayanke7.dependencyInjectionComponent.colors.GreenPrinter;
import org.springframework.stereotype.Service;


@Service
public class EnglishGreenPrinter implements GreenPrinter {

    @Override
    public  String print(){
        return "Green";
    }
}
