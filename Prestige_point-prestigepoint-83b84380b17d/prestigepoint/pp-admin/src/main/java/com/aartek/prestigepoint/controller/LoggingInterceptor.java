package com.aartek.prestigepoint.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.aartek.prestigepoint.model.AdminLogin;

/**
 * 
 * @author Meenal Pathre
 *
 */
@Component
public class LoggingInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log = Logger.getLogger(LoggingInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		AdminLogin login = (AdminLogin) request.getSession().getAttribute("login");
		if (login == null || login.equals("")) {
			response.sendRedirect("login.do");
			return false;
		}

		log.info("This is preHandle !");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("This is postHandle !");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("This is aftercompletion !");

	}
}