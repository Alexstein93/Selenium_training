package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import TestCases.TC_01_Validate_Login;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TC_01_Validate_Login.class,
})

public class SuiteClues {

}
