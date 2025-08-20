public class P7 {//removing duplicates

    public static void main(String[] args) {
        int [] a={1,1,2,2,3,3,4};
        int i=0;
        for(int j=1;j<a.length;j++){
            if (a[j]!=a[i]) {//checking next lemnt is same as previous if it is not then incereament previous element index and updating the array accodibgly.
                a[++i]=a[j];
                
            }
        }
        for(int k=0;k<=i;k++){
            System.out.println(a[k]);
        }
        System.out.println("length of array is "+i+1);
    }
}