public class p15 {//Length of the last word
    public static int Lengthoflastword(String s){
        int length=0;
        int i=s.length()-1;
        while(i>=0 && s.charAt(i)==' '){
            i--;
                    }
                    while (i>=0 && s.charAt(i)!=' ') {
                        length++;
                        i--;
                        
                    }
                    return length;
    }
    public static void main(String[] args) {
        String s="hello world    ";
        System.out.println(Lengthoflastword(s));
    }
    
}
