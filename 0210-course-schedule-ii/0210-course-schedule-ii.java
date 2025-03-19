import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] answer = new int[numCourses];
        
        HashMap<Integer, Set<Integer>> nextCourseMap = new HashMap<>();
        int[] prerequisitesCount = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            nextCourseMap.computeIfAbsent(prerequisiteCourse, k -> new HashSet<>());
            nextCourseMap.get(prerequisiteCourse).add(course);

            prerequisitesCount[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (prerequisitesCount[i] == 0) {
                queue.add(i);
            }
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            answer[idx] = course;
            idx++;

            if (nextCourseMap.containsKey(course)) {
                for (Integer i : nextCourseMap.get(course)) {
                    prerequisitesCount[i]--;
                    if (prerequisitesCount[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }

        return idx == numCourses ? answer : new int[]{};
    }
}