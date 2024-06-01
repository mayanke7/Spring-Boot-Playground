package com.mayanke7.dependencyInjectionConfigFile.config;

import com.mayanke7.dependencyInjectionConfigFile.ColorPrinter;
import com.mayanke7.dependencyInjectionConfigFile.impl.ColorPrinterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mayanke7.dependencyInjectionConfigFile.colors.*;
import com.mayanke7.dependencyInjectionConfigFile.colors.impl.*;
@Configuration
public class PrinterConfig {

    @Bean
    public BluePrinter bluePrinter(){
        return new SpanishBluePrinter();
    }

    @Bean
    public RedPrinter redPrinter(){
        return new EnglishRedPrinter();
    }

    @Bean
    public GreenPrinter greenPrinter(){
        return new EnglishGreenPrinter();
    }
    @Bean
    public ColorPrinter colorPrinter(BluePrinter bluePrinter, GreenPrinter greenPrinter, RedPrinter redPrinter){
        return new ColorPrinterImpl(bluePrinter, greenPrinter,redPrinter);
    }
}
