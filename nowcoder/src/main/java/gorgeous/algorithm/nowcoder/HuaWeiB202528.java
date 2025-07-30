package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.StringJoiner;

// 整理扑克牌
public class HuaWeiB202528 {

    public static void main(String[] args) {
        String input = "1 3 3 3 2 1 5";
        // String input = "4 4 2 1 2 1 3 3 3 4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String[] cards = scanner.nextLine().split(" ");
        int[] count = new int[14];
        for (String card : cards) {
            count[Integer.parseInt(card)]++;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = count.length - 1; i > 0; i--) {
            if (count[i] == 4) {
                for (int j = 0; j < count[i]; j++) {
                    sj.add(String.valueOf(i));
                }
                count[i] = 0;
            }
        }

        for (int i = count.length - 1; i > 0; i--) {
            if (count[i] == 3) {
                boolean combined = false;
                int j = count.length - 1;
                for (; j > 0; j--) {
                    if ((count[j] == 3 && i != j) || count[j] == 2) {
                        combined = true;
                        break;
                    }
                }
                if (combined) {
                    for (int k = 0; k < count[i]; k++) {
                        sj.add(String.valueOf(i));
                    }
                    for (int l = 0; l < 2; l++) {
                        sj.add(String.valueOf(j));
                    }
                    count[i] = 0;
                    count[j] = count[j] == 3 ? 1 : 0;
                }
            }
        }

        for (int i = count.length - 1; i > 0; i--) {
            if (count[i] == 3) {
                for (int j = 0; j < count[i]; j++) {
                    sj.add(String.valueOf(i));
                }
                count[i] = 0;
            }
        }

        for (int i = count.length - 1; i > 0; i--) {
            if (count[i] == 2) {
                for (int j = 0; j < count[i]; j++) {
                    sj.add(String.valueOf(i));
                }
                count[i] = 0;
            }
        }

        for (int i = count.length - 1; i > 0; i--) {
            if (count[i] == 1) {
                sj.add(String.valueOf(i));
                count[i] = 0;
            }
        }

        System.out.println(sj.toString());
    }
}
