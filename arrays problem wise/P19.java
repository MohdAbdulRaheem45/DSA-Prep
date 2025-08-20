public class P19 {//max product of two elements
    public static void main(String[] args) {
        int arr[]={1,5,2,7,9};
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        for(int num:arr){
            if(num>max1){
                max2=max1;
                max1=num;
            }else if(num>max2){
                max2=num;
            }
        }
        int maxprod=max1*max2;
        System.out.println("max product using elements ("+max1+","+max2+") ="+maxprod);
    }
    
}
