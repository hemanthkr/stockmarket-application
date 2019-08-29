package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Company;
import com.cts.entity.Sector;
import com.cts.repo.CompanyRepository;
import com.cts.repo.SectorRepository;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	SectorRepository sectorRepository;

	@Override
	@Transactional
	public String addCompany(Company company) {
		String result = "";
		try {
			Sector sector = new Sector();
			sector = sectorRepository.findByName(company.getSector().getName());
			company.setSector(sector);
			companyRepository.save(company);
			result = "Registered Successfully.";
		} catch (Exception exception) {
			result = "This company already exists.";
		}
		return result;
	}

	@Override
	@Transactional
	public String companyStatus(Company company) {
		String result = "";
		try {
			Company company2 = new Company();
			company2 = companyRepository.findByName(company.getName());
			if (company2.getStatus().equals("active")) {
				company2.setStatus(company.getStatus());
				companyRepository.save(company2);
				result = "Company has been deactivated.";
			} else if (company2.getStatus().equals("inactive")) {
				company2.setStatus(company.getStatus());
				companyRepository.save(company2);
				result = "Company has been activated.";
			}
		} catch (Exception exception) {
			result = "Unsuccessfull.";
		}
		return result;
	}

	@Override
	@Transactional
	public String updateCompany(Company company) {
		String result = "";
		try {
			Company company2 = companyRepository.findByName(company.getName());
			company2.setAbout(company.getAbout());
			company2.setBoardOfDirectors(company.getBoardOfDirectors());
			company2.setCeo(company.getCeo());
			companyRepository.save(company2);
			result = "Company details were updated.";
		} catch (Exception exception) {
			result = "Failed to update company details.";
		}
		return result;
	}


	@Override
	@Transactional
	public List<Company> getCompany() {
		List<Company> arrayList = new ArrayList<Company>();
		arrayList = companyRepository.findAll();
		return arrayList;
	}

}
