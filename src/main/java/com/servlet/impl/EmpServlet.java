package com.servlet.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.pojo.Dep;
import com.pojo.Emp;
import com.pojo.PageBean;
import com.pojo.Welfare;
import com.services.impl.BizService;
import com.servlet.IServlet;
import com.util.AjaxUtils;
@Controller
public class EmpServlet implements IServlet {
	@Resource(name="BizService")
	private BizService bizService;
	
	@Override
	@RequestMapping(value="sava_emp.do")
	public String save(HttpServletRequest request, HttpServletResponse response, Emp emp) {
		String realpath = request.getRealPath("/");
		MultipartFile multipartFile = emp.getPic();
		if (multipartFile != null && !multipartFile.isEmpty()) {
			String fname = multipartFile.getOriginalFilename();
			if (fname.lastIndexOf(".") != -1) {
				String ext = fname.substring(fname.lastIndexOf("."));
				if (ext.equalsIgnoreCase(".jpg")) {
					String newfname = new Date().getTime() + ext;
					File destFile = new File(realpath + "/uppic/" + newfname);
					try {
						FileUtils.copyInputStreamToFile(
								multipartFile.getInputStream(), destFile);
						emp.setPhoto(newfname);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		boolean flag=bizService.getEmpservice().save(emp);
		if(flag){
			AjaxUtils.printString(response, 1+"");
		}else{
			AjaxUtils.printString(response, 0+"");
		}
		return null;
	}

	@Override
	@RequestMapping(value="update_emp.do")
	public String update(HttpServletRequest request, HttpServletResponse response, Emp emp) {
		String realpath = request.getRealPath("/");
		String oldphoto=bizService.getEmpservice().findById(emp.getEid()).getPhoto();
		MultipartFile multipartFile = emp.getPic();
		if (multipartFile != null && !multipartFile.isEmpty()) {
			String fname = multipartFile.getOriginalFilename();
			if (fname.lastIndexOf(".") != -1) {
				String ext = fname.substring(fname.lastIndexOf("."));

				if (ext.equalsIgnoreCase(".jpg")) {
					String newfname = new Date().getTime() + ext;
					File destFile = new File(realpath + "/uppic/" + newfname);
					try {
						FileUtils.copyInputStreamToFile(
								multipartFile.getInputStream(), destFile);
						emp.setPhoto(newfname);
						
						File oldfile=new File(realpath+"/uppic/"+oldphoto);
						if(oldfile.exists()&&!oldphoto.equalsIgnoreCase("default.jpg")){
							oldfile.delete();
							
						}
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}else{
			emp.setPhoto(oldphoto);
		}
		boolean flag=bizService.getEmpservice().update(emp);
		if(flag){
			AjaxUtils.printString(response, 1+"");
		}else{
			AjaxUtils.printString(response, 0+"");
		}
		return null;
	}

	@Override
	@RequestMapping(value="delById_emp.do")
	public String delById(HttpServletRequest request, HttpServletResponse response, Integer eid) {
		boolean flag=bizService.getEmpservice().delById(eid);
		if(flag){
			AjaxUtils.printString(response, 1+"");
		}else{
			AjaxUtils.printString(response, 0+"");
		}
		return null;
	}

	@Override
	@RequestMapping(value="findById_emp.do")
	public String findById(HttpServletRequest request, HttpServletResponse response, Integer eid) {
		Emp oldemp=bizService.getEmpservice().findById(eid);
		PropertyFilter propertyFilter=AjaxUtils.filterProperts("birthday","pic");
		String jsonstr=JSONObject.toJSONString(oldemp,propertyFilter,SerializerFeature.DisableCircularReferenceDetect);
		AjaxUtils.printString(response, jsonstr);
		return null;
	}

	@Override
	@RequestMapping(value="findDetail_emp.do")
	public String findDetail(HttpServletRequest request, HttpServletResponse response, Integer eid) {
		Emp oldemp=bizService.getEmpservice().findById(eid);
		PropertyFilter propertyFilter=AjaxUtils.filterProperts("birthday","pic");
		String jsonstr=JSONObject.toJSONString(oldemp,propertyFilter,SerializerFeature.DisableCircularReferenceDetect);
		AjaxUtils.printString(response, jsonstr);
		return null;
	}

	@Override
	@RequestMapping(value="findPageAll_emp.do")
	public String findPageAll(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) {
		Map<String,Object> map=new HashMap<String,Object>();
		PageBean pb=new PageBean();
		page=page==null||page<1?pb.getPage():page;
		rows=rows==null||rows<1?pb.getRows():rows;
		if(rows>10)rows=10;
		pb.setPage(page);
		pb.setRows(rows);
		List<Emp> lsemp=bizService.getEmpservice().findPageAll(pb);
		int maxrows=bizService.getEmpservice().findMaxRows();
		map.put("page", page);
		map.put("rows", lsemp);
		map.put("total", maxrows);
		PropertyFilter propertyFilter=AjaxUtils.filterProperts("birthday","pic");
		String jsonstr=JSONObject.toJSONString(map,propertyFilter,SerializerFeature.DisableCircularReferenceDetect);
		AjaxUtils.printString(response, jsonstr);
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
