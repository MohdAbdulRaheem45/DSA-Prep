import java.util.*;

public class P34 {//pascals triangle
    public static void main(String[] args) {
        int numRows = 5;

       List<List<Integer>> triangle=new ArrayList<>();
       for(int i=0;i<numRows;i++){
        List<Integer > row=new ArrayList<>();
        row.add(1);
        for(int j=1;j<i;j++){
            List<Integer> prevrow=triangle.get(i-1);
            row.add(prevrow.get(j-1)+prevrow.get(j));

        }
        if(i>0){
            row.add(1);
        }
        triangle.add(row);
       }

        // Print Pascal’s Triangle
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}
