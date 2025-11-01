package gorgeous.algorithm.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode773 {

    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        String target = "123450";
        // 将 2x3 的数组转化成字符串作为 BFS 的起点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();

        // 记录一维字符串的相邻索引
        int[][] neighbor = new int[][]{
            {1, 3},
            {0, 4, 2},
            {1, 5},
            {0, 4},
            {3, 1, 5},
            {4, 2}
        };

        // ****** BFS 算法框架开始 ******
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        // 从起点开始 BFS 搜索
        queue.offer(start);
        visited.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                // 判断是否达到目标局面
                if (target.equals(cur)) {
                    return step;
                }
                // 找到数字 0 的索引
                int idx = 0;
                for (; cur.charAt(idx) != '0'; idx++) ;
                // 将数字 0 和相邻的数字交换位置
                for (int adj : neighbor[idx]) {
                    char[] charArray = cur.toCharArray();
                    Utility.swap(charArray, adj, idx);
                    String new_board = new String(charArray);
                    // 防止走回头路
                    if (!visited.contains(new_board)) {
                        queue.offer(new_board);
                        visited.add(new_board);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
