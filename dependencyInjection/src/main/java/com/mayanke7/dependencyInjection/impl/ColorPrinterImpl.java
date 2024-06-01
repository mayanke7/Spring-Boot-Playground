package com.mayanke7.dependencyInjection.impl;

import com.mayanke7.dependencyInjection.ColorPrinter;
import com.mayanke7.dependencyInjection.colors.*;
import com.mayanke7.dependencyInjection.colors.impl.*;

public class ColorPrinterImpl implements ColorPrinter {

    private BluePrinter bluePrinter;
    private RedPrinter redPrinter;
    private GreenPrinter greenPrinter;

    public ColorPrinterImpl(){
        this.bluePrinter= new EnglishBluePrinter();
        this.redPrinter= new EnglishRedPrinter();
        this.greenPrinter= new EnglishGreenPrinter();
    }

    @Override
    public String print() {
        return bluePrinter.print()+"--"+ greenPrinter.print() +"--"+ redPrinter.print();
    }
}
