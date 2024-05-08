package report;

import org.testng.Reporter;
import org.testng.annotations.Test;

import baseclass.BaseClass;

public class ShooperStack  extends BaseClass{
	@Test
	public void regressions() {
		Reporter.log("hello", true);
	}

}
