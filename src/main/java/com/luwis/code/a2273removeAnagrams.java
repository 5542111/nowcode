package com.luwis.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a2273removeAnagrams {
    public static void main(String[] args) {
        String[] words = new String[]{"abba","baba","bbaa","cd","cd"};
        System.out.println(new a2273removeAnagrams().removeAnagrams(words));
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!isSame(words[i], words[i-1])) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    private boolean isSame(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) - 1);
        }
        map.entrySet().removeIf(entry -> entry.getValue() == 0);
        return map.isEmpty();
    }
}
