public class P16 {//ZIGZAG CONVERSION

    public static String Zigzag(String s,int n){
        if (n==1) return s;
        StringBuilder[] rows=new StringBuilder[n];
        for(int i=0;i<rows.length;i++){
            rows[i]=new StringBuilder();
        }
            int currrow=0;
            boolean isGoingdown=false;
            for(char c:s.toCharArray()){
                rows[currrow].append(c);
                if(currrow==0 || currrow==n-1){
                    isGoingdown=!isGoingdown;
                }
                currrow+=isGoingdown?1:-1;

            }
            StringBuilder result=new StringBuilder();
            for(StringBuilder row:rows){
                result.append(row);
            }
            return result.toString();
        
    }
    public static void main(String[] args) {
        System.out.println(Zigzag("Example",3));
    }
    
}
