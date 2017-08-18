package com.qy.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DirtyWord extends HttpServletRequestWrapper{
    private HttpServletRequest request = null;
	public DirtyWord(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		java.util.List<String> wordList = new ArrayList<String>();
		String value=request.getParameter(name);
		InputStream is = request.getServletContext().getResourceAsStream("dirtyword.txt");
		InputStreamReader isr=null;
		try {
			isr = new InputStreamReader(is, "utf-8");//将InputStream包装成InputStreamReader
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(isr);//将InputStreamReader包装成BufferedReader
		String word = null;
		try {
			while ((word=reader.readLine())!=null) {  //逐行读取
				wordList.add(word);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (wordList!=null) {
			for (String string : wordList) {
				if (value.contains(string)) {
					value = value.replace(string, "**");
				}
			}
		}
		return value;
	}
	
}
