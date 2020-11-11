package com.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pojo.Dep;

@Repository("DepDao")
public interface IDepMapper {
	public List<Dep> findAll();
}
