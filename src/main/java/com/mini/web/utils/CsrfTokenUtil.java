package com.mini.web.utils;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

public class CsrfTokenUtil {
	private static final String Csrf_RQ_PARAM_NAME = "Csrf_RQ_PARAM_NAME";
	private static final String Csrf_SN_PARAM_NAME = "CsrfToken.sess.tkVal";

	private CsrfTokenUtil() {
	};

	public static String getTokenForSession(HttpSession session) {
		String sessionToken;
		synchronized (session) {
			sessionToken = (String) session.getAttribute(Csrf_SN_PARAM_NAME);
			if (StringUtils.isBlank(sessionToken)) {
				sessionToken = UUID.randomUUID().toString();
				session.setAttribute(Csrf_SN_PARAM_NAME, sessionToken);
			}
		}
		return sessionToken;
	}

	public static String getTokenFromRequest(HttpServletRequest request) {
		return StringUtils.isBlank(request.getParameter(Csrf_RQ_PARAM_NAME)) ? request.getHeader("Csrf_RQ_PARAM_NAME") : request.getParameter(Csrf_RQ_PARAM_NAME);
	}

}
