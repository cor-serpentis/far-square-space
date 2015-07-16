package com.github.corserpentis.fqs;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Exception class that should be thrown by application components.
 *
 * @author Kirill V. Karavaev
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 2614427229619899524L;

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * @param message
	 *        the detailed explanation of the error
	 * @param cause
	 *        the reason of throwing this exception
	 */
	@ParametersAreNonnullByDefault
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * @param message
	 *        the detailed explanation of the error
	 */
	@ParametersAreNonnullByDefault
	public ApplicationException(String message) {
		super(message);
	}

}
