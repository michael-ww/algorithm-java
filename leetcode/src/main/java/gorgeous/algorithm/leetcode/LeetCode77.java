package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        this.dfs(n, 1, k, new LinkedList<>(), answer);
        return answer;
    }

    private void dfs(int n, int number, int k, LinkedList<Integer> path, List<List<Integer>> answer) {
        if (number > n) {
            if (path.size() == k) {
                answer.add(new ArrayList<>(path));
            }
        } else {
            this.dfs(n, number + 1, k, path, answer);
            path.addLast(number);
            this.dfs(n, number + 1, k, path, answer);
            path.removeLast();
        }
    }
}
