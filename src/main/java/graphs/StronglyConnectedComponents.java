package graphs;


import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponents {
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<V; i++){
            dfs(adj, i, visited, stack);
        }
        visited = new boolean[V];
        Stack<Integer> delete = new Stack<>();
        adj = transpose(adj, V);
        int ans = 0;
        while (!stack.isEmpty()){
            int ele = stack.pop();
            if(!visited[ele]) {
                ans++;
                dfs(adj, ele, visited, delete);
            }
        }
        return ans;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, Stack<Integer> stack) {
        if(visited[i])
            return;
        visited[i] = true;
        for (int j=0; j< adj.get(i).size(); j++){
            dfs(adj, adj.get(i).get(j), visited, stack);
        }
        stack.push(i);
    }

    private ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> adj, int V){
        ArrayList<ArrayList<Integer>> transpose = (ArrayList<ArrayList<Integer>>) adj.clone();
        for(int i = 0; i<V; i++){
            transpose.get(i).clear();
        }
        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                int ele = adj.get(i).get(j);
                transpose.get(ele).add(i);
            }
        }
        return transpose;
    }
}
