
import org.checkerframework.checker.units.qual.A;
import strings.LongestBalancedSubstring;

import java.util.*;
import java.util.function.IntConsumer;

public class MainJava {

    public static void main(String args[]){
/*
        MainKotlin kotlin = new MainKotlin();
       // kotlin.main();

        Map<String, Boolean> map = null;
        //new HashMapGet().main();

        //new ChannelPg().main();
        //new GsonPg().main();
        //System.out.println(new Gson().toJson(map));
        new GsonPg().main();

        testBuilder();

 */
        new KotlinPG().pg();

    }

    private static void testBuilder(){
        Character c = 'a';
        System.out.println(c - 97);
        StringBuilder builder = new StringBuilder();
        //builder.append("ii");
        System.out.println(builder);
        builder.delete(0,builder.length());
        System.out.println("q" + builder + "w");
    }

    private static int isLucky(int n){
        Set<String> set = new HashSet<String>();
        while(n>0){
            int x = n%10;
            n = n/10;
            if(set.contains(x))
                return 1;
            set.add(String.valueOf(x));
        }
        return 0;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] sub = new int[gas.length];
        int sum = 0;
        for(int i=0 ; i <gas.length; i++){
            sub[i] = gas[i]-cost[i];
            sum+= sub[i];
        }
        if(sum<0){
            return -1;
        }
        int start = 0, stages = 0, current = 0;
        int size = gas.length;
        while(true){
            if(stages == size){
                return start;
            }
            if(sum < 0 ){
                
            }
        }
    }
}





/*
        1   2   9
        3   4   6
        7   10  12





 */