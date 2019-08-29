package com.cts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "company_name", nullable = false, unique = true)
	private String name;

	@Column(name = "comapany_ceo", nullable = false, length = 100)
	private String ceo;

	@Column(name = "board_of_directors", nullable = false, length = 100)
	private String boardOfDirectors;

	@OneToOne()
	private Sector sector;

	@Column(length = 100)
	private String about;

	@Column(nullable = false, length = 30)
	private String status;

	public Company() {
		super();
	}

	public Company(int id, String name, String ceo, String boardOfDirectors, Sector sector, String about,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.sector = sector;
		this.about = about;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", ceo=" + ceo + ", boardOfDirectors=" + boardOfDirectors
				+ ", sector=" + sector + ", about=" + about + ", status=" + status + "]";
	}

}
