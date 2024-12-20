package com.project.software.advanced.demo.Util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthFilter.class);
	private final JwtUtil jwtUtil;

	private final UserDetailsService userDetailsService;

	public JwtAuthFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
	}

	// Middleware
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			String token = authHeader.substring(7);
			String email = jwtUtil.extractUsername(token);

			if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				if (jwtUtil.validateToken(token, email)) {
					String role = jwtUtil.extractRole(token);
					String requestURI = request.getRequestURI();
					logger.info("Request URI: {}, Email: {}", requestURI, email);
					// if (role.contains("STUDENT")) {
					// if (requestURI.contains("instructor") || requestURI.contains("admin")) {
					// response.setStatus(HttpStatus.FORBIDDEN.value());
					// response.getWriter().write("Error: Forbidden action for student");
					// return;
					// }
					// }
					// if (role.contains("INSTRUCTOR") && requestURI.contains("admin")) {
					// response.setStatus(HttpStatus.FORBIDDEN.value());
					// response.getWriter().write("Error: Forbiddenxd");
					// return;
					// }

					UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
					var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		}

		filterChain.doFilter(request, response);
	}
}
