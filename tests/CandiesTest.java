import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Created by zOpa
 */

public class CandiesTest {
     private Candies candies = new Candies();
     private Random random  = new Random();

    @Test
    public void CandiesTests () throws IOException {
      test(3,1,1,1,1);
      test(3,2,2,2,2);
      test(3,6,6,6,6);
      test(10,6,6,6,18);
      test(3,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);


      test(0,2,2,2,1);
        //// TODO:
//      test(0,(random.nextInt() + 2) - 2,(random.nextInt() + 2) - 2, (random.nextInt() + 2) - 2,1);

      test(3,10,25,15,40);
    }

    @Test
    public void exceptionTests () throws IOException {
        // test for zero
        exceptTest(0,1,1,1);
        exceptTest(1,0,1,1);
        exceptTest(1,1,0,1);
        exceptTest(1,1,1,0);
        exceptTest(1,1,0,0);
        exceptTest(1,0,0,0);
        exceptTest(0,0,0,0);
        exceptTest(0,1,1,0);
        exceptTest(1,0,1,0);

        // test for negative
        exceptTest(-1,1,1,1);
        exceptTest(1,-1,1,1);
        exceptTest(1,1,-1,1);
        exceptTest(1,1,1,-1);
        exceptTest(-1,1,1,-1);
        exceptTest(1,-1,-1,1);
        exceptTest(1,1,-1,-1);
        exceptTest(-1,-1,1,1);
        exceptTest(-1,-1,1,-1);
        exceptTest(-1,-1,-1,-1);

        exceptTest(Integer.MIN_VALUE,-1,-1,-1);
        exceptTest(Integer.MIN_VALUE,Integer.MIN_VALUE,-1,-1);
        exceptTest(Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,-1);
        exceptTest(Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE);

        exceptTest(-random.nextInt(1),-1,-1,-1);
        exceptTest(-random.nextInt(1),-random.nextInt(1),-1,-1);
        exceptTest(-random.nextInt(1),-random.nextInt(1),-random.nextInt(1),-1);
        exceptTest(-random.nextInt(1),-random.nextInt(1),-random.nextInt(1),-random.nextInt(1));

    }

    public void test (int expected, int candy, int orange, int apple, int presentGrams) throws IOException {
        fillFile(candy, orange, apple, presentGrams);
        Scanner sc = new Scanner(new File("outputCandies.txt"));
        candies.run();
        assertEquals(expected, sc.nextInt());
    }

    public void exceptTest ( int candy, int orange, int apple, int presentGrams) throws IOException {
        fillFile(candy, orange, apple, presentGrams);
        try {
            candies.run();
            fail();
        } catch (IllegalArgumentException iae) {
            //correct
        }

    }

    private void fillFile (int candy, int orange, int apple, int presentGrams) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("inputCandies.txt"));
        pw.print(candy + " ");
        pw.print(orange + " ");
        pw.print(apple + " ");
        pw.print(presentGrams);
        pw.close();
    }
}
