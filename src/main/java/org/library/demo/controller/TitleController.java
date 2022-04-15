package org.library.demo.controller;

import org.library.demo.models.Book;
import org.library.demo.models.Magazine;
import org.library.demo.models.Title;
import org.library.demo.modelsDemo.PriceModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/title")
public class TitleController {

    List<Title> titles = new ArrayList<>();

    public void buildTitles(){
        for(int i=0; i<50 ; i++){
            if(i%2 == 0){
                titles.add(new Book("Book"+i));
            } else {
                titles.add(new Magazine("Magazine"+i));
            }
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")   /** per inserire l'id con @PathVariable */
    public Title getTitle(@PathVariable String id) {

        buildTitles();

        return titles.get(Integer.parseInt(id));
    }


}
