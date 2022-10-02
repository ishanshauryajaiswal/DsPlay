package graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class TwoWaterJug {
    //https://practice.geeksforgeeks.org/problems/two-water-jug-problem3402/1

    class Jug{
        int m; int n;
        Jug(int m, int n){
            this.m = m;
            this.n = n;
        }
    }

    public int  minSteps(int m, int n, int d)
    {
        int minSteps = 0;
        int levelCount = 1;
        int tempCount = 0;
        Deque<Jug> deque = new ArrayDeque<>();
        Set<Jug> set = new HashSet<>();
        deque.add(new Jug(0,0));
        set.add(deque.peek());
        while (!deque.isEmpty()){
            Jug jug = deque.poll();
            System.out.println(jug.m + " " + jug.n);
            levelCount--;
            if(jug.m == d || jug.n == d)
                return minSteps;
            if(canEmpty(jug.m)) {
                Jug temp = new Jug(0, jug.n);
                if(!checkSetContains(set, temp)) {
                    deque.add(temp);
                    set.add(temp);
                    tempCount++;
                }
            }
            if(canEmpty(jug.n)) {
                Jug temp = new Jug(jug.m, 0);
                if(!checkSetContains(set, temp)) {
                    deque.add(temp);
                    set.add(temp);
                    tempCount++;
                }
            }
            if(canFill(jug.m, m)) {
                Jug temp = new Jug(m, jug.n);
                if(!checkSetContains(set, temp)) {
                    deque.add(temp);
                    set.add(temp);
                    tempCount++;
                }
            }
            if(canFill(jug.n, n)) {
                Jug temp = new Jug(jug.m, n);
                if(!checkSetContains(set, temp)) {
                    deque.add(temp);
                    set.add(temp);
                    tempCount++;
                }
            }
            if(canTransfer(jug.m, jug.n, n)) {
                Jug temp = new Jug(Math.max(0,jug.m - (n - jug.n)), Math.min(jug.n + jug.m, n));
                if(!checkSetContains(set, temp)) {
                    deque.add(temp);
                    set.add(temp);
                    tempCount++;
                }
            }
            if(canTransfer(jug.n, jug.m, m)) {
                Jug temp = new Jug(Math.min(jug.n + jug.m, m), Math.max(0,jug.n - (m - jug.m)));
                if(!checkSetContains(set, temp)) {
                    deque.add(temp);
                    set.add(temp);
                    tempCount++;
                }
            }
            if(levelCount == 0) {
                minSteps++;
                levelCount = tempCount;
                tempCount = 0;
            }
        }
        return -1;
    }

    private boolean checkSetContains(Set<Jug> set, Jug temp) {
        return set.stream().anyMatch(jug -> temp.n == jug.n && temp.m == jug.m);
    }

    private boolean canTransfer(int m, int n, int N){
        if(m==0)
            return false;
        return n != N;
    }

    private boolean canFill(int jug, int x) {
        return jug!=x;
    }

    private boolean canEmpty(int m) {
        return m!=0;
    }
}
