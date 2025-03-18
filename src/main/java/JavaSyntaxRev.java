import kotlin.Pair;

import java.util.*;

public class JavaSyntaxRev {

    public static void main(String[] args) {
        map();
    }

    public static void queue() {
        Queue<String> q0 = new LinkedList<>();
        Queue<String> q1 = new ArrayDeque<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });


        q1.offer("");
    }

    public static void map() {
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        map.put(new Pair<>(1,1), 1);
        map.put(new Pair<>(1,1), 2);
        System.out.println("poopoo  "+map.get(new Pair<>(1,1)));

        Map<String, Integer> map2 = new HashMap<>();
        map2.containsKey("1");
        map2.containsValue(1);
        map2.remove("1");

        //iterate map
        map2.forEach( (key, value) -> { });

        for(Map.Entry<String, Integer> entry : map2.entrySet()){}
        for(int value : map2.values()){ }
        for(String key : map2.keySet()){ }

        Set<Integer> set = new HashSet<>();
        set.contains(1);
        set.add(1);
        set.remove(1);


    }

    public static void array() {
        int b0[] = {1,2,3};
        int b1[][] = {{1,2,3}, {4,5,6}, {7,8,9}};

        //traverse matrix adjacent
        int[][] arr = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] a : arr) {
            System.out.println(a[0] + ", " + a[1]);
        }
        int row=0, col=0;
        //IMP
        for(int[] next: new int[][]{{row-1,col}, {row+1, col}, {row, col+1}, {row, col-1} } ) {
            int nr = next[0];
            int nc = next[1];
        }

    }

    public static void forExamples() {
        int n = 10;
        int[] array = {1, 2, 3, 4, 5};
        // Enhanced for loop (for-each loop)
        for (int element : array) {
            System.out.println(element);
        }
        // Do-while loop
        int i = 0;
        i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i < n);
        // For loop with multiple variables
        for (int j = 0; j < n; j++, n--) {
            System.out.println(j + ", " + n);
        }
        // For loop with no initialization or update statements
        i = 0;
        for (; i < n;) {
            System.out.println(i);
            i++;
        }
        // For loop with no condition statement
        for (i = 0;; i++) {
            if (i >= n) {
                break;
            }
            System.out.println(i);
        }
        //iterator
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.println(element);
        }

        list.forEach(item ->{

        });
    }

    public static void stringExamples() {
        String str1 = "hello";
        String str2 = "world";

        // compareTo: The result of comparing hello and world is -15.
        int result = str1.compareTo(str2);

        // concat: The concatenation of hello and world is helloworld.
        String str3 = str1.concat(str2);

        // contains: Does hello contain 'ell'? true.
        boolean contains = str1.contains("ell");

        // endsWith: Does hello end with 'lo'? true.
        boolean endsWith = str1.endsWith("lo");

        // lastIndexOf: The last index of 'l' in hello is 3.
        int lastIndex = str1.lastIndexOf('l');

        // split: The parts of hello after splitting by 'l' are:
        // he
        // o
        String[] parts = str1.split("l");

        // substring: The substring of hello from index 2 to 4 is: ll.
        String substr = str1.substring(2, 4);

        // replace: After replacing all occurrences of 'l' with 'x' in hello, we get: hexxo.
        String replaced = str1.replace('l', 'x');

        // replaceAll: After replacing all vowels in hello, we get: hxllx.
        String regex = "[aeiou]";
        String replacedAll = str1.replaceAll(regex, "x");
    }

}
