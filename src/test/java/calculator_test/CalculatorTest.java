package calculator_test;

import org.example.calculator.Calculator;
import org.example.calculator.CalculatorService;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    @InjectMocks
    private Calculator calculator;
    @Mock
    private CalculatorService calculatorService;
    @Spy
    private List<Integer> spiedList;


    @Test
    void performAdditionTest() {
       when(calculatorService.add(2, 3)).thenReturn(5);

        assertEquals(5, calculator.performAddition(2, 3));

        when(calculatorService.add(anyInt(),anyInt())).thenAnswer(invocationOnMock -> {
            int a=invocationOnMock.getArgument(0);
            int b=invocationOnMock.getArgument(1);
            return a+b;
        });
        assertEquals(11, calculator.performAddition(5, 6));

        verify(calculatorService).add(2, 3);
    }

    @Test
    void performAdditionTestWithVoidMethods(){
        //doNothing
        List<Integer> mockList=mock(List.class);
        doNothing().when(mockList).clear();
        mockList.clear();
    }

    @Test
    void performAdditionTestWithVoidMethods2(){
        //doNothing
        List<Integer> mockList=mock(List.class);
        doThrow(new RuntimeException("this is test of doThrow")).when(mockList).clear();
        assertThrows(RuntimeException.class,()->mockList.clear());
    }


    @Test
    void performAdditionTestWithVoidMethods3(){
        List<Integer> mockList=mock(List.class);
        doAnswer(invocationOnMock -> {
            System.out.println("This is doAnswer test");
            return 5;
        }).when(calculatorService).add(2,3);

        assertEquals(5,calculator.performAddition(2,3));
        verify(calculatorService).add(2,3);
    }

    @Test
    void testSpy(){
       spiedList= Mockito.spy(new ArrayList<>());
       /*
         spiedList=new ArrayList<>();-> this is wrong.
         it will be a normal object.
         So stubbing won't work.
         */
        spiedList.add(1);
        spiedList.add(2);
        assertEquals(2, spiedList.size());
       //when(spiedList.size()).thenReturn(100);
        doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());
    }



}
