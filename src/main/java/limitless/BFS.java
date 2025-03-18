package limitless;

import java.util.*;

public class BFS {
    public void bfs(int V, ArrayList<ArrayList<Integer>> graph, int source) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        System.out.println(source);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            graph.get(currentVertex).forEach(i -> {
                if (!visited[i]) {
                    System.out.println(i);
                    visited[i] = true;
                    queue.add(i);
                }
            });
        }
    }

    public void bfsDelete(int V, ArrayList<ArrayList<Integer>> graph, int source) {
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.add(source);
        visited.add(source);
        while (!q.isEmpty()) {
            int currentVertex = q.poll();
            System.out.println(currentVertex);
            for (int i : graph.get(currentVertex)) {
                if(!visited.contains(i)){
                    q.add(i);
                    visited.add(i);
                }
            }
        }
    }
}
