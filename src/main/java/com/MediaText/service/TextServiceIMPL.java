package com.MediaText.service;


import com.MediaText.dao.TextDAO;
import com.MediaText.service.TextService;
import com.MediaText.entities.Text;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TextServiceIMPL implements TextService{

    private final TextDAO textDAO;

    @Autowired
    public TextServiceIMPL(TextDAO textDAO) {
        this.textDAO = textDAO;
    }

    @Override
    public List<Text> findAll() {
        return textDAO.findAll();
    }

    @Override
    public Object findById(int textId) {
        return textDAO.findById(textId);
    }

    @Override
    public void saveOrUpdate(Text theText) {
        textDAO.saveOrUpdate(theText);
    }

    @Override
    public void deleteById(int textId) {
        textDAO.deleteById(textId);
    }

}
