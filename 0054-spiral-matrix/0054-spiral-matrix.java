class Solution {
    private static final Integer VISITED = 999;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int notVisited = matrix.length * matrix[0].length;

        int x = 0, y = 0;
        int dir = 0;
        while (true) {
            result.add(matrix[x][y]); // 추가
            matrix[x][y] = VISITED; // 지나온길 표시
            notVisited--;

            // 다음길
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 다음 블럭을 확인, 블럭 밖인지? 이미 방문한 곳인지? -> 그렇다면 방향 전환
            if (nx < 0 || ny < 0 || nx >= matrix.length || ny >= matrix[0].length
                || matrix[nx][ny] == VISITED) {
                dir = (dir + 1) % 4;
            }
            // 종료조건
            if (notVisited == 0) {
                break;
            }

            x = x + dx[dir];
            y = y + dy[dir];
        }

        return result;
    }
}