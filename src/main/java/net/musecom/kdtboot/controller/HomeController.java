package net.musecom.kdtboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {

    private final BbsService bbsService;

    @GetMapping("/")
    public String index() {
        List<BbsDto> bbsdto(){
            List<BbsDto> bbsDtoList = bbsService.
        return "index";
        }
    }



@GetMapping("/write")
public String write() {
    return "write";

}

@GetMapping("/write")
public String writeForm(
    @RequestParam("writer") String writer,
    @RequestParam("password") String password,
    @RequestParam("title") String title,
    @RequestParam("contents") String contents
) {
    System.out.println("받은거 writer :" + writer + "password" + password + "title" + title + "contents" + contents);
    return null;
    }
}       
    
