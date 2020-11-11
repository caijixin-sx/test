package com.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.*;
import com.services.IEmpService;
@Service("EmpService")
@Transactional
public class EmpService implements IEmpService{
	@Resource(name="DaoService")
	private DaoService daoService;
	@Override
	public boolean save(Emp emp) {
		int code = daoService.getEmpmapper().save(emp);
		if(code>0){
			int empid = daoService.getEmpmapper().findLastEmpId();
			Salary sa = new Salary(empid,emp.getEmoney());
			daoService.getSalarymapper().sava(sa);
			String[] wids = emp.getWids();
			if(null!=wids&&wids.length>0){
				for (int i = 0; i < wids.length; i++) {
					EmpWelfare ewf = new EmpWelfare(empid,Integer.parseInt(wids[i]));
					daoService.getEmpWelfareMapper().save(ewf);
				}
				
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Emp emp) {
		int code = daoService.getEmpmapper().update(emp);
		if(code>0){
			//修改薪资
			Salary empsalary = daoService.getSalarymapper().findSalaryByEid(emp.getEid());
			if(null!=empsalary&&empsalary.getEmoney()!=null){
				//有薪资更新
				empsalary.setEmoney(emp.getEmoney());
				daoService.getSalarymapper().updateByEid(empsalary);
			}else{
				//没有薪资保存
				Salary sa = new Salary(emp.getEid(),emp.getEmoney());
				daoService.getSalarymapper().sava(sa);
			}
			//修改福利
			List<Welfare> lswf = daoService.getEmpWelfareMapper().findByEid(emp.getEid());
			if(null!=lswf&&lswf.size()>0){
				//有福利删除
				daoService.getEmpWelfareMapper().delByEid(emp.getEid());
			}
			String[] ewfArray = emp.getWids();
			if(ewfArray!=null&&ewfArray.length>0){
				for(int i=0;i<ewfArray.length;i++){
					EmpWelfare ewf=new EmpWelfare(emp.getEid(),Integer.parseInt(ewfArray[i]));
					daoService.getEmpWelfareMapper().save(ewf);
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean delById(Integer eid) {
		daoService.getEmpWelfareMapper().delByEid(eid);
		daoService.getSalarymapper().delByEid(eid);
		int code = daoService.getEmpmapper().delById(eid);
		if(code>0){
			return true;
		}
		return false;
	}

	@Override
	public Emp findById(Integer eid) {
		Emp oldemp = daoService.getEmpmapper().findById(eid);
		Salary oldSalary = daoService.getSalarymapper().findSalaryByEid(eid);
		if(null!=oldSalary&&null!=oldSalary.getEmoney()){
			oldemp.setEmoney(oldSalary.getEmoney());
		}
		List<Welfare> lswf = daoService.getEmpWelfareMapper().findByEid(eid);
		if(lswf!=null&&lswf.size()>0){
			//创建福利数组
			String[] wids=new String[lswf.size()];
			for(int i=0;i<lswf.size();i++){
				Welfare wf=lswf.get(i);
				wids[i]=wf.getWid().toString();
			}
			oldemp.setWids(wids);
		}
		/******获取福利end*******/
		oldemp.setLswf(lswf);//详细页面
		return oldemp;
	}

	@Override
	public List<Emp> findPageAll(PageBean pb) {
		if(null!=pb){
			return daoService.getEmpmapper().findPageAll(pb);
		}
		return null;
	}

	@Override
	public int findMaxRows() {
		return daoService.getEmpmapper().findLastEmpId();
	}


}
