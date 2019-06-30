import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lesson6UnitTestsTest {

    Lesson6UnitTests arrObj;

    @Before
    public void init(){
        arrObj = new Lesson6UnitTests();
    }

    @Test(expected = Exception.class)
    public void getNumsAfter4() {

        new Lesson6UnitTests().getNumsAfter4(new int[]{7, 8, 9, 2, 1, 5});

    }

    @Test
    public void Test1getNumsAfter4() {
        Assert.assertArrayEquals(new int[]{2, 1, 5}, arrObj.getNumsAfter4(new int[]{7, 8, 9, 4, 2, 1, 5}));
    }

    @Test
    public void Test1ifContains4and1() {
        Assert.assertEquals(true, arrObj.ifContains4and1(new int[]{1, 4, 1}));
    }


    @Test
    public void Test2ifContains4and1() {
        Assert.assertEquals(false, arrObj.ifContains4and1(new int[]{1, 4, 1, 5}));
    }

    @Test
    public void Test3ifContains4and1() {
        Assert.assertEquals(true, arrObj.ifContains4and1(new int[]{1, 4, 1, 1 , 1, 1, 1}));
    }





    
}