class SmallestInfiniteSet {

    PriorityQueue<Integer> minHeap;
    Set<Integer> set;

    public SmallestInfiniteSet() {
        Set<Integer> init = IntStream.range(1, 1000)
            .boxed()
            .collect(Collectors.toSet());
        minHeap = new PriorityQueue<>(init);
        set = init;
    }

    public int popSmallest() {
        if (minHeap.isEmpty()) {return -1;}
        Integer smallest = minHeap.poll();
        set.remove(smallest);
        return smallest;
    }

    public void addBack(int num) {
        if (set.contains(num)) {
            return;
        }
        minHeap.add(num);
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */