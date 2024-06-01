package com.mayanke7.dependencyInjectionConfigFile.impl;

import com.mayanke7.dependencyInjectionConfigFile.ColorPrinter;
import com.mayanke7.dependencyInjectionConfigFile.colors.BluePrinter;
import com.mayanke7.dependencyInjectionConfigFile.colors.GreenPrinter;
import com.mayanke7.dependencyInjectionConfigFile.colors.RedPrinter;

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
