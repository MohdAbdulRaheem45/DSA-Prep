public class P12 {//Longest common prefix(REPEAT)
    public static String Longestprefix(String s[]){
        
        String prefix=s[0];
        for(int i=1;i<s.length;i++){
            while(!s[i].startsWith(prefix )){
                prefix=prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()) return " ";
            }
        }
        return prefix;

    }
    public static void main(String[] args) {
        System.out.println(Longestprefix(new String[]{"flower","flow","flight"}));
    }
    
}
