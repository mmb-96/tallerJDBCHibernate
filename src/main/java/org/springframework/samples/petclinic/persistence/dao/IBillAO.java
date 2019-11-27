package org.springframework.samples.petclinic.persistence.dao;

import java.util.List;

import org.springframework.samples.petclinic.bill.Bill;

public interface IBillAO extends IBaseDAO<Bill, Integer> {
	
	List<Bill> getBIllsByIdNumber(long idNumbet);
	
	List<Bill> getBIllsByIdNumberNamedQuery(long idNumbet);

}
