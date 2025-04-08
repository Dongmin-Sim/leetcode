class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>(List.of(words));

        while (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();

            int currentWidth = 0;
            boolean lastSent = false;
            List<String> temp = new ArrayList<>();

            while (true) {
                String peek = queue.peek();
                if (peek == null) {
                    lastSent = true;
                    break;
                } else if (currentWidth + peek.length() + temp.size() > maxWidth) {
                    break;
                }
                String word = queue.poll();
                temp.add(word);
                currentWidth += word.length();
            }

            int remainSpace = maxWidth - currentWidth;
            int countSpace = temp.size() - 1;

            if (lastSent || countSpace == 0) {
                for (int i = 0; i < temp.size(); i++) {
                    sb.append(temp.get(i));
                    if (i == countSpace) {
                        break;
                    }
                    sb.append(" ");
                }
                sb.append(" ".repeat(remainSpace - countSpace));
            } else {
                if (remainSpace % countSpace == 0) {
                    /// 단어 사이에 공백을 넣어야 함
                    for (int i = 0; i < temp.size(); i++) {
                        sb.append(temp.get(i));
                        if (i == temp.size() - 1) {
                            break;
                        }
                        sb.append(" ".repeat(remainSpace / countSpace));
                    }
                } else {
                    /// 맨 마지막 값만 나머지
                    int basicSpace = remainSpace / countSpace;
                    int extraSpace = remainSpace % countSpace;
                    for (int i = 0; i < temp.size(); i++) {
                        sb.append(temp.get(i));
                        if (i == temp.size() - 1) {
                            break;
                        }
                        if (extraSpace > 0) {
                            sb.append(" ".repeat(basicSpace + 1));
                            extraSpace--;
                        } else {
                            sb.append(" ".repeat(basicSpace));
                        }
                    }
                }
            }
            result.add(sb.toString());
        }

        return result;
    }
}