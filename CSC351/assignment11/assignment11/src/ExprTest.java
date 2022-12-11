import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExprTest {
    int result;
    String stringResult;

    @Test
    void numberEvalWorks(){
        result = new Num(5).eval();
        Assertions.assertEquals(5, result);
    }
    @Test
    void addEvalWorks(){
        result = new Add(
                new Num(3),
                new Num(16)
        ).eval();

        Assertions.assertEquals(19, result);
    }
    @Test
    void divideEvalWorks(){
        result = new Divide(
                new Num(6),
                new Num(2)
        ).eval();

        Assertions.assertEquals(3, result);
    }
    @Test
    void positiveExplodeEvalWorks(){
        result = new Explode(
                new Num(5)
        ).eval();

        Assertions.assertEquals(15, result);
    }
    @Test
    void negativeExplodeEvalWorks(){
        result = new Explode(
                new Num(-5)
        ).eval();

        Assertions.assertEquals(-15, result);
    }
    @Test
    void multiplyEvalWorks(){
        result = new Multiply(
                new Num(5),
                new Num(10)
        ).eval();

        Assertions.assertEquals(50, result);
    }
    @Test
    void subtractEvalWorks(){
        result = new Subtract(
                new Num(5),
                new Num(2)
        ).eval();

        Assertions.assertEquals(3, result);
    }
    @Test
    void numberInfixWorks(){
        stringResult= new Num(3).infix();

        Assertions.assertEquals("3", stringResult);
    }
    @Test
    void addInfixWorks(){
        stringResult = new Add(
                new Num(5),
                new Num(5)
        ).infix();

        Assertions.assertEquals("5+5", stringResult);
    }
    @Test
    void divideInfixWorks(){
        stringResult = new Divide(
                new Num(6),
                new Num(2)
        ).infix();

        Assertions.assertEquals("6/2", stringResult);
    }
    @Test
    void explodeInfixWorks(){
        stringResult = new Explode(
                new Num(5)
        ).infix();

        Assertions.assertEquals("5#", stringResult);
    }
    @Test
    void multiplyInfixWorks(){
        stringResult = new Multiply(
                new Num(5),
                new Num(10)
        ).infix();

        Assertions.assertEquals("5*10", stringResult);
    }
    @Test
    void subtractInfixWorks(){
        stringResult = new Subtract(
                new Num(5),
                new Num(2)
        ).infix();

        Assertions.assertEquals("5-2", stringResult);
    }
    @Test
    void numberPrefixWorks(){
        stringResult= new Num(3).prefix();

        Assertions.assertEquals("3", stringResult);
    }
    @Test
    void addPrefixWorks(){
        stringResult = new Add(
                new Num(5),
                new Num(5)
        ).prefix();

        Assertions.assertEquals("+55", stringResult);
    }
    @Test
    void dividePrefixWorks(){
        stringResult = new Divide(
                new Num(6),
                new Num(2)
        ).prefix();

        Assertions.assertEquals("/62", stringResult);
    }
    @Test
    void explodePrefixWorks(){
        stringResult = new Explode(
                new Num(5)
        ).prefix();

        Assertions.assertEquals("#5", stringResult);
    }
    @Test
    void multiplyPrefixWorks(){
        stringResult = new Multiply(
                new Num(5),
                new Num(10)
        ).prefix();

        Assertions.assertEquals("*510", stringResult);
    }
    @Test
    void subtractPrefixWorks(){
        stringResult = new Subtract(
                new Num(5),
                new Num(2)
        ).prefix();

        Assertions.assertEquals("-52", stringResult);
    }
    @Test
    void nestedExpressionsEvalWorks(){
        result = new Add(
                new Subtract(
                        new Num(16),
                        new Multiply(
                                new Num(2),
                                new Num(4)
                        )
                ),
                new Divide(
                        new Num(660),
                        new Explode(
                                new Num(10)
                        )
                )
        ).eval();

        Assertions.assertEquals(20, result);
    }
    @Test
    void nestedExpressionsInfixWorks(){
        stringResult = new Add(
                new Subtract(
                        new Num(16),
                        new Multiply(
                                new Num(2),
                                new Num(4)
                        )
                ),
                new Divide(
                        new Num(660),
                        new Explode(
                                new Num(10)
                        )
                )
        ).infix();

        Assertions.assertEquals("16-2*4+660/10#", stringResult);
    }
    @Test
    void nestedExpressionsPrefixWorks(){
        stringResult = new Add(
                new Subtract(
                        new Num(16),
                        new Multiply(
                                new Num(2),
                                new Num(4)
                        )
                ),
                new Divide(
                        new Num(660),
                        new Explode(
                                new Num(10)
                        )
                )
        ).prefix();

        Assertions.assertEquals("+-16*24/660#10", stringResult);
    }
}
