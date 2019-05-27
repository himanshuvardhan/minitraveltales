/**
 * 
 */
package com.mini.web.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.support.RequestDataValueProcessor;

/**
 * @author Himanshu_Vardhan
 *
 */
public class CustomRequestDataValueProcessor implements RequestDataValueProcessor {

	@Override
	public String processAction(HttpServletRequest aRequest, String action, String httpMethod) {
		return action;
	}

	@Override
	public String processFormFieldValue(HttpServletRequest request, String name, String value, String type) {
		return value;
	}

	@Override
	public Map<String, String> getExtraHiddenFields(HttpServletRequest request) {
		Map<String, String> hiddenFields = new HashMap<String, String>();
		hiddenFields.put("CsrfToken", CsrfTokenUtil.getTokenForSession(request.getSession(false)));
		return hiddenFields;
	}

	@Override
	public String processUrl(HttpServletRequest request, String url) {
		return url;
	}

}