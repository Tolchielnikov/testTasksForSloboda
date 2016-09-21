import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.PrintWriter;
        import java.util.Scanner;

/**
 * finds out how much friends has a particular person in the company.
 * graph theory
 * Created by zOpa on 19.08.2016.
 */
public class SlobodaFriends {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("inputSlobodaFriends.txt"));
        PrintWriter pw = new PrintWriter(new File("outputSlobodaFriends.txt"));

        int n = sc.nextInt();
        int s = sc.nextInt();

        int m[][] = new int[n][n];

        for (int i = 0; i < n; i++) {          // read input
            for (int j = 0; j < n; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 1)
                    m[j][i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        if (m[j][k] == 1)
                            m[i][k] = 1;
                    }
                }
            }
        }

        // count friends
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (m[s - 1][i] == 1)
                count++;
        }
        pw.println(count - 1);
        pw.close();
    }
}
