package com.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.*;

@Service("DaoService")
public class DaoService {
	
	@Resource(name="DepDao")
	private IDepMapper depmapper;
	@Resource(name="EmpDao")
	private IEmpMapper empmapper;
	@Resource(name="EmpWelfareDao")
	private IEmpWelfareMapper empWelfareMapper;
	@Resource(name="SalaryDao")
	private ISalarymapper salarymapper;
	@Resource(name="WelfareDao")
	private IWelfareMapper welfareMapper;
	public IDepMapper getDepmapper() {
		return depmapper;
	}
	public void setDepmapper(IDepMapper depmapper) {
		this.depmapper = depmapper;
	}
	public IEmpMapper getEmpmapper() {
		return empmapper;
	}
	public void setEmpmapper(IEmpMapper empmapper) {
		this.empmapper = empmapper;
	}
	public IEmpWelfareMapper getEmpWelfareMapper() {
		return empWelfareMapper;
	}
	public void setEmpWelfareMapper(IEmpWelfareMapper empWelfareMapper) {
		this.empWelfareMapper = empWelfareMapper;
	}
	public ISalarymapper getSalarymapper() {
		return salarymapper;
	}
	public void setSalarymapper(ISalarymapper salarymapper) {
		this.salarymapper = salarymapper;
	}
	public IWelfareMapper getWelfareMapper() {
		return welfareMapper;
	}
	public void setWelfareMapper(IWelfareMapper welfareMapper) {
		this.welfareMapper = welfareMapper;
	}
	
}
