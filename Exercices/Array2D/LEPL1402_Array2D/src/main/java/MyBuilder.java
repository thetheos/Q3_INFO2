
import java.util.Arrays;

public class MyBuilder {
  public static void main(String[] args) {
    //System.out.println(Arrays.deepToString(build_from("1 2  \n 4 5  \n")));
    //System.out.println(Arrays.deepToString(transpose(build_from("1 2 \n 4 5 \n 7 8 \n"))));
    System.out.println(Arrays.deepToString(product(build_from("1 2  \n 4 5  \n"),build_from("1 2  \n 4 5  \n"))));
  }

  public static int[][] build_from(String s) {
    String[] strArr = s.split("\n");
    int[][] matrix;
    matrix = new int[strArr.length][];
    for(int i = 0; i<strArr.length; i++){
      String[] strRow = strArr[i].trim().split(" ");
      int[] intRow;
      intRow = new int[strRow.length];
      for(int b = 0; b<intRow.length; b++ ) {
        intRow[b] = Integer.parseInt(strRow[b]);
      }
      matrix[i] = intRow;
    }
    return matrix;
  }
  public int sum(int[][] array) {
    int sum = 0;
    for(int[] elm : array){
      for(int a : elm){
        sum += a;
      }
    }
    return sum;
  }

  public static int[][] transpose(int[][] matrix) {
    int[][] newMatrix;
    newMatrix = new int[matrix[0].length][matrix.length];
    for(int i = 0; i<matrix.length;i++){
      for(int b=0; b<matrix[0].length; b++){
        newMatrix[b][i] = matrix[i][b];
      }
    }
    return newMatrix;
  }
  public static int[][] product(int[][] matrix1, int[][] matrix2) {
    int[][] prodMatrix;
    prodMatrix = new int[matrix1.length][matrix2[0].length];
    for(int i = 0; i<matrix1.length; i++){
      for(int b = 0; b<matrix2[0].length;b++){
        int sum = 0;
        for(int c = 0; c<matrix1[0].length; c++){
          sum += matrix1[i][c]*matrix2[c][b];
        }
        prodMatrix[i][b] = sum;
      }
    }
    return prodMatrix;
  }

}
