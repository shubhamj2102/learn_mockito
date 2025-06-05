package calculator_test;

import org.example.calculator.Calculator;
import org.example.calculator.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    private Calculator calculator;
    private CalculatorService calculatorService = mock(CalculatorService.class);

    @BeforeEach
    void init() {
        this.calculator = new Calculator(calculatorService);
    }

    @Test
    void performAdditionTest() {
        when(calculatorService.add(2, 3)).thenReturn(5);
        assertEquals(5, calculator.performAddition(2, 3));
        verify(calculatorService).add(2, 3);
    }
}
