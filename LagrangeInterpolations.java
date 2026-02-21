import java.math.BigInteger;
import java.util.*;

public class LagrangeInterpolations {

    static class Point {
        BigInteger x;   // decoded x
        BigInteger y;   // decoded y

        Point(BigInteger x, BigInteger y) {
            this.x = x;
            this.y = y;
        }
    }

    // ---------- DECODE FUNCTION ----------
    // Converts encoded string in given base to decimal BigInteger
    static BigInteger decode(String value, int base) {
        return new BigInteger(value, base);
    }

    // ---------- ENCODE FUNCTION ----------
    // Converts decimal BigInteger to encoded string in given base
    static String encode(BigInteger value, int base) {
        return value.toString(base);
    }

    public static void main(String[] args) {

        List<String[][]> testCases = new ArrayList<>();

        // ===== Test Case 1 (encoded y values) =====
        testCases.add(new String[][]{
                {"1", "6", "13444211440455345511"},
                {"2", "15", "aed7015a346d635"},
                {"3", "15", "6aeeb69631c227c"},
                {"4", "16", "e1b5e05623d881f"},
                {"5", "8", "316034514573652620673"},
                {"6", "3", "2122212201122002221120200210011020220200"},
                {"7", "3", "20120221122211000100210021102001201112121"}
        });

        // ===== Test Case 2 (simple polynomial) =====
        testCases.add(new String[][]{
                {"1", "10", "3"},
                {"2", "10", "7"},
                {"3", "10", "13"},
                {"4", "10", "21"},
                {"5", "10", "31"},
                {"6", "10", "43"},
                {"7", "10", "57"}
        });

        int tc = 1;
        for (String[][] rawPoints : testCases) {

            List<Point> points = new ArrayList<>();

            for (String[] p : rawPoints) {

                // Decode x and y
                BigInteger x = decode(p[0], 10);      // x always decimal
                int base = Integer.parseInt(p[1]);    // base of y
                BigInteger y = decode(p[2], base);    // decode y

                points.add(new Point(x, y));
            }

            BigInteger secret = lagrangeAtZero(points);
            System.out.println("Test Case " + tc + " → Constant term (c) = " + secret);
            tc++;
        }

        // Example: Encode the secret back (optional demo)
        BigInteger example = BigInteger.valueOf(100);
        System.out.println("Encoded 100 in base 16 = " + encode(example, 16));
    }

    // ---------- LAGRANGE INTERPOLATION @ x = 0 ----------
    static BigInteger lagrangeAtZero(List<Point> points) {

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
                numerator = numerator.multiply(xj.negate());
                denominator = denominator.multiply(xi.subtract(xj));
            }

            result = result.add(yi.multiply(numerator.divide(denominator)));
        }

        return result;
    }
}