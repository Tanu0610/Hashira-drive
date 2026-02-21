import java.math.BigInteger;
import java.util.*;

public class LagrangeInterpolation {

    static class Point {
        BigInteger x;
        BigInteger y;

        Point(BigInteger x, BigInteger y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        int k = 7; // degree = 6

        String[][] rawPoints = {
                {"1", "6", "13444211440455345511"},
                {"2", "15", "aed7015a346d635"},
                {"3", "15", "6aeeb69631c227c"},
                {"4", "16", "e1b5e05623d881f"},
                {"5", "8", "316034514573652620673"},
                {"6", "3", "2122212201122002221120200210011020220200"},
                {"7", "3", "20120221122211000100210021102001201112121"}
        };

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            BigInteger x = new BigInteger(rawPoints[i][0]);
            int base = Integer.parseInt(rawPoints[i][1]);
            BigInteger y = new BigInteger(rawPoints[i][2], base);
            points.add(new Point(x, y));
        }

        BigInteger secret = lagrangeAtZero(points);
        System.out.println("Constant term (c) = " + secret);
    }

    // Lagrange interpolation evaluated at x = 0
    public static BigInteger lagrangeAtZero(List<Point> points) {

        BigInteger result = BigInteger.ZERO;
        int k = points.size();

        for (int i = 0; i < k; i++) {

            BigInteger xi = points.get(i).x;
            BigInteger yi = points.get(i).y;

            BigInteger numerator = BigInteger.ONE;
            BigInteger denominator = BigInteger.ONE;

            for (int j = 0; j < k; j++) {
                if (i == j) continue;

                BigInteger xj = points.get(j).x;

                numerator = numerator.multiply(xj.negate());      // (-xj)
                denominator = denominator.multiply(xi.subtract(xj));
            }

            BigInteger li = numerator.divide(denominator); // exact division
            result = result.add(yi.multiply(li));
        }

        return result;
    }
}