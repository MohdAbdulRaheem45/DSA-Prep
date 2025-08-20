public class P13 {//lr by one place
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6};
        int n=a.length;
        int e=a[0];
        
        for(int i=0;i<n-1;i++){
            a[i]=a[i+1];
        }
        a[n-1]=e;
      for(int i=0;i<n;i++){  
        System.out.println(a[i]);
    }
    
}}
