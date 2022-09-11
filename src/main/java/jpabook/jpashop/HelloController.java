package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("data", " hello!!!");

        return "hello";
    }

    public static void main(String[] args) {

        int x = 10;
        
        int y = 200;
        
        int z = add(x,y);

        System.out.println("z = " + z);
        
    }


    private static  int add(int a, int b) {

        int c = a + b;

        return c;
    }

}
