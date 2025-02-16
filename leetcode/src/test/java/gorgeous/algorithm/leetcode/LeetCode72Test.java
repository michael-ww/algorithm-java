package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode72Test {

    @Test
    public void minDistance_validInput_returnMinDistance() {
        // given

        // when
        LeetCode72 leetCode72 = new LeetCode72();
        int answer11 = leetCode72.minDistance1("horse", "ros");
        int answer12 = leetCode72.minDistance1("intention", "execution");
        int answer21 = leetCode72.minDistance2("horse", "ros");
        int answer22 = leetCode72.minDistance2("intention", "execution");
        int answer31 = leetCode72.minDistance3("horse", "ros");
        int answer32 = leetCode72.minDistance3("intention", "execution");
        int answer41 = leetCode72.minDistance4("horse", "ros");
        int answer42 = leetCode72.minDistance4("intention", "execution");

        // then
        Assertions.assertEquals(3, answer11);
        Assertions.assertEquals(5, answer12);
        Assertions.assertEquals(3, answer21);
        Assertions.assertEquals(5, answer22);
        Assertions.assertEquals(3, answer31);
        Assertions.assertEquals(5, answer32);
        Assertions.assertEquals(3, answer41);
        Assertions.assertEquals(5, answer42);
    }
}
