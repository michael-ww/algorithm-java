package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LeetCode752 {

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String dead : deadends) {
            deads.add(dead);
        }
        if (deads.contains("0000")) {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int step = 0;
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return step;
                }
                for (String neighbor : getNeighbors(current)) {
                    if (visited.contains(neighbor)) {
                        continue;
                    }
                    if (deads.contains(neighbor)) {
                        continue;
                    }
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
            step++;
        }

        return -1;
    }

    private List<String> getNeighbors(String current) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            result.add(plusOne(current, i));
            result.add(minusOne(current, i));
        }

        return result;
    }

    private String plusOne(String current, int index) {
        char[] chars = current.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] += 1;
        }

        return new String(chars);
    }

    private String minusOne(String current, int index) {
        char[] chars = current.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] -= 1;
        }

        return new String(chars);
    }
}
