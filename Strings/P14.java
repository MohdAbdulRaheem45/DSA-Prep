public class P14 {
    public static boolean isSubseqeunce(String s,String t){
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==s.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
    public static void main(String[] args) {
        System.out.println(isSubseqeunce("abc","affffbjfjcj"));
        
    }
    
}
