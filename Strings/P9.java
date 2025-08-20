public class P9 {
    public static int changeStrToInt(String s){
        if(s==null || s.length()==0) return 0;
        s=s.trim();
        int i=0;
        int n=s.length();
        int sign=1;
        if(s.charAt(i)=='+' || s.charAt(i)=='-'){
sign=s.charAt(i)=='-'?-1:1;
i++;

        }
        int result=0;
        while(i<n && Character.isDigit(s.charAt(i))){
int digit=s.charAt(i)-'0';
if(result>(Integer.MAX_VALUE-digit)/10){
    return (sign==1) ? Integer.MAX_VALUE:Integer.MIN_VALUE;
}
result=result*10+digit;
i++;

        }
        return (int)result*sign;
        
    }
    public static void main(String[] args) {
        String s="     -422    ";
        System.out.println(changeStrToInt(s));
    }
    
}
