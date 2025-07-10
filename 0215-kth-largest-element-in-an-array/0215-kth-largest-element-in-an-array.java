class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.offer(num);
        }

        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer = queue.poll();
        }

        return answer;
    }
}