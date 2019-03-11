import java.util.*;
import java.io.*;

public class USACO {

//BRONZE
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
      //get primary data
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






//SILVER
  public static int silver(String filename) throws FileNotFoundException {
     File file = new File(filename); //read file
     Scanner read = new Scanner(file);

     //set varbles
     String[][] pasture;
     int[][] newpasture;
     int[][] newpasture2;
     int c;
     int r;
     int steps;

     //get r, c, and steps
     String line = read.nextLine();
     String[] data = line.split(" ", 3);
     r = Integer.parseInt(data[0]);
     c = Integer.parseInt(data[1]);
     steps = Integer.parseInt(data[2]);

     //make two new arrays
     pasture = new String[r][c];
     newpasture = new int[r][c];
     newpasture2 = new int[r][c];

     //nextline past the baord
     for (int h = 0; h < r; h++) {
         line = read.nextLine();
         pasture[h] = line.split("");
     }

     //read the start and end columns
     int startr;
     int startc;
     int endr;
     int endc;
     line = read.nextLine();
     data = line.split(" ", 4);
     startr = Integer.parseInt(data[0]);
     startc = Integer.parseInt(data[1]);
     endr = Integer.parseInt(data[2]);
     endc = Integer.parseInt(data[3]);

     newpasture[startr - 1][startc - 1] = 1; //set start to taken
     newpasture2[startr - 1][startc - 1] = 1; //set the start to taken; -1 because to put it in array index form
     for (int track = 0; track < steps; track++) { //track the number of steps you have taken, increase aat the same time
         for (int i = 0; i < r; i++) {
             for (int j = 0; j < c; j++) { //loop through the arrays
                 if (newpasture[i][j] != 0) { //if where you're at isnt taken
                     try {
                         if (pasture[i + 1][j].contains(".")) { //if tree
                           newpasture2[i + 1][j] += newpasture2[i][j]; //add the steps
                         }
                     } catch (ArrayIndexOutOfBoundsException e) {}
                     try {
                         if (pasture[i][j + 1].contains(".")) {
                           newpasture2[i][j + 1] += newpasture2[i][j];
                         }
                     } catch (ArrayIndexOutOfBoundsException e) {}
                     try {
                         if (pasture[i - 1][j].contains(".")) {
                           newpasture2[i - 1][j] += newpasture2[i][j];
                         }
                     } catch (ArrayIndexOutOfBoundsException e) {}
                     try {
                         if (pasture[i][j - 1].contains(".")) {
                            newpasture2[i][j - 1] += newpasture2[i][j];
                         } //check for tree for all of the 4 directions you can go, if there is one, add the step from where you are at, to where you are checking
                     } catch (ArrayIndexOutOfBoundsException e) {}
                     newpasture2[i][j] = 0; //set where you are to 0 if there are no paths
                 }
             }
         }
         for (int i = 0; i < r; i++) {
             for (int j = 0; j < c; j++) {
                 newpasture[i][j] = newpasture2[i][j]; //transfer the number of steps
             }
         }
     }
     return newpasture[endr - 1][endc - 1]; //get the number of steps where it is
  	}






  public static void main(String[] args) throws FileNotFoundException{
    System.out.println(silver("ctravel.3.in"));
  }



}
