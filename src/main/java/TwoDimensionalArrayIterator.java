import java.util.ArrayList;
import java.util.List;

class TwoDimensionalArrayIterator {
    private final int[][] array;
    private int index1 = 0;
    private int index2 = 0;


    TwoDimensionalArrayIterator(int[][] array) {
        this.array = dropEmptyElements(array);
    }

    private int[][] dropEmptyElements(int[][] array) {
        List<int[]> nonEmptyElements = new ArrayList<>();

        for (int[] entry : array) {
            if (entry.length != 0) {
                nonEmptyElements.add(entry);
            }
        }

        int[][] result = new int[nonEmptyElements.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = nonEmptyElements.get(i);
            // TODO ugh, there must be a better way.  java arrays are shite
        }
        return result;
    }

    boolean has_next() {
        return index1 < array.length;
    }

    int next() {
        if (!has_next())
            throw new IllegalStateException("No next element");

        // 1. find element
        // 2. update both indexes (so next call to has_next() will work correctly)
        // 3. return element

        int result = array[index1][index2];

        index2++;

        // Check if second index has room to go
        if (index2 >= array[index1].length) {
            // at the end of the current inner array
            index2 = 0;
            index1++;
        }

        return result;
    }

    void remove() {

    }
}
