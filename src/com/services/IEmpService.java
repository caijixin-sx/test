package com.services;

import java.util.List;

import com.pojo.Emp;
import com.pojo.PageBean;

public interface IEmpService {
	public boolean save(Emp emp);
	public boolean update(Emp emp);
	public boolean delById(Integer eid);
	public Emp findById(Integer eid);
	public List<Emp> findPageAll(PageBean pb);
	public int findMaxRows();
}
