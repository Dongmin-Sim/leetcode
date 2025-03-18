class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dfs(i, visited, isConnected)) {
                count++;
            }
        }

        return count;
    }

    private boolean dfs(int current, boolean[] visited, int[][]isConnected) {
        if (visited[current]) return false;

        visited[current] = true;
        for (int i = 0; i < isConnected[current].length; i++) {
            if (i == current) continue;
            if (isConnected[current][i] == 1 && !visited[i]) {
                dfs(i, visited, isConnected);
            }
        }
        return true;
    }
}