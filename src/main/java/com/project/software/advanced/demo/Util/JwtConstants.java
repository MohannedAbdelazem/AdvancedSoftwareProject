package com.project.software.advanced.demo.Util;

public class JwtConstants {
	public static final String SECRET_KEY = "vg2Bpr5ikGSzvN1kJ14xLTCsZsZOT1s8Ik7zXSC0LgM";
	/**
	 * 10 HOURS
	 */
	public static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
}
