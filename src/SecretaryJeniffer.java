import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * finds out what is the minimum time it will take for N copies
 * Created by zOpa on 19.08.2016.
 */
public class SecretaryJeniffer {

    public void run() throws IOException{

        Scanner sc = new Scanner(new File("inputJeniffer.txt"));
        PrintWriter pw = new PrintWriter(new File("outputJeniffer.txt"));

        int n = sc.nextInt();

        if (n == 0){
            pw.println(0);
            pw.close();
           return;
        }

        if (n < 0){
            throw new IllegalArgumentException("the number of copies can not be negative");
        }

        int x = sc.nextInt();
        checkXeroxTime(x);

        int y = sc.nextInt();
        checkXeroxTime(y);

        int time;
        int now;
        int minSeconds = 0;
        int allTime;

        if (x > y) {    // find xerox with min seconds
            x = x + y;
            y = x - y;
            x = x - y;
        }

        time = (n - 1) * y;

        while (minSeconds != time) {
            now = (minSeconds + time) / 2;
            allTime = now / x + now / y;
            if (allTime < n - 1) {
                minSeconds = now + 1;
            } else {
                time = now;
            }
        }

        pw.println(time + x);
        pw.close();
    }

    private void checkXeroxTime (int xeroxTime){
        if (xeroxTime == 0){
            throw new IllegalArgumentException("the time can not be zero");
        }

        if (xeroxTime < 0){
            throw new IllegalArgumentException("the time can not be negative.");
        }
    }
}
