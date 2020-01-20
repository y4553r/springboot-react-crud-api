package com.y4553r.springboot.demo.mycoolapp.Exceptions;

import javax.persistence.NoResultException;

public class NoEmployeeWithProvidedIdFound extends NoResultException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoEmployeeWithProvidedIdFound(String errorMessage) {
		super(errorMessage);
	}
	
}
