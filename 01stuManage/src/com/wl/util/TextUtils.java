package com.wl.util;

public class TextUtils {

	/**
	 * 判断某一个字符串是否为空。
	 * @param s
	 * @return
	 * CharSequence 字符串的父接口
	 */
	public static boolean isEmpty(CharSequence s){
		return s==null || s.length() == 0;
	}
}
