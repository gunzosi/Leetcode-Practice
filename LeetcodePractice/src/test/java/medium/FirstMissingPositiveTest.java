package medium;

import med.LC41FirstMissingPositive;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstMissingPositiveTest {

    @Test
    public void testFirstMissingPositive() {
        // Test Case 1
        assertEquals(4, LC41FirstMissingPositive.firstMissingPositive(new int[]{1, 2, 3}));
    }

    @Test
    public void testFirstMissingPositive2() {
        assertEquals(2, LC41FirstMissingPositive.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    @Test
    public void testFirstMissingPositive3() {
        assertEquals(1, LC41FirstMissingPositive.firstMissingPositive(new int[]{7, 8, 9, 11}));
    }

    @Test
    public void testFirstMissingPositive4() {
        assertEquals(1, LC41FirstMissingPositive.firstMissingPositive(new int[]{0, -1, -2, -3}));
    }

    @Test
    public void testFirstMissingPositive5() {
        assertEquals(1, LC41FirstMissingPositive.firstMissingPositive(new int[]{0, -1, -2, -3}));
    }

    @Test
    public void testFirstMissingPositive6() {
        assertEquals(1, LC41FirstMissingPositive.firstMissingPositive(new int[]{0, -1, -2, -3}));
    }

    @Test
    public void testFirstMissingPositive7() {
        assertEquals(5, LC41FirstMissingPositive.firstMissingPositive(new int[]{2, 2, 3, 4, 1}));
    }

    @Test
    public void testFirstMissingPositive8() {
        assertEquals(4, LC41FirstMissingPositive.firstMissingPositive(new int[]{1, 1, 2, 2, 3, 3}));
    }

    @Test
    public void testFirstMissingPositive9() {
        // Test Case 9
        assertEquals(1, LC41FirstMissingPositive.firstMissingPositive(new int[]{10, 12, 13, 14}));
    }

    @Test
    public void testFirstMissingPositive10() {
        // Test Case 10
        assertEquals(2, LC41FirstMissingPositive.firstMissingPositive(new int[]{1, 3, 4, 5}));
    }

}
