package com.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pojo.Welfare;

@Repository("WelfareDao")
public interface IWelfareMapper {
	public List<Welfare> findAll();
}
