package net.Xforce.LibraryManagment.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("home")
    public String home(){
        return "Home";
    }
    @GetMapping("elvis")
    public String Elvis(Model model){
        model.addAttribute("isAdmin",true);
        model.addAttribute("gender","M");
        return "Elvis";
    }
    @GetMapping("each")
    public String Each(Model model){

        List<String> stringList=List.of("First","Second","Third","Forth");
        model.addAttribute("list",stringList);
        return "Each";
    }

}
