package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LessThanSumTest {

    @Test
    public void process_validInput_ReturnSum() {
        // given
        int[] array = {1, 6, 2, 8, 3, 7, 4, 9, 5};

        // Act
        int result = new LessThanSum().process(array);

        // Assert
        Assertions.assertEquals(73, result);
        Assertions.assertEquals(1, array[0]);
        Assertions.assertEquals(5, array[4]);
        Assertions.assertEquals(9, array[8]);
    }
}
