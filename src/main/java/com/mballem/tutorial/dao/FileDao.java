package com.mballem.tutorial.dao;

import com.mballem.tutorial.entity.FileEntity;
import com.mballem.tutorial.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Marcio Ballem on 16/04/2014.
 */
public class FileDao implements IFileDao<FileEntity> {

    public void save(FileEntity entity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<FileEntity> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        List<FileEntity> entities =
                session.createCriteria(FileEntity.class).list();

        session.getTransaction().commit();
        return entities;
    }

    @Override
    public FileEntity find(String year, String month, String name) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        FileEntity entity = (FileEntity) session.createCriteria(FileEntity.class)
                .add(Restrictions.eq("year", year))
                .add(Restrictions.eq("month", month))
                .add(Restrictions.eq("name", name))
                .uniqueResult();

        session.getTransaction().commit();
        return entity;
    }
}
