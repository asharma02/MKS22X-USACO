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
    String priminfo = scanner.nextLine(); //scan in first line = primary info
    Scanner lineread = new Scanner(priminfo);  //read first line
    for(int i = 0; i < 4; i++) { // 4 times = 4 variables
      int sub = lineread.nextInt(); //read the first int
      if (r == 0) {
        r = sub; //if rows is 0, this int is rows
      }
      else if (c == 0) {
        c = sub; //if c is 0, this int is c
      }
      else if (e == 0) {
        e = sub; //if e is 0, this int is e
      }
      else if (n == 0) {
        n = sub; //if c is n, this int is n
      } //works cause variables always in order
    }

    //get map
    int[][] map = new int[r][c];
    Scanner formap = new Scanner(f);
    formap.nextLine();
    for(int i = 0; i < r; i++) {
      String row = formap.nextLine();
      for (int x = 0; x < c - 1; x++) {
        int nextspace = row.indexOf(' ');
        map[i][x] = Integer.parseInt(row.substring(0, nextspace));
        row = row.substring(nextspace + 1);
      }
      map[i][c-1] = Integer.parseInt(row); //because there is c - 1 due to the spacing, i go map and take the last int
    }


    Scanner in = new Scanner(f);
    for (int i = 0; i <= r; i++) in.nextLine();
    int[][] instructions = new int[n][3];
    for(int i = 0; i < n; i++) {
      String instruct = in.nextLine();
      for(int x = 0; x < 3; x++) {
        int nextspace = instruct.indexOf(' ');
        instructions[i][x] = Integer.parseInt(instruct.substring(0, nextspace));
        instruct = instruct.substring(nextspace + 1);
      }
      instructions[i][n-1] = Integer.parseInt(instruct);
    }

    for (int i = 0; i < instructions.length; i++) {
      for (int j = 0; j < instructions[i].length; j++) {
        System.out.print(instructions[i][j] + " ");
      }
      System.out.println();
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
