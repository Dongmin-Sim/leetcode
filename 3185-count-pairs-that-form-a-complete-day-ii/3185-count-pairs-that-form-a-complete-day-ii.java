class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long result = 0;
        int[] remainHours = new int[24];

        for (int hour : hours) {
            result += remainHours[(24 - hour % 24) % 24];
            remainHours[hour % 24]++;
        }
        return result;
    }
}