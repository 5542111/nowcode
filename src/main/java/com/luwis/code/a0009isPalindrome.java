package com.luwis.code;

public class a0009isPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        // 多位数以 0 结尾时，首位无法与末位对称。
        if (x % 10 == 0) {
            return false;
        }

        // 只反转后一半数字，避免完整反转可能造成的整数溢出。
        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // 偶数位直接比较；奇数位用 / 10 忽略原数的中间位。
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
