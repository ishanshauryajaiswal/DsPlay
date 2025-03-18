package graphs;

import java.util.ArrayList;

public class TopologicalSort {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] ans = new int[V];
        boolean[] visited = new boolean[V];
        ArrayList<Integer> topSort = new ArrayList<>();
        for (int i=0; i<V;i++){
            topSort.addAll(0, dfsUtil(adj, i, visited));
        }
        final int[] k = {0};
        topSort.forEach( i ->{
            ans[k[0]++] = i;
        });
        return (ans);
    }


    private static ArrayList<Integer> dfsUtil(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited){
        ArrayList<Integer> connectedVertices = new ArrayList<>();
        if(visited[i])
            return connectedVertices;
        connectedVertices.add(i);
        visited[i] = true;
        for(int j = 0; j<adj.get(i).size(); j++){
            connectedVertices.addAll(dfsUtil(adj, adj.get(i).get(j), visited));
        }
        return connectedVertices;
    }


}
