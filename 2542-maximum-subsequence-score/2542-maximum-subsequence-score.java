class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }

        /// num2 기준으로 정렬
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0, ans = 0;
        for (int[] pair : pairs) {
            int num1 = pair[0];
            int num2 = pair[1];
            sum += num1;
            minHeap.offer(num1);
            if (minHeap.size() > k) { sum -= minHeap.poll(); }
            if (minHeap.size() == k) {
                ans = Math.max(ans, sum * num2);
            }
        }

        return ans;
    }
}