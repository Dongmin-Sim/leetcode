class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, isConnected);
                count++;
            }
        }

        return count;
    }

    private void dfs(int current, boolean[] visited, int[][]isConnected) {
        visited[current] = true;
        for (int i = 0; i < isConnected[current].length; i++) {
            if (isConnected[current][i] == 1 && !visited[i]) {
                dfs(i, visited, isConnected);
            }
        }
    }
}