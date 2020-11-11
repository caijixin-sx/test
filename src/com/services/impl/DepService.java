package com.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.Dep;
import com.services.IDepService;
@Service("DepService")
@Transactional
public class DepService implements IDepService {
	@Resource(name="DaoService")
	private DaoService daoService;
	@Override
	public List<Dep> findAll() {
		return daoService.getDepmapper().findAll();
	}

}
