class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] buckets = new int[60];

        for (int t : time) {
            buckets[t % 60]++;
        }

        long answer = 0;
        int l = 1, r = 59;
        while (l < r) {

            answer += buckets[l] * buckets[r];
            l++;
            r--;
        }

        answer += (long) buckets[0] * (buckets[0] - 1) / 2;
        answer += (long) buckets[30] * (buckets[30] - 1) / 2;

        return (int) answer;
    }
}