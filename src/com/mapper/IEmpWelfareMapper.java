package com.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pojo.EmpWelfare;
import com.pojo.Welfare;

@Repository("EmpWelfareDao")
public interface IEmpWelfareMapper {
	// 保存员工福利
	public int save(EmpWelfare ewf);
	//根据员工编号，查询福利
	public List<Welfare> findByEid(Integer eid);
	//根据员工编号，删除福利
	public int delByEid(Integer eid);
}
