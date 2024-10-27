package com.xworkz.metroApplication.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.metroApplication.entity.AddTrainEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AddTrainRepoImpl implements AddTrianRepo{
	
	@Autowired
	private EntityManagerFactory emf;

	@Override
	public boolean onAddTrianInRepo(AddTrainEntity addTrainEntity) {
		
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		try {
			et.begin();
			em.persist(addTrainEntity);
			et.commit();
			return true;
		} catch (Exception e) {
           log.info("getting exception in onAddTrainRepo method...."+e.getMessage());
           return false;
		}
		finally {
			em.close();
		}
	}

}
