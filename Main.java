interface SortingStrategy {
    void sort(int[] array);
}
class BubbleSort implements SortingStrategy {
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
class SelectionSort implements SortingStrategy {
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
class QuickSort implements SortingStrategy {
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
class ArraySorter {
    private SortingStrategy sortingStrategy;

    public ArraySorter(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sortArray(int[] array) {
        sortingStrategy.sort(array);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] array = {6, 4, 8, 0, 3};

        ArraySorter sorter = new ArraySorter(new BubbleSort());
        sorter.sortArray(array);
        System.out.println("Sorted using Bubble Sort:");
        printArray(array);

        array = new int[]{6, 4, 8, 0, 3};
        sorter = new ArraySorter(new SelectionSort());
        sorter.sortArray(array);
        System.out.println("Sorted using Selection Sort:");
        printArray(array);

        array = new int[]{6, 4, 8, 0, 3};
        sorter = new ArraySorter(new QuickSort());
        sorter.sortArray(array);
        System.out.println("Sorted using Quick Sort:");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
