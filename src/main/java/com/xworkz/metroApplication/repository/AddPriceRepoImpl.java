package com.xworkz.metroApplication.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.metroApplication.entity.AddPriceEntity;

@Repository
public class AddPriceRepoImpl implements AddPriceRepo {
	
	@Autowired
	private EntityManagerFactory emf;

	@Override
	public boolean onAddPrice(AddPriceEntity addPriceEntity) {
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		try {
			et.begin();
			em.persist(addPriceEntity);
			et.commit();
			return true;
			
		} catch (Exception e) {
           System.out.println("getting exception in onAddPrice method in repoimpl class.."+e.getMessage());
           return false;
		}
		finally {
			em.close();
		}
	}

}
