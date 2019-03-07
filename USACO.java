public class USACO {




  public static int bronze(String filename) throws FileNotFoundException{
    int r = 0;
    int c = 0;
    int e = 0;
    int n = 0;
    File f = new File(filename);
    Scanner scanner = new Scanner(f);
    String line = scanner.nextLine();
    Scanner lineread = new Scanner(line);
    for(int i = 0; i < 4; i++) {
      int sub = lineread.nextInt();
      if (r == 0) {
        r = sub;
      }
      else if (c == 0) {
        c = sub;
      }
      else if (e == 0) {
        e = sub;
      }
      else if (n == 0) {
        n = sub;
      }
    }

    return 1;
  }




  public static int silver(String filename){
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(bronze(makelake1.in));
  }



}
