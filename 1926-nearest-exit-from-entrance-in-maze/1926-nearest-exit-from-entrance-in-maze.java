class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();

        visited[entrance[0]][entrance[1]] = true;
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] currStep = queue.poll();
            int x = currStep[0], y = currStep[1], step = currStep[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx > maze.length - 1 || ny < 0 || ny > maze[0].length - 1) {
                    continue;
                }
                if (!(maze[nx][ny] == '+') && !visited[nx][ny]) {
                    if (nx == 0 || nx == maze.length - 1 || ny == 0 || ny == maze[0].length - 1) {
                        return step + 1;
                    }
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, step + 1});
                }
            }
        }

        return -1;
    }
}