package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

// 判断一组不等式是否满足约束并输出最大差
public class HuaWeiB20251 {

    public static void main(String[] args) {
        // String sample = "2.3,3,5.6,7,6;11,3,8.6,25,1;0.3,9,5.3,66,7.8;1,3,2,7,5;340,670,80.6;<=,<=,<=";
        String sample = "2.36,3,6,7.1,6;1,30,8.6,2.5,21;0.3,69,5.3,6.6,7.8;1,13,2,17,5;340,67,300.6;<=,>=,<=";
        System.setIn(new ByteArrayInputStream(sample.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String[][] input = Arrays.stream(scanner.nextLine().split(";")).map(s -> s.split(",")).toArray(String[][]::new);
        double[] coefficients1 = Arrays.stream(input[0]).mapToDouble(Double::parseDouble).toArray();
        double[] coefficients2 = Arrays.stream(input[1]).mapToDouble(Double::parseDouble).toArray();
        double[] coefficients3 = Arrays.stream(input[2]).mapToDouble(Double::parseDouble).toArray();
        int[] variables = Arrays.stream(input[3]).mapToInt(Integer::parseInt).toArray();
        double[] targets = Arrays.stream(input[4]).mapToDouble(Double::parseDouble).toArray();
        String[] constraints = input[5];

        double difference1 = coefficients1[0] * variables[0] + coefficients1[1] * variables[1] + coefficients1[2] * variables[2] + coefficients1[3] * variables[3] + coefficients1[4] * variables[4] - targets[0];
        double difference2 = coefficients2[0] * variables[0] + coefficients2[1] * variables[1] + coefficients2[2] * variables[2] + coefficients2[3] * variables[3] + coefficients2[4] * variables[4] - targets[1];
        double difference3 = coefficients3[0] * variables[0] + coefficients3[1] * variables[1] + coefficients3[2] * variables[2] + coefficients3[3] * variables[3] + coefficients3[4] * variables[4] - targets[2];

        boolean flag = verifyInequality(difference1, constraints[0]) && verifyInequality(difference2, constraints[1]) && verifyInequality(difference3, constraints[2]);
        double maxDiff = Math.max(Math.max(difference1, difference2), difference3);

        System.out.println(flag + " " + (int) maxDiff);

    }

    private static boolean verifyInequality(double value, String constraint) {
        switch (constraint) {
            case ">" -> {
                return value > 0;
            }
            case "<" -> {
                return value < 0;
            }
            case "=" -> {
                return value == 0;
            }
            case ">=" -> {
                return value >= 0;
            }
            case "<=" -> {
                return value <= 0;
            }
            default ->
                throw new IllegalArgumentException("Invalid constraint: " + constraint);
        }
    }
}
