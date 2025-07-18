class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;
        int n = costs.length;

        PriorityQueue<int[]> leftHeap = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> rightHeap = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int left = 0, right = n - 1;
        /// 후보군 세팅.
        while (left <= right && leftHeap.size() < candidates) {
            leftHeap.add(new int[]{costs[left], left});
            left++;
        }
        while (left <= right && rightHeap.size() < candidates) {
            rightHeap.add(new int[]{costs[right], right});
            right--;
        }

        for (int i = 0; i < k; i++) {
            // 왼쪽에서 뺄지, 오른쪽에서 뺄지?
            if (rightHeap.isEmpty() || (!leftHeap.isEmpty() && leftHeap.peek()[0] <= rightHeap.peek()[0])) {
                cost += leftHeap.poll()[0];
                if (left <= right) {
                    leftHeap.add(new int[]{costs[left], left});
                    left++;
                }
            } else {
                cost += rightHeap.poll()[0];
                if (left <= right) {
                    rightHeap.add(new int[]{costs[right], right});
                    right--;
                }
            }
        }

        return cost;
    }
}