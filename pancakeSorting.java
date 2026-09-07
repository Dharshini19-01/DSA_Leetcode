import java.util.ArrayList;
import java.util.List;

public class pancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int size = arr.length; size > 1; size--) {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            if (maxIndex == size - 1) {
                continue;
            }
            if (maxIndex != 0) {
                flip(arr, maxIndex + 1);
                result.add(maxIndex + 1);
            }
            flip(arr, size);
            result.add(size);
        }
        return result;
    }
    public void flip(int[] arr, int k) {
        int i = 0;
        int j = k - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
}
