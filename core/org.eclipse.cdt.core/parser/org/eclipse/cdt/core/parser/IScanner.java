package org.eclipse.cdt.core.parser;

import org.eclipse.cdt.core.parser.ast.IASTFactory;

/**
 * @author jcamelon
 *
 */
public interface IScanner  {

	public static final int tPOUNDPOUND = -6;
	public static final int tPOUND      = -7;
	
	public void setOffsetBoundary( int offset );
	
	public void setASTFactory( IASTFactory f );
	public void addDefinition(String key, IMacroDescriptor macroToBeAdded );
	public void addDefinition(String key, String value); 
	public Object getDefinition(String key);

	public String[] getIncludePaths();
	public void addIncludePath(String includePath); 
	public void overwriteIncludePath( String [] newIncludePaths );
	
	public IToken nextToken() throws ScannerException, EndOfFileException, OffsetLimitReachedException;
	public IToken nextToken( boolean next ) throws ScannerException, EndOfFileException, OffsetLimitReachedException;
			
	public int  getCount();
	public int  getDepth();

	public IToken nextTokenForStringizing() throws ScannerException, EndOfFileException, OffsetLimitReachedException;
	public void setTokenizingMacroReplacementList(boolean b);
	public void setThrowExceptionOnBadCharacterRead( boolean throwOnBad );

    /**
     * @param i
     * @return
     */
    public int getLineNumberForOffset(int i);
}
