import java.util.*;
import java.io.*;

public class USACO {




  public static int bronze(String filename) {
    //variables for row, col, final elevation, and number of stomps
    int r = 0;
    int c = 0;
    int e = 0;
    int n = 0;
    //use try catch for file not found
    try {
      //get primary info
    File f = new File(filename); //initialize file
    Scanner scanner = new Scanner(f); //read file
    while (scanner.hasNextLine()) {
      String[] line = scanner.nextLine().split(" ");
      r = Integer.parseInt(line[0]);
      c = Integer.parseInt(line[1]);
      e = Integer.parseInt(line[2]);
      n = Integer.parseInt(line[3]);
      int[][] map = new int[r][c];
      for (int i = 0; i < r; i++){
        String[] lines = scanner.nextLine().split(" ");
        for (int j = 0; j < c; j++){
          map[i][j] = Integer.parseInt(lines[j]);
        }
      }

      int[][] stomp = new int[n][3];
        for (int i = 0; i < n; i++){
          line = scanner.nextLine().split(" ");
          for (int j = 0; j < 3; j++) {
            stomp[i][j] = Integer.parseInt(line[j]);
          }
        }
      }

    }

  catch (FileNotFoundException l){
    System.out.println("file not found");
  }
   return -1;
  }

//HELPERS FOR bronze



  public static int silver(String filename){
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(bronze("makelake.1.in"));
  }



}
