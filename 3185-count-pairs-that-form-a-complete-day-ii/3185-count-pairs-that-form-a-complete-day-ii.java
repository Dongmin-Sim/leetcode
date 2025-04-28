class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long result = 0;
        int[] count = new int[24];

        for (int hour : hours) {
            result += count[(24 - hour % 24) % 24];
            count[hour % 24]++;
        }
        return result;
    }
}