package org.snim2.checker.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import org.snim2.checker.ast.Formula;
import org.snim2.checker.parser.Parser;

@RunWith(Parameterized.class)
public class TestCheckerTautologies {

	private String input;

	private boolean expected;


	public TestCheckerTautologies(String input, Boolean expected) {
		this.input = input;
		this.expected = (boolean)expected;
	}

	@Parameterized.Parameters
	public static Collection data() {
		// "bug.prop",
		return Arrays.asList(new Object[][] {
			{"full_adder.prop", true},
		    {"peirces_law.prop", true},
		    {"taut1.prop", true},
		    {"taut2.prop", true},
		    {"taut3.prop", true},
		    {"taut4.prop", true},
		    {"taut5.prop", true},
		    {"true.prop", true},
		    {"and.prop", false},
		    {"atom.prop", false},
		    {"braces.prop", false},
		    {"deMorgan.prop", false},
		    {"double_negative.prop", false},
		    {"double_negative2.prop", false},
		    {"false.prop", false},
		    {"iff.prop", false},
		    {"implications.prop", false},
		    {"impl.prop", false},
		    {"large_adder.prop", false},
		    {"missing_operator.prop", false},
		    {"missing_operator2.prop", false},
		    {"neg.prop", false},
		    {"or.prop", false},
		    {"small_adder.prop", false},
		    {"stuff.prop", false},
		});
	}

	@Test
	public void test() throws IOError, IOException {
		CheckerTestHelper checker = new CheckerTestHelper();
		Assert.assertEquals(this.expected, checker.checkFile(this.input));
	}

}