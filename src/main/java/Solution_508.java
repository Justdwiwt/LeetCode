package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        dfs(root);
        List<Integer> res = countMap.keySet().stream().filter(integer -> countMap.get(integer) >= cnt).collect(Collectors.toList());
        return res.stream().mapToInt(re -> re).toArray();
    }

    HashMap<Integer, Integer> countMap = new HashMap<>();
    int cnt = 0;

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int a = dfs(root.left);
        int b = dfs(root.right);
        int sum = root.val + a + b;
        countMap.put(sum, countMap.containsKey(sum) ? countMap.get(sum) + 1 : 1);
        cnt = Math.max(cnt, countMap.get(sum));
        return sum;
    }
}
