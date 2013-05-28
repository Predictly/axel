/**
 * Copyright (C) 2013 Inera AB (http://www.inera.se)
 *
 * This file is part of Inera Axel (http://code.google.com/p/inera-axel).
 *
 * Inera Axel is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Inera Axel is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package se.inera.axel.shs.exception;

/**
 * @author Jan Hallonstén, R2M
 *
 */
public class MissingAgreementException extends ShsException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String ERROR_CODE = "MissingAgreement";
	
	private static final String ERROR_INFO = "Agreement missing at local delivery";

	public MissingAgreementException() {
		super(ERROR_CODE, ERROR_INFO);
	}
	
	public MissingAgreementException(String errorInfo) {
		super(ERROR_CODE, errorInfo);
	}
	
	public MissingAgreementException(Throwable cause) {
		super(ERROR_CODE, ERROR_INFO, cause);
	}
	
	public MissingAgreementException(String errorInfo, Throwable cause) {
		super(ERROR_CODE, errorInfo, cause);
	}
}
