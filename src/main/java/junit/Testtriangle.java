package junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class Testtriangle {

    private Rtriangle triangle;

    @Before
    public void setUp() {
        triangle = RtriangleProvider.getRtriangle();
    }

    @Test
    public void test() {

        boolean check = ((triangle.getApexX1() == triangle.getApexX2() && triangle.getApexY2() == triangle.getApexY1())||
                (triangle.getApexX2()== triangle.getApexX3() && triangle.getApexY2() == triangle.getApexY3()) ||
                (triangle.getApexX1() == triangle.getApexX3() && triangle.getApexY3() == triangle.getApexY1()) ||
                (triangle.getApexX1() == triangle.getApexX2() && triangle.getApexX2() == triangle.getApexX3()) ||
                (triangle.getApexY1() == triangle.getApexY2() && triangle.getApexY2() == triangle.getApexY3()) ||
                (triangle == null));
        double cosA = ((triangle.getApexX2() - triangle.getApexX1()) * (triangle.getApexX3() - triangle.getApexX1()) +
                (triangle.getApexY2() - triangle.getApexY1()) * (triangle.getApexY3() - triangle.getApexY1())) /
                (Math.sqrt(Math.pow(triangle.getApexX2() - triangle.getApexX1(), 2) +
                        Math.pow(triangle.getApexY2() - triangle.getApexY1(), 2)) *
                        Math.sqrt(Math.pow(triangle.getApexX3() - triangle.getApexX1(), 2) +
                                Math.pow(triangle.getApexY3() - triangle.getApexY1(), 2)));

        double cosB = ((triangle.getApexX1() - triangle.getApexX2()) * (triangle.getApexX3() - triangle.getApexX2()) +
                (triangle.getApexY1() - triangle.getApexY2()) * (triangle.getApexY3() - triangle.getApexY2())) /
                (Math.sqrt(Math.pow(triangle.getApexX1() - triangle.getApexX2(), 2) +
                        Math.pow(triangle.getApexY1() - triangle.getApexY2(), 2)) *
                        Math.sqrt(Math.pow(triangle.getApexX3() - triangle.getApexX2(), 2) +
                                Math.pow(triangle.getApexY3() - triangle.getApexY2(), 2)));
        double cosC = ((triangle.getApexX1() - triangle.getApexX3()) * (triangle.getApexX2() - triangle.getApexX3()) +
                (triangle.getApexY1() - triangle.getApexY3()) * (triangle.getApexY2() - triangle.getApexY3())) /
                (Math.sqrt(Math.pow(triangle.getApexX1() - triangle.getApexX3(), 2) +
                        Math.pow(triangle.getApexY1() - triangle.getApexY3(), 2)) *
                        Math.sqrt(Math.pow(triangle.getApexX2() - triangle.getApexX3(), 2) +
                                Math.pow(triangle.getApexY2() - triangle.getApexY3(), 2)));
        boolean trian = ( (cosA == 0 && cosB !=0 && cosC != 0) ||
                (cosA != 0 && cosB == 0 && cosC != 0) || (cosA != 0 && cosB != 0 && cosC == 0));
        Assert.assertTrue(!check && trian);



    }
}


//Calculate distance between points
//        double a = Math.sqrt( Math.pow(triangle.getApexX2()-triangle.getApexX1(), 2) +
//                Math.pow(triangle.getApexY2()-triangle.getApexY1(), 2));
//        double b = Math.sqrt( Math.pow(triangle.getApexX3()-triangle.getApexX2(), 2) +
//                Math.pow(triangle.getApexY3()-triangle.getApexY2(), 2));
//        double c = Math.sqrt(Math.pow(triangle.getApexX3() - triangle.getApexX1(), 2) +
//                Math.pow(triangle.getApexY3() - triangle.getApexY1(), 2));
//        //Math.pow sum of two catets
//        double ab = Math.pow(a, 2) + Math.pow(b, 2);
//        double ac = Math.pow(a, 2) + Math.pow(c, 2);
//        double bc = Math.pow(b, 2) + Math.pow(c, 2);
//        //Math.pow gipotenuza
//        double gipA = Math.pow(c, 2);
//        double gipB = Math.pow(b, 2);
//        double gipC = Math.pow(a, 2);
//
//        //Compare doubles
//        boolean bA = Math.abs(ab - gipA) < 0.00000000001;
//        boolean cA = Math.abs(ac - gipB) < 0.00000000001;
//        boolean cB = Math.abs(bc - gipC) < 0.00000000001;
//
//        //Result test
//        Assert.assertTrue(bA || cA || cB);



//        //A Vector
//        int vectorA = ((triangle.getApexX2() - triangle.getApexX1() * (triangle.getApexX3() - triangle.getApexX1())) +
//                ((triangle.getApexY2() - triangle.getApexY1()) * (triangle.getApexY3() - triangle.getApexY1())));
//        //B Vector
//        int vectorB = ((triangle.getApexX1() - triangle.getApexX2() * (triangle.getApexX3() - triangle.getApexX2())) +
//                ((triangle.getApexY1() - triangle.getApexY2()) * (triangle.getApexY3() - triangle.getApexY2())));
//        //C Vector
//        int vectorC = ((triangle.getApexX2() - triangle.getApexX3() * (triangle.getApexX1() - triangle.getApexX3())) +
//                ((triangle.getApexY2() - triangle.getApexY3()) * (triangle.getApexY1() - triangle.getApexY3())));





// Cosinus
//
//    boolean check = ((triangle.getApexX1() == triangle.getApexX2() && triangle.getApexY2() == triangle.getApexY1())||
//            (triangle.getApexX2()== triangle.getApexX3() && triangle.getApexY2() == triangle.getApexY3()) ||
//            (triangle.getApexX1() == triangle.getApexX3() && triangle.getApexY3() == triangle.getApexY1()) ||
//            (triangle.getApexX1() == triangle.getApexX2() && triangle.getApexX2() == triangle.getApexX3()) ||
//            (triangle.getApexY1() == triangle.getApexY2() && triangle.getApexY2() == triangle.getApexY3()) ||
//            (triangle == null));
//
//    double cosA = ((triangle.getApexX2() - triangle.getApexX1()) * (triangle.getApexX3() - triangle.getApexX1()) +
//            (triangle.getApexY2() - triangle.getApexY1()) * (triangle.getApexY3() - triangle.getApexY1())) /
//            (Math.sqrt(Math.pow(triangle.getApexX2() - triangle.getApexX1(), 2) +
//                    Math.pow(triangle.getApexY2() - triangle.getApexY1(), 2)) *
//                    Math.sqrt(Math.pow(triangle.getApexX3() - triangle.getApexX1(), 2) +
//                            Math.pow(triangle.getApexY3() - triangle.getApexY1(), 2)));
//    double cosB = ((triangle.getApexX1() - triangle.getApexX2()) * (triangle.getApexX3() - triangle.getApexX2()) +
//            (triangle.getApexY1() - triangle.getApexY2()) * (triangle.getApexY3() - triangle.getApexY2())) /
//            (Math.sqrt(Math.pow(triangle.getApexX1() - triangle.getApexX2(), 2) +
//                    Math.pow(triangle.getApexY1() - triangle.getApexY2(), 2)) *
//                    Math.sqrt(Math.pow(triangle.getApexX3() - triangle.getApexX2(), 2) +
//                            Math.pow(triangle.getApexY3() - triangle.getApexY2(), 2)));
//    double cosC = ((triangle.getApexX1() - triangle.getApexX3()) * (triangle.getApexX2() - triangle.getApexX3()) +
//            (triangle.getApexY1() - triangle.getApexY3()) * (triangle.getApexY2() - triangle.getApexY3())) /
//            (Math.sqrt(Math.pow(triangle.getApexX1() - triangle.getApexX3(), 2) +
//                    Math.pow(triangle.getApexY1() - triangle.getApexY3(), 2)) *
//                    Math.sqrt(Math.pow(triangle.getApexX2() - triangle.getApexX3(), 2) +
//                            Math.pow(triangle.getApexY2() - triangle.getApexY3(), 2)));
//System.out.println("Sum : " + (cosA + cosB + cosC));
//        boolean trian = ( (Double.compare(cosA, 0) == 0 ) ||
//        (Double.compare(cosB, 0) == 0 ) ||
//        Double.compare(cosC, 0) == 0);
//        Assert.assertTrue(!check && trian);
