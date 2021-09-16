package com.jad.filter;

import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@WebFilter(urlPatterns = "/*",filterName = "LoginFilter")
public class LoginFilter  implements Filter {
	private String encoding = "utf-8";
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI();
		if(uri.contains("login") || uri.contains("css") || uri.contains("js") || uri.contains("check")) {
			chain.doFilter(req, resp); 
		}else {
			HttpSession session = request.getSession();

			if(session.getAttribute("sysUser")==null) {
				request.setAttribute("message", "您还未登录，请先登录");
				request.getRequestDispatcher("/login").forward(req, resp);
			}else {
			chain.doFilter(req, resp);
			}
			
		}
//		System.out.println("ִ��ǰ");
//		chain.doFilter(req, resp);
		
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
