import org.junit.Test;

import static org.junit.Assert.*;

public class TwoDimensionalArrayIteratorTest {

    @Test
    public void test1() {
        int[][] array = {{}, {1,2,3}, {4,5}, {}, {6}, {7,8}, {}, {9}, {10}, {}};
        TwoDimensionalArrayIterator it = new TwoDimensionalArrayIterator(array);
        StringBuilder buffer = new StringBuilder();
        while (it.has_next()) {
            buffer.append(it.next());
            buffer.append(" ");
        }
        assertEquals("1 2 3 4 5 6 7 8 9 10", buffer.toString().trim());
    }

    @Test
    public void test2() {
        int[][] array = {{}, {1,2,3}, {4,5}, {}, {6}, {7,8}, {}, {9}, {10}, {}};
        TwoDimensionalArrayIterator it = new TwoDimensionalArrayIterator(array);
        StringBuilder buffer = new StringBuilder();
        while (it.has_next()) {
            int elem = it.next();
            if (elem % 2 == 0) {
                it.remove(); // TODO this line can be commented out and the test will pass, heh.  bad description.
            } else {
                buffer.append(elem);
                buffer.append(" ");
            }
        }
        assertEquals("1 3 5 7 9", buffer.toString().trim());
    }
}