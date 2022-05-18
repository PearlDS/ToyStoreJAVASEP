package toyPackage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("hi1")
    public String hello1(){
        return "test";
    }

    @GetMapping("hi2")
    public ModelAndView hello2(){
        String sentence = "Hello Mars";
        String sentence2 = "Hello Venus";
        return new ModelAndView("test", "message", sentence);
    }

    @GetMapping("hi3")
    public String hello3(Model model){
        String sentence = "Hello Mars";
        String sentence2 = "Hello Venus";
        model.addAttribute("message", sentence);
        model.addAttribute("message2", sentence2);
        return "test";
    }


}
