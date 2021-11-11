package com.MediaText.controller;


import com.MediaText.entities.Text;
import com.MediaText.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class TextController {

    private final TextService textService;

    @Autowired
    public TextController(@Qualifier("textServiceIMPL")TextService textService){
        this.textService = textService;
    }

    //This is a GET request that will read a list of all the texts.
    //http://localhost:8080/retrieveAllTexts
    @GetMapping("/retrieveAllTexts")
    public List<Text> findAll() {
        return textService.findAll();
    }
    //This is a GET request to call Text object by ID
    //http://localhost:8080/retrieveText/{textId}
    @GetMapping("/retrieveText/{textId}")
    public Text findText(@PathVariable int textId) {
        return (Text)textService.findById(textId);
    }

    //This is a POST request to add a new text.
    //http://localhost:8080/addText
    @PostMapping("/addText")
    public Text addText(@RequestBody Text theText) {
        //also, just in case they pass an id in JSON .... set id to 0
        //this is to force a save of new item .... instead of update
        theText.setId(0);

        //This will call the textDqoImpl.save method to save a new text
        //through the textService
        textService.saveOrUpdate(theText);
        return theText;
    }

    //This is a PUT request to update an existing text.
    //http://localhost:8080/updateText
    @PutMapping("/updateText")
    public Text updateText(@RequestBody Text updateText) {
        //Notice theText.setId(0); this will execute an update instead of a create
        textService.saveOrUpdate(updateText);
        return updateText;
    }

    //This is a DELETE request to delete an existing text.
    //http://localhost:8080/deleteText/1
    @DeleteMapping("/deleteText/{textId}")
    public String deleteText(@PathVariable int textId) {
        //This will execute the deleteByID.
        textService.deleteById(textId);
        return "Deleted text id : " + textId;
    }


}
