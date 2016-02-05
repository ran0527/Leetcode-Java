public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // number of prerequisites
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }

        // store courses that have no pre
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // number of courses with no pre
        int noPre = queue.size();

        while (!queue.isEmpty()) {
            int top = queue.remove();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == top) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        noPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numCourses == noPre;
    }
}
