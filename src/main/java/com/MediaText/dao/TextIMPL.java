package com.MediaText.dao;

import com.MediaText.entities.Text;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class TextIMPL implements TextDAO   {

    private final EntityManager entityManager;

    @Autowired
    public TextIMPL(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<Text> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Text> myQuery = currentSession.createQuery("from Text");
        return myQuery.getResultList();
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public Text findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Text.class, theId);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void saveOrUpdate(Text theText) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theText);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Text myText = currentSession.get(Text.class, theId);
        currentSession.delete(myText);
    }


    //Add query for word search
    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<Text> findBy(String keyWord){
        Session currentSession = entityManager.unwrap(Session.class);
        //Query<Text> myQuery = currentSession.createQuery("SELECT t FROM Text t WHERE CONCAT(t.content, ' ', t.artist, ' ', t.category, ' ', t.source) LIKE %?1%");
        //Query<Text> myQuery = currentSession.createQuery("SELECT t FROM Text t WHERE CONCAT(t.content, ' ', t.artist, ' ', t.category, ' ', t.source) like :kw");
        Query<Text> myQuery = currentSession.createQuery("from Text where content = :kw");
        myQuery.setParameter("kw", keyWord);
        return myQuery.getResultList();
    }
}

