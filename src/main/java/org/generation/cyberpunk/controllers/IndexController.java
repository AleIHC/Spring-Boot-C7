package org.generation.cyberpunk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Manejar una vista a través de una plantilla
public class IndexController {

    //Cuando ingrese a esta ruta, se haga una petición de tipo GET y nos trae lo que estemos indicando en el método
    @RequestMapping("/")
    public String vistaHome() {
        return "index";
    }


}
