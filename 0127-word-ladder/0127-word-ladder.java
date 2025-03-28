class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 1;
        Set<String> visited = new HashSet<>();
        Set<String> word = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                String currentWord = queue.poll();
                char[] currentWordArray = currentWord.toCharArray();

                for (int i = 0; i < currentWordArray.length; i++) {
                    char originChar = currentWordArray[i];
                    for (int j = 0; j < 26; j++) {
                        currentWordArray[i] = (char) (j + 'a');
                        if (originChar == currentWordArray[i]) {
                            continue;
                        }

                        String convertWord = String.valueOf(currentWordArray);
                        if (word.contains(convertWord)) {
                            if (convertWord.equals(endWord)) {
                                return step + 1;
                            }
                            if (visited.add(convertWord)) {
                                queue.add(convertWord);
                            }
                        }
                    }
                    currentWordArray[i] = originChar;
                }
            }

            step++;
        }

        return 0;
    }
}