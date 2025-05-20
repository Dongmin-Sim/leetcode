class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }

        List<int[]> list = new ArrayList<>();

        boolean flag = false;
        for (int[] interval : intervals) {
            if (flag || interval[1] < newInterval[0]) {
                list.add(interval);
            } else if (interval[0] > newInterval[1]) {
                flag = true;
                list.add(newInterval);
                list.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if (!flag) {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][]);
    }
}