import java.util.HashMap;

public class P22 {//majaority element (more then n/2 times)(approch 1 with extra space)
    public static void main(String[] args) {
       int arr[]={1,1,2,2,2};
       int n=arr.length;
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int num:arr){
        map.put(num,map.getOrDefault(num, 0)+1);
       }
       for(int key:map.keySet()){
        if(map.get(key)>n/2){
            System.out.println("majority element is = "+key);
            return;
        }
       }System.out.println("no majority elemnet");
       }}
    

