package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PossiblePathsBetweenTwoVertices {

    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                          int destination) {
        int[] dp = new int[V];
        dp[destination] = 1;
        Set<Integer> visited = new HashSet<>();
        dfs(adj, source, destination, dp, visited);
        return dp[source];
    }

    private int dfs(ArrayList<ArrayList<Integer>> adj, int source, int destination, int[] dp, Set<Integer> visited) {
        if(source == destination)
            return 1;
        if (visited.contains(source))
            return dp[source];
        visited.add(source);
        adj.get(source).forEach(node -> {
            dp[node]+= dfs(adj, node, destination,dp, visited);
        });
        return dp[source];
    }

}
