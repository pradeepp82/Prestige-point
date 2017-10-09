package com.aartek.prestigepoint.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LearningController {
	
	private static final Logger logger = Logger.getLogger(LearningController.class);
	PrintWriter out = null;
	HttpServletRequest req = null;
	HttpServletResponse res = null;
	List<String> list = null;

	String s = null;

	@RequestMapping(value = "/learning", method = RequestMethod.GET)
	public String welcome(Model m) {
		m.addAttribute("type", "corejava");
		m.addAttribute("subtype", "basicconcepts");
		return "learning";
	}

	@RequestMapping(value = "/corejava111", method = RequestMethod.GET)
	public String coreJava(@RequestParam("subtype") String subType, Model m) {

		m.addAttribute("type", "corejava");
		m.addAttribute("subtype", subType);

		return "corejava";

	}

	@RequestMapping(value = "/editor", method = { RequestMethod.GET, RequestMethod.POST })
	public String tryityourself(Model m, HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IOException, ServletException {
		return "editor";
	}

	@RequestMapping(value = "/editorAction.do", method = RequestMethod.GET)
	@ResponseBody
	public List<String> editor(@RequestParam(required = false) String editor, HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException, IOException, ServletException {
		s = editor;
		File f = new File("/home/aartek14/jvm/apache-tomcat-7.0.47/domains/prestigepoint.in/Main/Main.java");
		System.out.println(f.getAbsolutePath());
		FileOutputStream fos = new FileOutputStream(f);
		PrintStream ps = new PrintStream(fos);
		ps.println(s);
		ps.close();
		// out=response.getWriter();
		req = request;
		res = response;
		list = new ArrayList<String>();

		try {

			int k = runProcess("javac Main.java");
			if (k == 0)
				k = runProcess("java Main");

		} catch (Exception e) {
			logger.error("Exception",e);
		}
		return list;

	}

	private void printLines(String name, InputStream ins) throws Exception {
		String line = null;

		BufferedReader in = new BufferedReader(new InputStreamReader(ins));

		while ((line = in.readLine()) != null) {

			String s = line;
			list.add(s);
		}

		req.setAttribute("output", list);
		req.setAttribute("input", s);

	}

	private int runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);
		printLines(" ", pro.getInputStream());
		printLines(command + " stderr:", pro.getErrorStream());
		pro.waitFor();
		logger.info(command + " exitValue() " + pro.exitValue());
		return pro.exitValue();
	}

}
