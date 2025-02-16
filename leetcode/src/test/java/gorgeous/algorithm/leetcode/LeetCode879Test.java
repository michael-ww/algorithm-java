package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode879Test {

    @Test
    public void profitableSchemes_validInput_returnProfitableSchemeCount() {
        // given

        // when
        LeetCode879 leetCode879 = new LeetCode879();
        int answer11 = leetCode879.profitableSchemes1(5, 3, new int[]{2, 2}, new int[]{2, 3});
        int answer12 = leetCode879.profitableSchemes1(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8});
        int answer21 = leetCode879.profitableSchemes2(5, 3, new int[]{2, 2}, new int[]{2, 3});
        int answer22 = leetCode879.profitableSchemes2(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8});
        int answer31 = leetCode879.profitableSchemes3(5, 3, new int[]{2, 2}, new int[]{2, 3});
        int answer32 = leetCode879.profitableSchemes3(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8});
        int answer41 = leetCode879.profitableSchemes4(5, 3, new int[]{2, 2}, new int[]{2, 3});
        int answer42 = leetCode879.profitableSchemes4(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8});

        // then
        Assertions.assertEquals(2, answer11);
        Assertions.assertEquals(7, answer12);
        Assertions.assertEquals(2, answer21);
        Assertions.assertEquals(7, answer22);
        Assertions.assertEquals(2, answer31);
        Assertions.assertEquals(7, answer32);
        Assertions.assertEquals(2, answer41);
        Assertions.assertEquals(7, answer42);
    }
}
