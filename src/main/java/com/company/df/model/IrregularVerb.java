package com.company.df.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.PersistenceConstructor;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_irregularVerb")
@Getter
@Setter

public class IrregularVerb {
	
	@Id
	@Column(name="Idx")
	private Long idx;
	
	@Column(name="Inf")
	private String inf;
	
	@Column(name="Pra")
	private String pra;
	
	@Column(name="Per")
	private String per;

	public IrregularVerb() {}
	public Long getIdx() {
		return idx;
	}

	public void setIdx(Long idx) {
		this.idx = idx;
	}

	public String getInf() {
		return inf;
	}

	public void setInf(String inf) {
		this.inf = inf;
	}

	public String getPra() {
		return pra;
	}

	public void setPra(String pra) {
		this.pra = pra;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}
	

}
