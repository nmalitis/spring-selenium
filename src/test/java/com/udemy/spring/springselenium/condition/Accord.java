package com.udemy.spring.springselenium.condition;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
//@ConditionalOnExpression("${car.speed} >= 70")
@Qualifier("accord")
public class Accord implements Car{

    @Override
    public void run() {
        System.out.println("This is Accord. Speed is 80mph");
    }
}
