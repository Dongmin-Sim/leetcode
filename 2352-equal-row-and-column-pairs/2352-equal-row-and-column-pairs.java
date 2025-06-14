class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            String key = Arrays.toString(grid[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] col = new int[grid.length];
            for (int j = 0; j < grid[i].length; j++) {
                col[j] = grid[j][i];
            }
            String key = Arrays.toString(col);
            count += map.getOrDefault(key, 0);
        }

        return count;
    }
}