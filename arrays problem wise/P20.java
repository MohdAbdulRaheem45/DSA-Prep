import java.util.HashMap;

public class P20 {//count subarrays with the given xor
    public static void main(String[] args) {
    
       int  a[] = {4, 2, 2, 6, 4}; 
        int k = 6 ;//xor
        int count=0;
        int xor=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0, 1);
        for(int num:a){
            xor^=num;
            if(map.containsKey(xor^k)){
                count+=map.get(xor^k);
            }
            map.put(num,map.getOrDefault(num, 0)+1);

        }
System.out.println(count);
    }
    
}
