package com.mayanke7.dependencyInjectionComponent.impl;

import com.mayanke7.dependencyInjectionComponent.ColorPrinter;
import com.mayanke7.dependencyInjectionComponent.colors.BluePrinter;
import com.mayanke7.dependencyInjectionComponent.colors.GreenPrinter;
import com.mayanke7.dependencyInjectionComponent.colors.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class ColorPrinterImpl implements ColorPrinter {

    private BluePrinter bluePrinter;
    private RedPrinter redPrinter;
    private GreenPrinter greenPrinter;

    public ColorPrinterImpl(BluePrinter bluePrinter, GreenPrinter greenPrinter, RedPrinter redPrinter){
        this.bluePrinter= bluePrinter;
        this.redPrinter= redPrinter;
        this.greenPrinter= greenPrinter;
    }

    @Override
    public String print(){
        return bluePrinter.print() + "--"+ redPrinter.print()+ "--"+ greenPrinter.print();
    }
}
