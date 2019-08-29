package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cts.entity.Company;
import com.cts.entity.IpoDetail;
import com.cts.repo.CompanyRepository;
import com.cts.repo.IpoDetailRepository;

@Service("ipoDetailService")
public class IpoDetailServiceImpl implements IpoDetailService {
	
	@Autowired
	IpoDetailRepository ipoDetailRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Override
	@Transactional
	public String updateIpo(IpoDetail detail) {
		String result = "";
		IpoDetail ipoDetail = new IpoDetail();
		try {
			ipoDetail = ipoDetailRepository.findByCompanyNameAndStockExchange(detail.getCompanyName(),
					detail.getStockExchange());
			if (ipoDetail != null) {
				ipoDetail.setOpenDateTime(detail.getOpenDateTime());
				ipoDetail.setPricePerShare(detail.getPricePerShare());
				ipoDetail.setTotalShare(detail.getTotalShare());
				ipoDetail.setRemarks(detail.getRemarks());
				ipoDetailRepository.save(ipoDetail);
				result = "Company Ipo Details have been updated.";
			} else {
				Company company = companyRepository.findByName(detail.getCompanyName());
				detail.setCompanyId(company.getId());
				ipoDetailRepository.save(detail);
				result = "New Company Ipo Detaisl have been added.";
			}
		} catch (Exception exception) {
			result = "Unsuccessfull.";
		}
		return result;
	}

	@Override
	@Transactional
	public List<IpoDetail> fetchIpoDetail() {
		List<IpoDetail> arrayList = new ArrayList<IpoDetail>();
		arrayList = ipoDetailRepository.findAll(Sort.by(Sort.Direction.ASC, "open_date_time"));
		return arrayList;
	}
}
