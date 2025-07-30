package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 书籍叠放
public class HuaWeiB202542 {

    public static void main(String[] args) {
        String input = "[[20,16],[15,11],[10,10],[9,10]]";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().replaceAll("\\[|\\]", "").split(",")).mapToInt(Integer::parseInt).toArray();
        int[][] books = new int[array.length / 2][2];
        for (int i = 0; i < array.length / 2; i++) {
            books[i][0] = array[2 * i];
            books[i][1] = array[2 * i + 1];
        }

        Arrays.sort(books, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // int[] dp = new int[books.length];
        // Arrays.fill(dp, 1);
        // for (int i = 1; i < books.length; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (books[i][1] > books[j][1]) {
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //     }
        // }
        // System.out.println(Arrays.stream(dp).max());
        List<Integer> dp = new ArrayList<>();
        for (int[] book : books) {
            if (dp.isEmpty() || book[1] < dp.getLast()) {
                dp.addLast(book[1]);
            } else if (book[1] > dp.getFirst()) {
                dp.addFirst(book[1]);
            } else {
                int idx = Collections.binarySearch(dp, book[1], Comparator.reverseOrder());
                if (idx > 0) {
                    dp.set(idx, book[1]);
                }
            }
        }

        System.out.println(dp.size());
    }
}
