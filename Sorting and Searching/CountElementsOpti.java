public class CountElementsOpti {
    public static int findindex(int [] arr,int target,boolean findfirst){
        int left=0;
        int right=arr.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                ans=mid;
                if(findfirst){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else if(arr[mid]>target)
            {
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={2,4,4,4,6,8};
        int target=4;
        int first=findindex(arr,target,true);
        int last=findindex(arr,target,false);
        int result=last-first+1;
        System.out.println(result);
    }
    
}
