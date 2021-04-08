package demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestCase 
{
  @BeforeClass
  public static void beforeclassmethod()
  {
    System.out.println("Before Class");
  }
  @Before
  public void beforetest()
  {
    System.out.println("Before Testcase");
  }

  @Test
  public void test() 
  {
    System.out.println("Your Actual TestCase");
    assertEquals(3,findResult.FindMaxNum(new int[] {1,2,3}));
  }
  
  @After
  public void after()
  {
    System.out.println("After Testcase");
  }
  @AfterClass
  public static void afterclass()
  {
    System.out.println("After Class");
  }


}