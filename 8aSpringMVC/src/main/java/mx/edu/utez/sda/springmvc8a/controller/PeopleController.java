package mx.edu.utez.sda.springmvc8a.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeopleController {
    @GetMapping("/people/index")
    @Secured({"ROLE_adulto","ROLE_children"})
    public  String index(){
        return "people_index";
    }

    @GetMapping("/animadas")
    @Secured({"ROLE_adulto","ROLE_children"})
    public  String animadas(){
        return "animadas";
    }

    @GetMapping("/accion")
    @Secured("ROLE_adulto")
    public  String accion(){

        return "accion";
    }

    @GetMapping("/anime")
    @Secured({"ROLE_adulto","ROLE_children"})
    public  String anime(){
        System.out.println("Entro al index person");
        return "anime";
    }

    @GetMapping("/romance")
    @Secured("ROLE_adulto")
    public  String romance(){
        System.out.println("Entro al index person");
        return "romance";
    }

    @GetMapping("/suspenso")
    @Secured({"ROLE_adulto"})
    public  String suspenso(){
        System.out.println("Entro al index person");
        return "suspenso";
    }
}
