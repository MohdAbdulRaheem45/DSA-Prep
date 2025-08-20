public class P33 {//search in 2d array
    public static void main(String[] args) {
        int a[][]={
            {1,3,4,5},
            {6,7,10,12},
            {13,14,15,16}
    };
    boolean y=false;
    int target=16;
    for(int i=0;i<a.length;i++){
        int left=0;
        int right=a[0].length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(a[i][mid]==target){

                y=true;
                break;
            }else if(a[i][mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if(y) break;
    }
    System.out.println("target found?: "+y);
    
}}
