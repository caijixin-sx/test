package com.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pojo.Welfare;
import com.services.IWelfareService;
@Service("WelfareService")
public class WelfareService implements IWelfareService{
	@Resource(name="DaoService")
	private DaoService daoService;
	@Override
	public List<Welfare> findAll() {
		return daoService.getWelfareMapper().findAll();
	}

}
