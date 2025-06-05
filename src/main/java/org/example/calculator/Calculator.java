package org.example.calculator;

public class Calculator {

    private CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int performAddition(int a, int b){
        return calculatorService.add(a, b);
    }
}
