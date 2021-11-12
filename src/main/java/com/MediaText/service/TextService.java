package com.MediaText.service;

import com.MediaText.entities.Text;

import java.util.List;

public interface TextService {

    List<Text> findAll();
    Object findById(int theId);
    void saveOrUpdate(Text theText);
    void deleteById(int theId);

    //for word search query
    List<Text> findBy(String keyword);
}
