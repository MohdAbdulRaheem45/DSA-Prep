public class ReverseDigit {
    public static void main(String[] args) {
        int n=123;
        int rev=0;
        while(n!=0){
            int lastdigit=n%10;
            rev=rev*10+lastdigit;
            n=n/10;//removing last digit
        }
        System.out.println(rev);
    }
}
