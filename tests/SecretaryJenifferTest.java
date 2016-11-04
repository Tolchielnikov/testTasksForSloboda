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
public class SecretaryJenifferTest {

    Random random =  new Random();
    static SecretaryJeniffer sj = new SecretaryJeniffer();

    @Test
    public void jenifferTest() throws IOException {
        test(1,1,1,1);
        test(2,2,1,1);
        test(2,3,1,1);
      test(3,4,1,1);
      test(3,5,1,1);
      test(4,5,1,2);
        test(2,1,2,2);
        test(4,2,2,2);
        test(4,3,2,2);
        test(6,4,2,2);
        test(3,1,3,3);
        test(6,2,3,3);
        test(12,2,6,6);

        //zero
        test(0,0,0,0);
        test(0,0,1,1);
        test(0,0,2,2);
        test(0,0,Integer.MAX_VALUE,Integer.MAX_VALUE);
        test(0,0,Integer.MAX_VALUE,Integer.MAX_VALUE);
        test(0,0,random.nextInt(Integer.MAX_VALUE),random.nextInt(Integer.MAX_VALUE));
    }

    @Test
    public void testToException () throws IOException {
        //zero
        testExcept(1,0,1);
        testExcept(1,1,0);
        testExcept(1,0,0);

        //negative
        testExcept(1,-1,1);
        testExcept(1,1,-1);
        testExcept(1,-1,-1);
        testExcept(5,-145,-1564);
        testExcept(56,-256,-4566);
        testExcept(456,-5645,-85);
        testExcept(8656,-6945,-54);
        testExcept(121,-54564,-132341);
        testExcept(5631,-145656,-14445);
        testExcept(1,Integer.MIN_VALUE, Integer.MIN_VALUE);
        testExcept(1, 1, -random.nextInt(Integer.MAX_VALUE));
        testExcept(1, -random.nextInt(Integer.MAX_VALUE), 1);
        testExcept(1, -random.nextInt(Integer.MAX_VALUE), -random.nextInt(Integer.MAX_VALUE));

    }

    static public void test (int expected, int count, int timeFirst, int timeSecond) throws IOException {
        fillFile(count,timeFirst,timeSecond);
        sj.run();
        Scanner sc = new Scanner(new File("outputJeniffer.txt"));
        assertEquals(expected, sc.nextInt());
    }

    static public void testExcept (int count, int timeFirst, int timeSecond) throws IOException {
        fillFile(count,timeFirst,timeSecond);
         try {
             sj.run();
            fail();
        } catch (IllegalArgumentException iae) {
            //correct
        }
    }

   static private void fillFile (int count, int timeFirst, int timeSecond) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("inputJeniffer.txt"));
        pw.print(count  + " ");
        pw.print(timeFirst + " ");
        pw.print(timeSecond + " ");
        pw.close();
    }
}
