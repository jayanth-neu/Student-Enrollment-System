package com.esd.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.esd.exception.StudentException;
import com.esd.pojo.Student;

@Component
public class StudentDAO extends DAO{
	
	public Student checkStudLogin(String eid, String passwd) {
		// TODO Auto-generated method stub
		Query query = getSession().getNamedQuery("studlgn");
		query.setParameter("eid",eid);
		query.setParameter("passwd",passwd);
		
		return (Student)query.uniqueResult();
	}
	
	public Student checkStud(String eid) {
		// TODO Auto-generated method stub
		Query query = getSession().getNamedQuery("removestud");
		query.setParameter("eid",eid);
		
		return (Student)query.setMaxResults(1).uniqueResult();		
	}
	
	
    public List<Student> list() {
		Query<Student> query = getSession().createQuery("FROM Student");
		List<Student> list = query.list();
		return list;
	}

    public void save(Student student) throws StudentException {
        try {
            begin();
            getSession().save(student);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new StudentException("Create student error" + student.getFirstname() + " " + student.getLastname(), e);
        }
    }
    
    public void delete(Student student) throws StudentException {
        try {
            begin();
            getSession().delete(student);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new StudentException("Delete student error" + student.getFirstname() + " " + student.getLastname(), e);
        }
    }

    public void update(Student student) throws StudentException {
        try {
            begin();
            getSession().update(student);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new StudentException("Update student error" + student.getFirstname() + " " + student.getLastname(), e);
        }
    }


}
