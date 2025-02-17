package com.luwis.code;

public class a0167twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        if (numbers == null || numbers.length < 2) return res;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return res;
    }
}
