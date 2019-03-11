import java.util.*;
import java.io.*;

public class USACO {


  public static int bronze(String filename) {
    //variables for row, col, final elevation, and number of instructs
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
    while (scanner.hasNextLine()) {
      String[] line = scanner.nextLine().split(" ");
      r = Integer.parseInt(line[0]);
      c = Integer.parseInt(line[1]);
      e = Integer.parseInt(line[2]);
      n = Integer.parseInt(line[3]);
      map = new int[r][c];
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
        }
      }
      sink(map, instruct);
      findElevation(map, e);
      int total = 0;
      for (int i = 0; i < map.length; i++){
        for (int j = 0; j < map[i].length; j++){
          total += map[i][j];
        }
      }
      return 72*72*total;
    }

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
      int e = instruct[x][2];
      int max = getmax(r, c, map);
      sinkHelper(r, c, map, e, max);
        }
    }

    private static int[][] sinkHelper(int r, int c, int[][] map, int e, int max){
      int low = 0;
      while (low < e){
        for (int i = r; i < r + 3; i++ ) {
          for (int j = c; j < c + 3; j++ ) {
            if (map[i - 1][j - 1] >= max) map[i - 1][j - 1]--;
          }
        }
        max = getmax(r, c, map);

        low++;
      }
      return map;
    }

  private static void findElevation(int[][] map, int e){
    for (int i = 0; i < map.length; i++){
      for (int j = 0; j < map[i].length; j++){
        if (map[i][j] > e) map[i][j] = 0;
        else map[i][j] = e - map[i][j];
      }
    }
  }


  private static int getmax(int r, int c, int[][] map){
    int max = 0;
    for (int i = r; i < r + 3; i++){
      for (int j = c ;j < c + 3 ; j++ ) {
        if (max < map[i - 1][j - 1]) {
          max = map[i - 1][j - 1];
        }
      }
    }
    return max;
  }


  public static int silver(String filename){
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(bronze("makelake.5.in"));
  }



}
