package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DFS {

    public void dfs(int V, ArrayList<ArrayList<Integer>> adj, int source) {
        Set<Integer> visited = new HashSet<>();
        dfsUtil(adj, visited, source);
    }

    private void dfsUtil(ArrayList<ArrayList<Integer>> adj, Set<Integer> visited, int source) {
        if (visited.contains(source))
            return;
        visited.add(source);
        adj.get(source).forEach(node -> {
            dfsUtil(adj, visited, node);
        });
    }
}
