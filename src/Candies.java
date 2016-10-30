import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * program that determine how many different versions of gifts weighing exactly W grams can make Santa Claus
 * Created by zOpa on 19.08.2016.
 */
public class Candies {

    public void run() throws IOException {

        Scanner sc = new Scanner(new File("inputCandies.txt"));
        PrintWriter pw = new PrintWriter(new File("outputCandies.txt"));

        int candy = sc.nextInt();      // candy grams
        check("candies",candy);

        int orange = sc.nextInt();     // orange grams
        check("orange", orange);

        int apple = sc.nextInt();      //apple grams
        check("apple", apple);

        int giftWeight = sc.nextInt();
        check("gift weight", giftWeight);

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

    private void check (String name, int count){
        if (count == 0){
            throw new IllegalArgumentException("must be at least one " + name);
        }
        if (count < 0){
            throw new IllegalArgumentException("the number of " + name + " can not be negative.");
        }
    }
}
