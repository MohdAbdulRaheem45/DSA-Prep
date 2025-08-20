import java.util.HashMap;

public class P9 {//count subarrays with the sum=k
    public static void main(String[] args) {
        int arr[]={1,1,1};
        int k=2;
        HashMap<Integer,Integer> map=new HashMap<>();//prefix sum and frequency
        map.put(0,1);//base case 
        int sum=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
           map.put(sum, map.getOrDefault(sum, 0) + 1);



        }
        System.out.println(count);
    }
    
}
