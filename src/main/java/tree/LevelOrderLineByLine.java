package tree;

import java.util.ArrayList;

public class LevelOrderLineByLine {

    //Function to return the level order traversal line by line of a tree.
    static ArrayList<ArrayList<Integer>> levelOrder(Node node) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (node == null)
            return ans;
        int count = 1;
        int tempCount = 0;
        ArrayList<Node> q = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        q.add(node);
        while (!q.isEmpty()){
            if(count == 0){
                ans.add(t);
                t = new ArrayList<>();
                count = tempCount;
                tempCount = 0;
            }
            Node n = q.remove(0);
            t.add(node.data);
            if(n.left != null){
                tempCount++;
                q.add(n.left);
            }
            if(n.right != null){
                tempCount++;
                q.add(n.right);
            }
            count--;
        }
        return ans;
    }
}
