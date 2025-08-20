import java.util.HashMap;

public class P18 {//finding duplicates
    public static void main(String[] args) {
        int arr[]={1,2,3,1,4,4,1,5};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>1){
                System.out.println("key: "+key);

            }
        }
    }
    
}
