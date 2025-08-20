public class P3 {//two sum sorted arrays
    public static void main(String[] args) {
        int a[]={5,6,9,10,15};
        int n=a.length;
        int target=21;
        int left=0;
        int right=n-1;
        while(left<right){
            int sum=a[left]+a[right];
            if(sum==target){
                System.out.println("target "+target+" found at index "+(left+1)+","+(right+1));
return;
            }
            else if(sum>target){
                right--;
            }
            else if(sum<target){
                left++;
            }
        }
    }
    
}
