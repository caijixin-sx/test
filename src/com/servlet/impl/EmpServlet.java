package com.servlet.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.pojo.Dep;
import com.pojo.Emp;
import com.pojo.Welfare;
import com.services.impl.BizService;
import com.servlet.IServlet;
import com.util.AjaxUtils;
@Controller
public class EmpServlet implements IServlet {
	@Resource(name="BizService")
	private BizService bizService;
	
	@Override
	public String save(HttpServletRequest request, HttpServletResponse response, Emp emp) {
		return null;
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response, Emp emp) {
		return null;
	}

	@Override
	public String delById(HttpServletRequest request, HttpServletResponse response, Integer eid) {
		return null;
	}

	@Override
	public String findById(HttpServletRequest request, HttpServletResponse response, Integer eid) {
		return null;
	}

	@Override
	public String findDetail(HttpServletRequest request, HttpServletResponse response, Integer eid) {
		return null;
	}

	@Override
	public String findPageAll(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) {
		return null;
	}

	@Override
	@RequestMapping(value="/doinit_emp.do")
	public String doinit(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Dep> lsdep = bizService.getDepservice().findAll();
		List<Welfare> lswf = bizService.getWelfareservice().findAll();
		map.put("lsdep", lsdep);
		map.put("lswf", lswf);
		String jsonString = JSONObject.toJSONString(map);
		AjaxUtils.printString(response, jsonString);
		return null;
	}

}
