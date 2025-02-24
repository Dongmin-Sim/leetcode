class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> uam = new HashMap<>();
        int[] answer = new int[k];

        for (int[] log : logs) {
            int userId = log[0];
            int minute = log[1];

            if (!uam.containsKey(userId)) {
                uam.put(userId, new HashSet<>());
            }
            uam.get(userId).add(minute);
        }

        for (Integer userId : uam.keySet()) {
            HashSet<Integer> set = uam.get(userId);
            answer[set.size()-1]++;
        }

        return answer;
    }
}