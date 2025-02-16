package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;

public class LeetCode2435Test {

    public void numberOfPaths_validInput_returnNumberOfPath() {
        // given

        // when
        LeetCode2435 leetCode2435 = new LeetCode2435();
        int answer11 = leetCode2435.numberOfPaths1(new int[][]{{5, 2, 4}, {3, 0, 5}, {0, 7, 2}}, 3);
        int answer12 = leetCode2435.numberOfPaths1(new int[][]{{0, 0}}, 5);
        int answer13 = leetCode2435.numberOfPaths1(new int[][]{{7, 3, 4, 9}, {2, 3, 6, 2}, {2, 3, 7, 0}}, 1);
        int answer21 = leetCode2435.numberOfPaths2(new int[][]{{5, 2, 4}, {3, 0, 5}, {0, 7, 2}}, 3);
        int answer22 = leetCode2435.numberOfPaths2(new int[][]{{0, 0}}, 5);
        int answer23 = leetCode2435.numberOfPaths2(new int[][]{{7, 3, 4, 9}, {2, 3, 6, 2}, {2, 3, 7, 0}}, 1);
        int answer31 = leetCode2435.numberOfPaths3(new int[][]{{5, 2, 4}, {3, 0, 5}, {0, 7, 2}}, 3);
        int answer32 = leetCode2435.numberOfPaths3(new int[][]{{0, 0}}, 5);
        int answer33 = leetCode2435.numberOfPaths3(new int[][]{{7, 3, 4, 9}, {2, 3, 6, 2}, {2, 3, 7, 0}}, 1);
        int answer41 = leetCode2435.numberOfPaths4(new int[][]{{5, 2, 4}, {3, 0, 5}, {0, 7, 2}}, 3);
        int answer42 = leetCode2435.numberOfPaths4(new int[][]{{0, 0}}, 5);
        int answer43 = leetCode2435.numberOfPaths4(new int[][]{{7, 3, 4, 9}, {2, 3, 6, 2}, {2, 3, 7, 0}}, 1);

        // then
        Assertions.assertEquals(2, answer11);
        Assertions.assertEquals(1, answer12);
        Assertions.assertEquals(10, answer13);
        Assertions.assertEquals(2, answer21);
        Assertions.assertEquals(1, answer22);
        Assertions.assertEquals(10, answer23);
        Assertions.assertEquals(2, answer31);
        Assertions.assertEquals(1, answer32);
        Assertions.assertEquals(10, answer33);
        Assertions.assertEquals(2, answer41);
        Assertions.assertEquals(1, answer42);
        Assertions.assertEquals(10, answer43);
    }
}
