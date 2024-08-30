package med;

import java.util.Arrays;

public class LC41FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        placeNumbers(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private static void placeNumbers(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 0, 3};
        int[] nums2 = {-3, -4, 2, 4};
        int[] nums3 = {1,2,3,4};
        int[] nums4 = {-1, -2, 3, 7};


       /* System.out.println("1. placeNumbers(nums1): " + Arrays.toString(nums1));
        placeNumbers(nums1);
        System.out.println("1. placeNumbers(nums1) sau khi sắp xếp: " + Arrays.toString(nums1));

        System.out.println("2. placeNumbers(nums2): " + Arrays.toString(nums2));
        placeNumbers(nums2);
        System.out.println("2. placeNumbers(nums2) sau khi sắp xếp: " + Arrays.toString(nums2));*/

        System.out.println("3. placeNumbers(nums3): " + Arrays.toString(nums3));
        placeNumbers(nums3);
        System.out.println("3. placeNumbers(nums3) sau khi sắp xếp: " + Arrays.toString(nums3));

        System.out.println("4. placeNumbers(nums4): " + Arrays.toString(nums4));
        placeNumbers(nums4);
        System.out.println("4. placeNumbers(nums4) sau khi sắp xếp: " + Arrays.toString(nums4));

        // Kiểm tra method firstMissingPositive với các mảng
        System.out.println("firstMissingPositive(nums1): " + firstMissingPositive(nums1)); // Kết quả mong đợi: 4
        System.out.println("firstMissingPositive(nums2): " + firstMissingPositive(nums2)); // Kết quả mong đợi: 2
        System.out.println("firstMissingPositive(nums3): " + firstMissingPositive(nums3)); // Kết quả mong đợi: 1
        System.out.println("firstMissingPositive(nums4): " + firstMissingPositive(nums4)); // Kết quả mong đợi: 4
    }
}
