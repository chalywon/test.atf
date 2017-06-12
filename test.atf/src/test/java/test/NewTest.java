package test;

import org.testng.annotations.Test;
import java.util.Date;

import com.atf.support.DateFormat;

public class NewTest {
  @Test
  public void f() {
	  System.out.println(DateFormat.accountDateFormat(new Date()));
  }
}
