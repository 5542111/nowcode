package com.luwis.code;

import java.util.HashMap;
import java.util.Map;

public class a1742countBalls {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int box = 0, x = i;
            while (x != 0) {
                box += x % 10;
                x /= 10;
            }
            count.put(box, count.getOrDefault(box, 0) + 1);
            res = Math.max(res, count.get(box));
        }
        return res;
    }
}
