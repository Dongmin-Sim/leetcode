class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int pairs = 0;

        HashMap<String, Integer> pattern = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                builder.append(grid[i][j]);
                builder.append(',');
            }
            String key = builder.toString();
            pattern.put(key, pattern.getOrDefault(key, 0) + 1);
        }
        
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                builder.append(grid[j][i]);
                builder.append(',');
            }
            String key = builder.toString();
            pairs += pattern.getOrDefault(key, 0);
        }

        return pairs;
    }
}