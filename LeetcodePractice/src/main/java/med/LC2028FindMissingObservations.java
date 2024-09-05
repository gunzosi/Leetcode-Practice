package med;

import java.util.Arrays;

public class LC2028FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean *(n + m);
        int observedSum = Arrays.stream(rolls).sum();
        int missingSum = totalSum - observedSum;

        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }
        // Phân phối giá trị cho các kết quả bị thiếu
        int[] result = new int[n];
        Arrays.fill(result, 1);
        missingSum -= n; // Đã gán mỗi phần tử là 1, trừ đi số này khỏi tổng

        int i = 0;
        while (missingSum > 0) {
            int add = Math.min(5, missingSum); // Mỗi lần có thể cộng thêm tối đa 5 (vì 1 + 5 = 6)
            result[i] += add;
            missingSum -= add;
            i++;
        }

        return result;

    }

    public static void main(String[] args) {
        int[] rolls = {3,2,4,3};
        int mean = 4;
        int n = 2;
        LC2028FindMissingObservations test = new LC2028FindMissingObservations();
        int[] result = test.missingRolls(rolls, mean, n);
        System.out.println(Arrays.toString(result));
    }
}

