import java.util.*;
import java.io.*;

public class USACO {


  public static int bronze(String filename) {
    //variables for row, col, final elevation, and number of instructs, and arrays
    int r = 0;
    int c = 0;
    int e = 0;
    int n = 0;
    int[][] map = null;
    int[][] instruct = null;
    //use try catch for file not found
    try {
      //get primary info
    File f = new File(filename); //initialize file
    Scanner scanner = new Scanner(f); //read file
    while (scanner.hasNextLine()) { //while there is another line
      String[] line = scanner.nextLine().split(" "); //split it based of spaces
      r = Integer.parseInt(line[0]);
      c = Integer.parseInt(line[1]);
      e = Integer.parseInt(line[2]);
      n = Integer.parseInt(line[3]); //parse through to find variables
      map = new int[r][c]; //make map based off of the r and c
      for (int i = 0; i < r; i++){
        String[] lines = scanner.nextLine().split(" ");
        for (int j = 0; j < c; j++){
          map[i][j] = Integer.parseInt(lines[j]);
        }
      }

      instruct = new int[n][3];
        for (int i = 0; i < n; i++){
          line = scanner.nextLine().split(" ");
          for (int j = 0; j < 3; j++) {
            instruct[i][j] = Integer.parseInt(line[j]);
          }
        } //make array of instructions based off of the instructions given
      }
      sink(map, instruct); //the cows stop
      findElevation(map, e); //find the final elevation after subtrracting
      int total = 0;
      for (int i = 0; i < map.length; i++){
        for (int j = 0; j < map[i].length; j++){
          total += map[i][j];
        }
      }
      return 72*72*total;
    } //get the total voume

  catch (FileNotFoundException l){
    System.out.println("file not found");
  }
   return -1;
  }

//HELPERS FOR bronze

  private static void sink(int[][] map, int[][] instruct){
    for (int x = 0; x < instruct.length; x++){
      int r = instruct[x][0];
      int c = instruct[x][1];
      int e = instruct[x][2]; //for each intrscution, get the r, c, and e
      int max = getmax(r, c, map); //find the max
      sinkHelper(r, c, map, e, max); //call helper
    }
    }

    private static int[][] sinkHelper(int r, int c, int[][] map, int e, int max){
      int num = 0; //varible for
      while (num < e){
        for (int i = r; i < r + 3; i++ ) {
          for (int j = c; j < c + 3; j++ ) { //3x3 cows
            if (map[i - 1][j - 1] >= max) map[i - 1][j - 1]--;
          } //sink by subtracting
        }
        max = getmax(r, c, map); //what is the new maximum

        num++; //add to the tracker
      }
      return map;
    }

  private static void findElevation(int[][] map, int e){
    for (int i = 0; i < map.length; i++){
      for (int j = 0; j < map[i].length; j++){
        if (map[i][j] > e) map[i][j] = 0; // if same keep it as 0
        else map[i][j] = e - map[i][j]; //get the elevation by subtracting based off the given elevation
      }
    }
  }


  private static int getmax(int r, int c, int[][] map){
    int max = 0;
    for (int i = r; i < r + 3; i++){
      for (int j = c ;j < c + 3 ; j++ ) { //3x3 cows
        if (max < map[i - 1][j - 1]) {
          max = map[i - 1][j - 1];
        }
      }
    } //this is to find the max of the 3x3 stopmong gorunds
    return max;
  }


  public static int silver(String filename){
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(bronze("makelake.5.in"));
  }



}
