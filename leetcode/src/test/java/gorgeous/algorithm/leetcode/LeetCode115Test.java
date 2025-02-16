package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode115Test {

    @Test
    public void numDistinct_validInput_returnCount() {
        // given

        // when
        LeetCode115 leetCode115 = new LeetCode115();
        int answer11 = leetCode115.numDistinct1("rabbbit", "rabbit");
        int answer12 = leetCode115.numDistinct1("babgbag", "bag");
        int answer21 = leetCode115.numDistinct2("rabbbit", "rabbit");
        int answer22 = leetCode115.numDistinct2("babgbag", "bag");
        int answer31 = leetCode115.numDistinct3("rabbbit", "rabbit");
        int answer32 = leetCode115.numDistinct3("babgbag", "bag");
        int answer41 = leetCode115.numDistinct4("rabbbit", "rabbit");
        int answer42 = leetCode115.numDistinct4("babgbag", "bag");

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
