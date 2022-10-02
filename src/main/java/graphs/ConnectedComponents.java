package graphs;

import java.util.*;

public class ConnectedComponents {

    public static void main(String[] args) {
        System.out.println("oo");
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        Set<Integer> visited = new HashSet<>();
        int provinces = 0;
        for(int i = 0; i < V; i++){
            if(!visited.contains(i)) {
                dfs(adj, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, Set<Integer> visited, int i){
        if(visited.contains(i))
            return;
        visited.add(i);
        List<Integer> list = adj.get(i);
        for(Integer k:list){
            dfs(adj, visited, k);
        }
    }

}
