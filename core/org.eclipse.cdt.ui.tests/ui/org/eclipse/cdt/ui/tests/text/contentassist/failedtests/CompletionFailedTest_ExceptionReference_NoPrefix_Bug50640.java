/**********************************************************************
 * Copyright (c) 2004 Rational Software Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v0.5
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v05.html
 * 
 * Contributors: 
 * IBM Rational Software - Initial API and implementation
***********************************************************************/
package org.eclipse.cdt.ui.tests.text.contentassist.failedtests;


import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.cdt.core.parser.ast.IASTCompletionNode.CompletionKind;
import org.eclipse.cdt.ui.tests.text.contentassist.CompletionProposalsBaseTest;

/**
 * @author hamer
 * 
 * Testing Exception_Reference, with No prefix
 * Bug#50640 : Wrong completion kind when expecting an exception
 *
 */
public class CompletionFailedTest_ExceptionReference_NoPrefix_Bug50640  extends CompletionProposalsBaseTest{
	
	private final String fileName = "CompletionFailedTestStart10.cpp";
	private final String fileFullPath ="resources/contentassist/failedtests/" + fileName;
	private final String headerFileName = "CompletionTestStart.h";
	private final String headerFileFullPath ="resources/contentassist/" + headerFileName;
	private final String expectedScopeName = "ASTCodeScope"; // should be "ASTMethod";
	private final String expectedContextName = "null"; 
	private final CompletionKind expectedKind = CompletionKind.STATEMENT_START; // should be CompletionKind.EXCEPTION_REFERENCE ;
	private final String expectedPrefix = ""; 
	private final String[] expectedResults = {
// Should be 			
//			"aClass",
//			"anotherClass",
//			"aNamespace",
//			"anEnumeration",
//			"AStruct",
//			"..."
	};
	
	public CompletionFailedTest_ExceptionReference_NoPrefix_Bug50640(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite suite= new TestSuite(CompletionFailedTest_ExceptionReference_NoPrefix_Bug50640.class.getName());
		suite.addTest(new CompletionFailedTest_ExceptionReference_NoPrefix_Bug50640("testCompletionProposals"));
		return suite;
	}		
	
	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.codeassist.tests.CompletionProposalsTest#getCompletionPosition()
	 */
	protected int getCompletionPosition() {
		return getBuffer().indexOf("      ") + 2;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.codeassist.tests.CompletionProposalsTest#getExpectedScope()
	 */
	protected String getExpectedScopeClassName() {
		return expectedScopeName;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.codeassist.tests.CompletionProposalsTest#getExpectedContext()
	 */
	protected String getExpectedContextClassName() {
		return expectedContextName;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.codeassist.tests.CompletionProposalsTest#getExpectedKind()
	 */
	protected CompletionKind getExpectedKind() {
		return expectedKind;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.codeassist.tests.CompletionProposalsTest#getExpectedPrefix()
	 */
	protected String getExpectedPrefix() {
		return expectedPrefix;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.codeassist.tests.CompletionProposalsTest#getExpectedResultsValues()
	 */
	protected String[] getExpectedResultsValues() {
		return expectedResults;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.codeassist.tests.CompletionProposalsTest#getFileName()
	 */
	protected String getFileName() {
		return fileName;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.codeassist.tests.CompletionProposalsTest#getFileFullPath()
	 */
	protected String getFileFullPath() {
		return fileFullPath;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.codeassist.tests.CompletionProposalsTest#getHeaderFileFullPath()
	 */
	protected String getHeaderFileFullPath() {
		return headerFileFullPath;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.codeassist.tests.CompletionProposalsTest#getHeaderFileName()
	 */
	protected String getHeaderFileName() {
		return headerFileName;
	}

}
