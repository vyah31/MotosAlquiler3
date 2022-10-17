package com.reto.motorbike.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto.motorbike.model.Message;
import com.reto.motorbike.service.MessageService;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageControler {
    
    @Autowired
    private MessageService messageService;
    @GetMapping("/all")
    public List<Message> obtenerMessageCompleta(){
        return messageService.obtenerMessageCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Message> obtenerMessageId(@PathVariable("id")Integer identificador){
        return messageService.obtenerMessageId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message salvarMessage(@RequestBody Message message){
        return messageService.salvarMessage(message);
    }
}
