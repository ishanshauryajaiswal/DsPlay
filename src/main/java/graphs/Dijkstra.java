package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] ans = new int[V];
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            ans[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.get(1) - o1.get(1));
        ArrayList<Integer> source = new ArrayList<>();
        source.add(S);source.add(0);
        queue.add(source);
        visited[S] = true;
        while (!queue.isEmpty()){
            ArrayList<Integer> temp = queue.poll();
            int distance = temp.get(1);
            if(ans[temp.get(0)] > distance){
                ans[temp.get(0)] = distance;
            }
            for(int i=0; i < adj.get(temp.get(0)).size(); i++){
                if(!visited[adj.get(temp.get(0)).get(i).get(0)]){
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(adj.get(temp.get(0)).get(i).get(0));
                    t.add(adj.get(temp.get(0)).get(i).get(1)+distance);
                    queue.add(t);
                    visited[t.get(0)] = true;
                }
            }
        }
        return ans;
    }

}
