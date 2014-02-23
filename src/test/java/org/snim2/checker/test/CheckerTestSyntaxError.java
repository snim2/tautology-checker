package org.snim2.checker.tests;

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
public class CheckerTestSyntaxError {

	private String input;

	private boolean expected;


	public CheckerTestSyntaxError(String input, Boolean expected) {
		this.input = input;
		this.expected = (boolean)expected;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
			{"missing_rparen.prop", true},
			{"unbalanced_rparen.prop", true},
		});
	}

	@Test(expected = org.snim2.checker.error.SyntacticException.class)
	public void test() throws IOError, IOException {
		CheckerTestHelper checker = new CheckerTestHelper();
		Assert.assertEquals(this.expected, checker.checkFile(this.input));
	}

}