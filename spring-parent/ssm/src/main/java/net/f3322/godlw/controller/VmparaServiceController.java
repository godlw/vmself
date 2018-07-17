package net.f3322.godlw.controller;


import net.f3322.godlw.entity.ClientEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping( value = "/vmservice")
public class VmparaServiceController {


    @PostMapping( value = "/setvmpara")
    public String setvmpara(ClientEntity clientEntity){
        if (clientEntity.getCid()!=0){

        }
        return "ok";
    }

    @RequestMapping(value = "/*")
    public ModelAndView vmparaservice(String data) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        SimpleDateFormat simpleDateFormatnew = new SimpleDateFormat("yyyy年mm月dd日  HH:mm:ss");
        modelAndView.addObject("nowdate", simpleDateFormatnew.format(new Date()));
        modelAndView.addObject("youdata",data);
        return modelAndView;
    }

    @PostMapping(value ="goodsname")
    public void goodsname(){

    }
}
