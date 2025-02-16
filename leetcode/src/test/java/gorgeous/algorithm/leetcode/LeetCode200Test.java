package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode200Test {

    @Test
    public void numIslands_validInput_returnNumber() {
        // given

        // when
        LeetCode200 leetCode200 = new LeetCode200();
        int answer1 = leetCode200.numIslands(new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}});
        int answer2 = leetCode200.numIslands(new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}});

        // then
        Assertions.assertEquals(1, answer1);
        Assertions.assertEquals(3, answer2);
    }
}
