package com.MediaText.dao;

import com.MediaText.entities.Text;

import java.util.List;

public interface TextDAO {

    List<Text> findAll();
    Object findById(int theId);
    void saveOrUpdate(Text theText);
    void deleteById(int theId);

}
