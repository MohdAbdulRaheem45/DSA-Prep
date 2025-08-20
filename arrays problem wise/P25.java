public class P25 {//arraing +ve and -ve in a order
    public static void main(String[] args) {//we can use two pinters by making just result array
        int arr[]={3,-2,-1,4,-7,8};
       int pos=0;
       int neg=1;
       int result[] =new int[arr.length];
       for(int i=0;i<arr.length;i++){
        if(arr[i]>=0){
            result[pos]=arr[i];
            pos+=2;

        }else{
            result[neg]=arr[i];
            neg+=2;
        }
       }
       for(int num:result){
        System.out.println(num);
       }
    }
    
}
