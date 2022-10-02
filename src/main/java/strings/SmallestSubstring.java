package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class SmallestSubstring {

    /*
    {
  "bigString": "abcd$ef$axb$c$",
  "smallString": "$$abf"
  abcd$ef$a
}
     */
        public static String smallestSubstringContaining(String bigString, String smallString) {
            Map<Character, Integer> map = new HashMap<>();
            String ans = "";
            for(int i = 0; i < smallString.length(); i++){
                Character c = smallString.charAt(i);
                Integer j= map.get(c);
                map.put(c, 1 + (j == null ? 0 : j));
            }
            int l = 0, r = 0, min = Integer.MAX_VALUE;
            Map<Character, Integer> currMap = new HashMap<>();
            while(true){

                Character c = bigString.charAt(r);
                if(checkMap(map)) {
                    if (1 + r - l < min) {
                        min = 1 + r - l;
                        ans = bigString.substring(l, r + 1);
                    }
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) - 1);
                    }
                    Character p = bigString.charAt(l);
                    if (!map.containsValue(p)) {
                        l++;
                    }
                    if (map.containsKey(p)) {
                        if (map.get(p) < 0) {
                            l++;
                        } else {
                            r++;
                        }
                        map.put(p, map.get(p) + 1);
                    }
                }
                else {
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) - 1);
                    }
                    r++;
                }

                if(r==bigString.length())
                    break;

            }
            return ans;
        }

        private static Boolean checkMap(Map<Character, Integer> map){
            AtomicBoolean flag = new AtomicBoolean(true);
            map.values().forEach(i -> {
                if(i > 0){
                    flag.set(false);
                }
            });
            return flag.get();
        }

    public static String smallestSubstringContaining2(String bigString, String smallString) {
        Map<Character, Integer> map = new HashMap<>();
        String ans = "";
        for(int i = 0; i < smallString.length(); i++){
            Character c = smallString.charAt(i);
            Integer j= map.get(c);
            map.put(c, 1 + (j == null ? 0 : j));
        }
        int l = 0, r = 0, min = Integer.MAX_VALUE;

        while(r<bigString.length()){
            Character c = bigString.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
            if(checkMap(map)){
                while(true){
                    Character p = bigString.charAt(l);
                    if(!map.containsKey(p)){
                        l++;
                    }
                    else{
                        if (map.get(p) < 0) {
                            l++;
                            map.put(p, map.get(p) + 1);
                        }
                        else{
                            break;
                        }
                    }
                }
                if (1 + r - l < min) {
                    min = 1 + r - l;
                    ans = bigString.substring(l, r + 1);
                }
            }
            r++;
        }
        return ans;
    }

    int getMinSlots(int arr[], int dep[]){
        return 0;
    }

}
