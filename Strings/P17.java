import java.util.HashSet;

public class P17 {//longest substring without repeating characters
    public static void main(String[] args) {
        String s="abcbbcg";
      int maxlen=0;
      HashSet<Character> set=new HashSet<>();
      int l=0;
      for(int j=0;j<s.length();j++){
        char curr=s.charAt(j);
        while(set.contains(curr)){
            set.remove(s.charAt(l));
            l++;
        }
        set.add(curr);
        maxlen=Math.max(maxlen,j-l+1);
      }
        System.out.println(maxlen);
        
    }
    
}
