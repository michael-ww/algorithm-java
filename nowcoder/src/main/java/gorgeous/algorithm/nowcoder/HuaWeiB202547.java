package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 分班问题
public class HuaWeiB202547 {

    public static void main(String[] args) {
        String input = "1/N 2/Y 3/N 4/Y 5/Y";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split(" ");
        List<Integer> classA = new ArrayList<>();
        List<Integer> classB = new ArrayList<>();
        boolean AClass = true, error = false;
        for (String child : children) {
            int idx = child.indexOf("/");
            int number = Integer.parseInt(child.substring(0, idx));
            char flag = child.charAt(idx + 1);

            if (number < 0 || number > 999) {
                error = true;
                break;
            }
            if (flag == 'N') {
                AClass = !AClass;
            }

            if (AClass) {
                classA.add(number);
            } else {
                classB.add(number);

            }

        }

        if (error) {
            System.out.println("ERROR");
        } else {
            classA.sort(Comparator.comparingInt(o -> o));
            classB.sort(Comparator.comparingInt(o -> o));

            if (classA.isEmpty() || (!classB.isEmpty() && classB.get(0) < classB.get(0))) {
                println(classB);
                println(classA);
            } else {
                println(classA);
                println(classB);
            }
        }
    }

    private static String println(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
