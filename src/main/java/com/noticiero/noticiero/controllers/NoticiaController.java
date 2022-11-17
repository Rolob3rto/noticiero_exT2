package com.noticiero.noticiero.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.noticiero.noticiero.model.Noticia;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {
    
    @RequestMapping(path = "/list")
    public ModelAndView list(){

        ModelAndView modelAndView = new ModelAndView("noticias/list");
        modelAndView.addObject("noticias",getNoticias());

        return modelAndView;
    }

    private List<Noticia> getNoticias() {
        
        Noticia n1 = new Noticia(1, "titular1", "descripcion1");
        Noticia n2 = new Noticia(2, "titular2", "descripcion2");
        Noticia n3 = new Noticia(3, "titular3", "descripcion3");
        Noticia n4 = new Noticia(4, "titular4", "descripcion4");

        ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();

        listaNoticias.add(n1);
        listaNoticias.add(n2);
        listaNoticias.add(n3);
        listaNoticias.add(n4);

        return listaNoticias;
    }

    @PostMapping(value="/login")
    public ModelAndView login(Noticia noticia, HttpSession session) {        

        ModelAndView modelAndView = new ModelAndView("noticias/list");

        session.setAttribute("noticia", noticia);

        return modelAndView;
    }

    @GetMapping(value="/logout")
    public ModelAndView logout(HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView("noticias/list");

        //session.setAttribute("usuario", null);
        session.invalidate();

        return modelAndView;
    }
}
