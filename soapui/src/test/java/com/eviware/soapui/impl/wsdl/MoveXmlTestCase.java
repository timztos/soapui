/*
 * Copyright 2004-2014 SmartBear Software
 *
 * Licensed under the EUPL, Version 1.1 or - as soon as they will be approved by the European Commission - subsequent
 * versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the Licence is
 * distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the Licence for the specific language governing permissions and limitations
 * under the Licence.
*/

package com.eviware.soapui.impl.wsdl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import junit.framework.JUnit4TestAdapter;

import org.apache.xmlbeans.XmlCursor;
import org.junit.Test;

import com.eviware.soapui.config.TestCaseConfig;
import com.eviware.soapui.config.TestStepConfig;

public class MoveXmlTestCase
{
	public static junit.framework.Test suite()
	{
		return new JUnit4TestAdapter( MoveXmlTestCase.class );
	}

	@Test
	public void testMoveXml() throws Exception
	{
		TestCaseConfig testCase = TestCaseConfig.Factory.newInstance();
		TestStepConfig step1 = testCase.addNewTestStep();
		TestStepConfig step2 = testCase.addNewTestStep();
		TestStepConfig step3 = testCase.addNewTestStep();

		List<TestStepConfig> testSteps = testCase.getTestStepList();
		assertEquals( 3, testSteps.size() );
		assertEquals( testSteps.get( 0 ), step1 );
		assertEquals( testSteps.get( 1 ), step2 );
		assertEquals( testSteps.get( 2 ), step3 );

		XmlCursor cursor1 = step3.newCursor();
		XmlCursor cursor2 = step2.newCursor();

		cursor1.moveXml( cursor2 );

		cursor1.dispose();
		cursor2.dispose();

		assertEquals( testSteps.get( 0 ), step1 );
		// assertEquals( testSteps.get( 1 ), step3 );
		assertEquals( testSteps.get( 2 ), step2 );
	}
}
