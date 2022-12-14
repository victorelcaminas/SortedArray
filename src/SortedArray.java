import java.util.Arrays;

public class SortedArray {
    private int[] array;
    private int numElements;

    public SortedArray(int size) {
        numElements = 0;
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        //Arrays.fill(array, -1);
    }

    public void put(int number) {
       if (numElements == 0) {
            array[0] = number;
            numElements = 1;
            return;
        }
        for(int i = numElements - 1; i >= 0; i--) {
            if (array[i] > number) {
                array[i + 1] = array[i];
                array[i] = number;
            } else {
                array[i + 1] = number;
                break;
            }
        }
        numElements++;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public boolean isFull() {
        return numElements == array.length;
    }

    @Override
    public String toString() {
        String s = "";
        boolean first = true;
        for (int i = 0; i < numElements; i ++) {
            if (first) {
                first = false;
            } else {
                s += ", ";
            }
            s += array[i];
        }
        return s;
    }

    public boolean existsElementRecursive(int number) {
        return binarySearch(number, 0, numElements -1);
    }

    public boolean binarySearch(int number, int minorIndex, int upperIndex) {
        if (minorIndex > upperIndex) {
            return false;
        }
        int middle = (minorIndex + upperIndex) / 2;
        if (array[middle] == number) {
            return true;
        }
        if (array[middle] > number) {
            return binarySearch(number, minorIndex, middle - 1);
        } else {
            return binarySearch(number, middle + 1, upperIndex);
        }
    }

    public boolean existsElement(int number) {
        int minorIndex = 0;
        int upperIndex = numElements - 1;
        int middle = (upperIndex + minorIndex) / 2;
        while (upperIndex >= minorIndex && array[middle] != number) {
            if (array[middle] < number) {
                minorIndex = middle + 1;
            } else {
                upperIndex = middle - 1;
            }
            middle = (upperIndex + minorIndex) / 2;
        }
        if (upperIndex < minorIndex) {
            return false;
        }
        return true;
    }

    public void removeElementAt(int position) {
        if (position < 0 || position >= numElements) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = position; i < numElements - 1; i ++) {
            array[i] = array[i+1];
        }
        array[numElements - 1] = -1;
        numElements--;
    }
}
