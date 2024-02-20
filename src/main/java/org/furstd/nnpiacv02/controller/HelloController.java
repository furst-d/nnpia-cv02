package org.furstd.nnpiacv02.controller;

import org.springframework.web.bind.annotation.*;

/*
 Rozdíl mezi Controller a RestController je ten, že RestController obsahuje @Controller a @ResponseBody.

 Rozdíl mezi YAML, JSON a XML je ten, že JSON využívá klíče a hodnoty a zapouzdřuje je do složených závorek, což je vhodné pro strojové zpracování.
 Yaml je vhodný pro konfiguraci, protože je čitelný pro člověka a je jednoduchý na psaní. Využívá odsazení a tečkovou notaci.
 XML využívá tagy a atributy, což je vhodné pro hierarchické struktury.
 */
@RestController
public class HelloController {

    @GetMapping("")
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }

    @GetMapping("{name}")
    public String name(@PathVariable String name) {
        return "Name is: " + name;
    }

    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    public String nameOnlyGet(@PathVariable String name) {
        return "Name 2 is: " + name;
    }

    @GetMapping("/query")
    public String queryTest(@RequestParam String name) {
        return "Name 3 is: " + name;
    }
}
