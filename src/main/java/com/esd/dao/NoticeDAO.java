package com.esd.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.esd.exception.StudentException;
import com.esd.pojo.Notice;

@Component
public class NoticeDAO extends DAO{
	
	public Notice checkNotice(long nid) {
		// TODO Auto-generated method stub
		Query query = getSession().getNamedQuery("removenotice");
		query.setParameter("nid",nid);
		
		return (Notice)query.uniqueResult();		
	}
	
    public List<Notice> list() {
		Query<Notice> query = getSession().createQuery("FROM Notice");
		List<Notice> list = query.list();
		return list;
	}
	
    public void save(Notice notice) throws StudentException {
        try {
            begin();
            getSession().save(notice);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new StudentException("Create Notice error", e);
        }
    }
    
    public void delete(Notice notice) throws StudentException {
        try {
            begin();
            getSession().delete(notice);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new StudentException("Delete Notice error", e);
        }
    }
}
