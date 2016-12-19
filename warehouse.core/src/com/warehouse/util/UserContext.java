package com.warehouse.util;

import gaf2.core.security.GAFAuthentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserContext {
	public static Long getuserid(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		GAFAuthentication<?, ?> authex = (GAFAuthentication<?, ?>)auth;
		Long userid = Long.parseLong(authex.getUserId());
		return userid;
	}
}
