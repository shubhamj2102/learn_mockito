package calculator_test;

import org.example.calculator.CalculatorService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PracticeTest {


    @Rule
    public ExpectedException thrown=ExpectedException.none();

    @Test
    public void RuleTest(){
        thrown.expect(IllegalAccessError.class);
        thrown.expectMessage("Invalid");
        var service=new CalculatorService(){

            @Override
            public Integer add(int a, int b) {
               throw new IllegalAccessError("Invalid");
            }
        };

        service.add(2,3);
    }
}
