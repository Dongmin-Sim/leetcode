class RecentCounter {

Queue<Integer> queue;

public RecentCounter() {
    queue = new LinkedList<>();
}

public int ping(int t) {
    final int min = t - 3000;
    queue.add(t);
    return (int) queue.stream().filter(e -> e >= min).count();
}
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */