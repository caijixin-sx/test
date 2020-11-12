package com.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pojo.Emp;
import com.pojo.PageBean;

@Repository("EmpDao")
public interface IEmpMapper {
	public int save(Emp emp);
	public int update(Emp emp);
	public int delById(Integer eid);
	public Emp findById(Integer eid);
	public List<Emp> findPageAll(PageBean pb);
	public int findMaxRows();
	public int findLastEmpId();
}
