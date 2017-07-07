/**
 * 
 */
package com.quantcast.codingchallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manav
 *
 */
@SuppressWarnings("serial")
public class CyclicDependencyException extends Exception {
	
	List<String> cyclicDependency;
	String msg;
	
	public CyclicDependencyException() {
		this.cyclicDependency = new ArrayList<String>();
	}

	public CyclicDependencyException(String msg) {
		this();
		this.msg = msg;
	}

}
