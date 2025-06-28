class Solution {
    public int minReorder(int n, int[][] connections) {    
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] conn : connections) {
            graph[conn[0]].add(new int[]{conn[1], 1});
            graph[conn[1]].add(new int[]{conn[0], 0});
        }

        return dfs(0, -1, graph);
    }

    private int dfs(int curr, int prev, List<int[]>[] graph) {
        int count = 0;

        for (int[] edge : graph[curr]) {
            if (edge[0] == prev) continue; // 바꿀 필요가 없음. 왜냐? 0으로 가는 방향이기 때문임.
            count += edge[1];
            count += dfs(edge[0], curr, graph);
        }

        return count;
    }
}