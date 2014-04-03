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

package com.eviware.soapui.model.mock;

import com.eviware.soapui.impl.wsdl.mock.DispatchException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A MockDispatcher can dispatch a web request and construct a MockResult from the proceedings.
 * Since it is a "mock" dispatcher it doesn't actually make any calls but rather fakes it.
 */
public interface MockDispatcher
{
	/**
	 * Should dispatch the web request represented by the request/response pair.
	 *
	 * @param request A servlet request.
	 * @param response A servlet response.
	 * @return A MockResult containing information about the result like the actual content - pointers to
	 *         involved operations and the found response etc.
	 * @throws DispatchException
	 */
	public MockResult dispatchRequest( HttpServletRequest request, HttpServletResponse response )
			throws DispatchException;
}
