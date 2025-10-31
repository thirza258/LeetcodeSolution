import java.util.*;

public class Leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        List<Integer> courseList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int courses =  prerequisites[i][0];
            int precourse =  prerequisites[i][1];
            graph.get(precourse).add(courses);

            courseList.add(courses);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(!courseList.contains(i)) {
                queue.add(i);
            }
        }

        int courseTaken = 0;
        while(!queue.isEmpty()) {
            int currentCourse = queue.poll();

            courseTaken++;

            for(int i = 0; i < graph.get(currentCourse).size(); i++) {
                int neighborCourse = graph.get(currentCourse).get(i);

                courseList.remove(Integer.valueOf(neighborCourse));

                if(!courseList.contains(neighborCourse)) {
                    queue.add(neighborCourse);
                }
            }
        }

        return courseTaken == numCourses;

    }
}
