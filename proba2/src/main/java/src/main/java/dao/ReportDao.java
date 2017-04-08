package src.main.java.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import src.main.java.model.Drzava;
import src.main.java.model.Operater;
import src.main.java.model.Servis;

@Repository
public class ReportDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveDrzava(Drzava drzava){
		Session session=sessionFactory.getCurrentSession();
		session.save(drzava);
	}
	
	@Transactional
	public void saveOperator(Operater operater){
		Session session=sessionFactory.getCurrentSession();
		session.save(operater);
	}
	
	@Transactional
	public void saveServis(Servis servis){
		Session session=sessionFactory.getCurrentSession();
		session.save(servis);
	}

}
