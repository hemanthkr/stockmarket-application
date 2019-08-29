package com.cts.service;

import java.util.List;

import com.cts.entity.IpoDetail;

public interface IpoDetailService {
	
	public String updateIpo(IpoDetail detail);
	
	public List<IpoDetail> fetchIpoDetail();
}
