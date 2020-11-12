package com.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.services.*;

@Service("BizService")
public class BizService {
	@Resource(name="DepService")
	private IDepService depservice;
	@Resource(name="EmpService")
	private IEmpService empservice;	
	@Resource(name="WelfareService")
	private IWelfareService welfareservice;
	public IDepService getDepservice() {
		return depservice;
	}
	public void setDepservice(IDepService depservice) {
		this.depservice = depservice;
	}
	public IEmpService getEmpservice() {
		return empservice;
	}
	public void setEmpservice(IEmpService empservice) {
		this.empservice = empservice;
	}
	public IWelfareService getWelfareservice() {
		return welfareservice;
	}
	public void setWelfareservice(IWelfareService welfareservice) {
		this.welfareservice = welfareservice;
	}
	
}
