package graphs;

import java.util.*;

public class MotherVertex {

    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj){
        Map<Integer, Set<Integer>> mapOfAllReachableVertices = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<V;i++){
            if (!visited.contains(i)){
                dfsForAllPaths(adj, visited, mapOfAllReachableVertices, i);
            }
        }
        final int[] ans = {Integer.MAX_VALUE};
        mapOfAllReachableVertices.forEach((vertex,set)->{
            if(set.size() == V)
                ans[0] = Math.min(vertex, ans[0]);
        });
        if(ans[0] == Integer.MAX_VALUE)
            return -1;
        return ans[0];
    }

    private static Set<Integer> dfsForAllPaths(ArrayList<ArrayList<Integer>> adj, Set<Integer> visited, Map<Integer, Set<Integer>> mapOfAllReachableVertices, int i) {
        Set<Integer> set = new HashSet<>();
        set.add(i);
        if(!visited.contains(i)) {
            visited.add(i);
            for(int k = 0; k < adj.get(i).size(); k++){
                set.addAll(dfsForAllPaths(adj, visited, mapOfAllReachableVertices, adj.get(i).get(k)));
            }
            mapOfAllReachableVertices.put(i, set);
        }
        else{
            return mapOfAllReachableVertices.getOrDefault(i, set);
        }
        return set;
    }
}
