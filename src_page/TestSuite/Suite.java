package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import TestCases.TC_01_Validate_Login;

//Set the enviroment for the suite
@RunWith(Suite.class)
@Suite.SuiteClasses({
	//All the test cases we have and want to run
	TC_01_Validate_Login.class,
})

public class Suite {

}
