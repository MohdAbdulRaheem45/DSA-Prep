import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class P7 {//group anagrams
    public static void main(String[] args) {
        String[] arr={"eat","tea","hit","ith","lamos"};
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(String s:arr){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        System.out.println(map.values());
    }

    
}
