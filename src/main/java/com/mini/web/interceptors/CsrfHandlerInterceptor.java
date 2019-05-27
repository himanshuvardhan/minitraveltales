/**
 * 
 */
package com.mini.web.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mini.web.utils.CsrfTokenUtil;

/**
 * @author Himanshu_Vardhan
 *
 */
public class CsrfHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

		if (!StringUtils.containsIgnoreCase(request.getPathInfo(), ".htm") && StringUtils.containsIgnoreCase(request.getServletPath(), "/rest")
				|| !StringUtils.equalsIgnoreCase("POST", request.getMethod())) {
			return true;
		} else {
			String sesToken = CsrfTokenUtil.getTokenForSession(request.getSession(false));
			String reqToken = CsrfTokenUtil.getTokenFromRequest(request);
			if (StringUtils.equals(sesToken, reqToken)) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (request.getSession() != null) {
			request.setAttribute("Csrf_RQ_PARAM_NAME", CsrfTokenUtil.getTokenForSession(request.getSession(false)));
		}
	}
}