/*******************************************************************************
 * Copyright (c) 2004, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM - Initial API and implementation
 *******************************************************************************/
package org.eclipse.cdt.managedbuilder.makegen;

import org.eclipse.cdt.managedbuilder.core.IManagedBuildInfo;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.MultiStatus;

/**
 * @since 2.0
 * 
 * TODO:  isGeneratedResource should take an IPath rather than an IResource, 
 *        because an output file can be generated outside of the project directory.
 *        This will require a new interface. 
 */
public interface IManagedBuilderMakefileGenerator {

	public final String AT = "@";	//$NON-NLS-1$
	public final String COLON = ":";	//$NON-NLS-1$
	public final int COLS_PER_LINE = 80;
	public final String COMMENT_SYMBOL = "#";	//$NON-NLS-1$
    public final String DOLLAR_SYMBOL = "$";        //$NON-NLS-1$ 
	public final String DEP_EXT = "d";	//$NON-NLS-1$
	public final String DEPFILE_NAME = "subdir.dep";	//$NON-NLS-1$
	public final String DOT = ".";	//$NON-NLS-1$
    public final String DASH = "-"; //$NON-NLS-1$   
	public final String ECHO = "echo";	//$NON-NLS-1$
	public final String IN_MACRO = "$<";	//$NON-NLS-1$
	public final String LINEBREAK = "\\\n";	//$NON-NLS-1$
	public final String LOGICAL_AND = "&&";	//$NON-NLS-1$
	public final String MAKEFILE_DEFS = "makefile.defs"; //$NON-NLS-1$
	public final String MAKEFILE_INIT = "makefile.init"; //$NON-NLS-1$
	public final String MAKEFILE_NAME = "makefile";	//$NON-NLS-1$
	public final String MAKEFILE_TARGETS = "makefile.targets"; //$NON-NLS-1$
    public final String MAKE = "$(MAKE)";   //$NON-NLS-1$ 
    public final String NO_PRINT_DIR = "--no-print-directory";      //$NON-NLS-1$ 

	public final String MODFILE_NAME = "subdir.mk";	//$NON-NLS-1$
	public final String NEWLINE = System.getProperty("line.separator");	//$NON-NLS-1$
	public final String OBJECTS_MAKFILE = "objects.mk"; //$NON-NLS-1$
	public final String OUT_MACRO = "$@";	//$NON-NLS-1$
	public final String ROOT = "..";	//$NON-NLS-1$
	public final String SEPARATOR = "/";	//$NON-NLS-1$
	public final String SINGLE_QUOTE = "'";	//$NON-NLS-1$
	public final String SRCSFILE_NAME = "sources.mk"; //$NON-NLS-1$	
	public final String TAB = "\t";	//$NON-NLS-1$
	public final String WHITESPACE = " ";	//$NON-NLS-1$
	public final String WILDCARD = "%";	//$NON-NLS-1$
	
	// Generation error codes
	public static final int SPACES_IN_PATH = 0;
	public static final int NO_SOURCE_FOLDERS = 1;

	
	public void generateDependencies() throws CoreException;

	/**
	 * Clients call this method when an incremental rebuild is required. The argument
	 * contains a set of resource deltas that will be used to determine which 
	 * subdirectories need a new makefile and dependency list (if any). 
	 */
	public MultiStatus generateMakefiles(IResourceDelta delta)  throws CoreException ;
	
	/**
	 * Answers the path of the top directory generated for the build
	 * output, or <code>null</code> if none has been generated.
	 * 
	 * @return <code>IPath</code> to the working directory of the build
	 */
	public IPath getBuildWorkingDir();

	/**
	 * Answers the name of the top-level makefile generated by the receiver.
	 * 
	 * @return name of the makefile.
	 */
	public String getMakefileName();
	
	/**
	 * This method initializes the makefile generator
	 */
	public void initialize(IProject project, IManagedBuildInfo info, IProgressMonitor monitor);	

	/**
	 * Answers <code>true</code> if the argument is a resource created by the generator
	 */
	public boolean isGeneratedResource(IResource resource);
	
	public void regenerateDependencies(boolean force) throws CoreException;
	
	public MultiStatus regenerateMakefiles() throws CoreException;

}
