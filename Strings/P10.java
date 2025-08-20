public class P10 {//integer to roman
    public static String InttoRoman(int num){
         int[] values =    {1000, 900, 500, 400, 100, 90,  50,  40,  10,  9,   5,  4,  1};
        String[] symbols ={"M",  "CM","D", "CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<values.length;i++){
            if(num>=values[i]){
                num-=values[i];
                sb.append(symbols[i]);

            }

        }
        return sb.toString();

    }
    public static void main(String[] args) {
        System.out.println(InttoRoman(15));
    }
    
}
