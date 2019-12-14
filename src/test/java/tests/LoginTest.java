package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

   @Test
   public void test1() {
      Assert.assertEquals(1, 2);
   }

   @Test
   public void test2() {
      System.out.println("Git are you spying on me?");
      Assert.assertEquals(1, 2);
   }


   @Test
   public void test3() {
      Assert.assertEquals(1, 2);
   }
}
