class BrowserHistory {
    Deque<String> history = new LinkedList<>();
    Deque<String> forwardHistory = new LinkedList<>();

    public BrowserHistory(String homepage) {
        history.addLast(homepage);
    }

    public void visit(String url) {
        history.addLast(url);
        forwardHistory = new LinkedList<>();
    }

    public String back(int steps) {
        while (steps > 0 && history.size() > 1) {
            forwardHistory.addLast(history.pollLast());
            steps--;
        }

        return history.peekLast();
    }

    public String forward(int steps) {
        while (steps > 0 && !forwardHistory.isEmpty()) {
            history.addLast(forwardHistory.pollLast());
            steps--;
        }
        
        return history.peekLast();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */