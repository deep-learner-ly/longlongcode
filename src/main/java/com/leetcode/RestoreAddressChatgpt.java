package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LongyunBian
 * @date: 2023/3/30 15:46
 * @Description: 回溯法
 */
public class RestoreAddressChatgpt {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> parts, List<String> result) {
        if (start == s.length() && parts.size() == 4) {
            result.add(String.join(".", parts));
            return;
        }
        if (parts.size() == 4) {
            return;
        }
        for (int i = start; i < Math.min(start+3, s.length()); i++) {
            if (s.charAt(start) == '0' && i > start) {
                break;
            }
            if (Integer.parseInt(s.substring(start, i+1)) > 255) {
                break;
            }
            parts.add(s.substring(start, i+1));
            backtrack(s, i+1, parts, result);
            parts.remove(parts.size()-1);
        }
    }
}
