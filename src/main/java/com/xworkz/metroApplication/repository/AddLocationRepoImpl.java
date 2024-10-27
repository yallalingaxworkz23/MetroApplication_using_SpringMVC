package com.xworkz.metroApplication.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.metroApplication.entity.AddLocationEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AddLocationRepoImpl implements AddLocationRepo {

	@Autowired
	private EntityManagerFactory emf;
	
	@Override
	public boolean onAddLocation(AddLocationEntity addLocationEntity) {
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		try {
			et.begin();
			em.persist(addLocationEntity);
			et.commit();
			return true;
		} catch (Exception e) {
			log.info("getting expection..from onaddlocation method.."+e.getMessage());
			return false;
		}
		finally {
			em.close();
		}

	}

}
