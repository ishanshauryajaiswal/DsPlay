package limitless;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Consumer;

public class Dijkstra {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> graph, int source)
    {
        int[] ans = new int[V];
        boolean[] visited = new boolean[V];
        initInfinity(ans);
        PriorityQueue<ObjPair> minHeapDistance = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        minHeapDistance.add(new ObjPair(source, 0));
        visited[source] = true;

        while (!minHeapDistance.isEmpty()){
            ObjPair vertex = minHeapDistance.poll();
            int distanceTillNow = vertex.distance;
            ArrayList<ArrayList<Integer>> currentVertex = graph.get(vertex.vertex);
            currentVertex.forEach(destination -> {
                if(!visited[destination.get(0)]){
                    visited[destination.get(0)] = true;
                    int newDistance = destination.get(1) + vertex.distance;
                    if(newDistance < ans[destination.get(0)]){
                        ans[destination.get(0)] = newDistance;
                        minHeapDistance.add(new ObjPair(destination.get(0), newDistance));
                    }
                }
            });
        }
        return ans;
    }

    static void initInfinity(int[] arr){
        Arrays.fill(arr, Integer.MAX_VALUE);
    }

}

class ObjPair{
    int vertex;
    int distance;

    public ObjPair(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
}
