import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * program that determine how many different versions of gifts weighing exactly W grams can make Santa Claus
 * Created by zOpa on 19.08.2016.
 */
public class Candies {

    public static void main(String[] args) throws IOException {
        new Candies().run();
    }

    private void run() throws IOException {

        Scanner sc = new Scanner(new File("inputCandies.txt"));
        PrintWriter pw = new PrintWriter(new File("outputCandies.txt"));

        int candy = sc.nextInt();      // candy grams
        int orange = sc.nextInt();     // orange grams
        int apple = sc.nextInt();      //apple grams
        int giftWeight = sc.nextInt();

        int tmp;
        int numberGiftOptions = 0;

        for (int i = 0; i <= giftWeight / candy; i++) {
            for (int j = 0; j <= giftWeight / orange; j++) {

                tmp = giftWeight - (i * candy) - (j * orange);

                if (tmp >= 0 && tmp % apple == 0) {
                    numberGiftOptions++;
                }
            }
        }
        pw.println(numberGiftOptions);
        pw.close();
    }
}
