import java.util.HashSet;

public class P21 {//longest consecutive elmets in the given array
    public static void main(String[] args) {
        int arr[]={100,3,4,200,1,2,5,6,7};
        HashSet<Integer> set=new HashSet<>();
        for(int num:arr){
            set.add(num);//its sorts the array and remove the duplicates
        }
        int longeststreak=0;
        int srat=0;
    for(int num:arr){
        if(!set.contains(num-1)){
            int crrtnum=num;
            int crrstreak=1;
        
        while(set.contains(crrtnum+1)){
            crrtnum+=1;
            crrstreak+=1;
        }
        if(crrstreak>longeststreak){
            longeststreak=crrstreak;
            srat=num;
        }
        }    }

        for(int i=0;i<longeststreak;i++){
            System.out.println(srat+i);
        }
        
        System.out.println(longeststreak);
    }}