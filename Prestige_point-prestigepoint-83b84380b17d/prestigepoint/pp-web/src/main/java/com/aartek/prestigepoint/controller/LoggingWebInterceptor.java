package com.aartek.prestigepoint.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.aartek.prestigepoint.model.Registration;

/**
 * 
 * @author Meenal Pathre
 *
 */
@Component
public class LoggingWebInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger.getLogger(LoggingWebInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		Registration registration = (Registration) request.getSession().getAttribute("registration");

		if (registration == null || registration.equals("")) {
			response.sendRedirect("login.do");
			return false;
		}

		logger.info("This is preHandle !");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("This is postHandle !");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("This is aftercompletion !");

	}
}