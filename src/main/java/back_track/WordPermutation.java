package back_track;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/permutations-words-1-official/ojquestion
 */
public class WordPermutation {

    public static void generateWords(int i, int size, HashMap<Character, Integer> frequencyMap, String answer) {
        if(i > size){
            System.out.println(answer);
        }
        else{
            frequencyMap.forEach((character, integer) -> {

            });
            for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
                if(entry.getValue() > 0){
                    entry.setValue(entry.getValue()-1);
                    generateWords(i+1, size, frequencyMap, answer+entry.getKey());
                    entry.setValue(entry.getValue()+1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashMap<Character, Integer> fmap = new HashMap<>();
        for(char ch: str.toCharArray()){
            if(fmap.containsKey(ch)){
                fmap.put(ch, fmap.get(ch) + 1);
            } else {
                fmap.put(ch, 1);
            }
        }
        generateWords(1, str.length(), fmap, "");
    }

}
