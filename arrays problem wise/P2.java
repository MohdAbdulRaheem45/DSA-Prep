public class P2 {//PROBLEM 2: Prefix Sum – Range Query
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 10};
        int n=a.length;
        int[] prefix=new int[n];
        prefix[0]=a[0];
        for(int i=1;i<n;i++){
            prefix[i]=a[i]+prefix[i-1];
        }
        int l=1,r=3;
        int sum;
        if(l==0){
            sum=prefix[r];
            
        }
        else{
            sum=prefix[r]-prefix[l-1];
        }
        System.out.println(sum);

    }
    
}
