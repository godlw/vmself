package net.f3322.godlw.controller;


import net.f3322.godlw.entity.ClientEntity;
import net.f3322.godlw.netty.server.ClientServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping( value = "/service")
public class VmparaServiceController {


    @Autowired
    private ClientServer clientServer;

    @GetMapping(value = "/start")
    public void startClientServer(){
        clientServer.start();
    }
    @GetMapping(value = "/sendallow")
    public void sendallow(){

    }
}
