package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode474Test {

    @Test
    public void findMaxForm_validInput_returnMaxForm() {
        // given

        // when
        LeetCode474 leetCode474 = new LeetCode474();
        int answer11 = leetCode474.findMaxForm1(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        int answer12 = leetCode474.findMaxForm1(new String[]{"10", "0", "1"}, 1, 1);
        int answer21 = leetCode474.findMaxForm2(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        int answer22 = leetCode474.findMaxForm2(new String[]{"10", "0", "1"}, 1, 1);
        int answer31 = leetCode474.findMaxForm3(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        int answer32 = leetCode474.findMaxForm3(new String[]{"10", "0", "1"}, 1, 1);
        int answer41 = leetCode474.findMaxForm4(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        int answer42 = leetCode474.findMaxForm4(new String[]{"10", "0", "1"}, 1, 1);

        // then
        Assertions.assertEquals(4, answer11);
        Assertions.assertEquals(2, answer12);
        Assertions.assertEquals(4, answer21);
        Assertions.assertEquals(2, answer22);
        Assertions.assertEquals(4, answer31);
        Assertions.assertEquals(2, answer32);
        Assertions.assertEquals(4, answer41);
        Assertions.assertEquals(2, answer42);
    }
}
