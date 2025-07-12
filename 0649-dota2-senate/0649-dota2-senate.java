class Solution {
    public String predictPartyVictory(String senate) {
        /// 두개의 큐를 만든다. 각각의 정당을 나타내는.

        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }

        /// 큐를 양쪽 모두에서 꺼내서 추방 대상 결정. -> 한쪽 큐가 빌때까지.
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radient = radiantQueue.poll();
            int dire = direQueue.poll();

            /// radient이 dire 밴 시킴. 다시 추가로 넣어주어야함.
            if (radient < dire) {
                radiantQueue.offer(radient + senate.length());
            } else {
                direQueue.offer(dire + senate.length());
            }
        }

        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }
}