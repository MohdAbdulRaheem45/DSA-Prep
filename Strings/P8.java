public class P8 {//Longest palindrome
    public static String aroundcentre(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;

        }
        return s.substring(l+1, r);
    }
    public static String longestpalindroem(String s){
        String longest="";
        for(int i=0;i<s.length();i++){
        String odd=aroundcentre(s,i, i);
        String even=aroundcentre(s, i, i+1);
        if(odd.length()>longest.length()){
            longest=odd;

        }else if(even.length()>longest.length()){
            longest=even;
        }
        }
        return longest;
    }
    public static void main(String[] args) {
        String s="abbd";
        String k="b";
        String l="ab";
        String j="baddabs";
        System.out.println(longestpalindroem(s));
        System.out.println(longestpalindroem(k));
        System.out.println(longestpalindroem(l));
        System.out.println(longestpalindroem(j));

    }
    
}
