import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode210 {

    public static int UNVISITED = 0;
    public static int VISITING = 1;
    public static int VISITED = 2;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        if(prerequisites == null || prerequisites.length == 0) {
            for(int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            graph.get(preCourse).add(course);
        }

        List<Integer> topoSort = new ArrayList<>();
        HashMap<Integer, Integer> visitStatus = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            visitStatus.put(i, UNVISITED);
        }

        for(int i=0; i < numCourses; i++) {
            if(visitStatus.get(i) == UNVISITED) {
                boolean hasCycle = dfs(graph, i, visitStatus, topoSort);
                if(!hasCycle) {
                    return new int[0];
                }
            }
        }

        for(int i = 0; i < numCourses; i++) {
            result[i] = topoSort.get(numCourses - 1 - i);
        }

        return result;
    }

    private boolean dfs(HashMap<Integer, List<Integer>> graph, int course, HashMap<Integer, Integer> visitStatus, List<Integer> topoSort) {
        visitStatus.put(course, VISITING);

        for(int i = 0; i < graph.get(course).size(); i++) {
            if(visitStatus.get(graph.get(course).get(i)) == VISITING) {
                return false;
            }
            if(visitStatus.get(graph.get(course).get(i)) == UNVISITED) {
                boolean hasCycle = dfs(graph, graph.get(course).get(i), visitStatus, topoSort);
                if (!hasCycle) {
                    return false;
                }
            }
        }

        visitStatus.put(course, VISITED);

        topoSort.add(course);

        return true;
    }
}
