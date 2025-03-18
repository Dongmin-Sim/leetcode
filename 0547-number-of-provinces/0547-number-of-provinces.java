class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dfs(i, isConnected[i], -1, visited)) {
                count++;
            }
        }

        return count;
    }

    private boolean dfs(int current, int[] connected, int from, boolean[] visited) {
        if (visited[current]) return false;

        for (int i = 0; i < connected.length; i++) {
            if (i == current) continue;

            if (connected[i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, connected, current, visited);
            }
        }
        return true;
    }
}