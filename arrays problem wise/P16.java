import java.util.HashMap;//checking is two arrays equal using hashmap 

public class P16{
    public static void main(String[] args) {
        int[] a1={1,2,2,3,1};
        int [] a2={2,1,1,2,3};
        HashMap<Integer,Integer> map =new HashMap<>();
        if (a1.length!=a2.length) {return;};
      for(int num:a1){
        map.put(num,map.getOrDefault(num,0)+1);

      }
      for(int num:a2){
        if(!map.containsKey(num)) {
            System.out.println("not possible");
            return;
        }
        
        map.put(num,map.get(num)-1);
        if(map.get(num)<0){
            System.out.println("not possible");
        }

    
      }
      System.out.println("arrays are equal");
    }
}