class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] split = path.split("/");

        for (String s : split) {
            if (s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                stack.pollLast();
            } else if (!s.isEmpty()) {
                stack.addLast(s);
            }
        }
        return "/" + String.join("/", stack);
    }
}