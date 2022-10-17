package com.reto.motorbike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.motorbike.model.Message;
import com.reto.motorbike.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    public MessageRepository messageRepository;

    public List<Message> obtenerMessageCompleta(){
        return messageRepository.obtenerMessageCompleta();

    }

    public Optional<Message> obtenerMessageId(Integer id){
        return messageRepository.obtenerMessageId(id);
    }

    public Message salvarMessage(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.salvarMessage(message);
        }
        else{
            Optional <Message> messageAuxiliar = messageRepository.obtenerMessageId(message.getIdMessage());
            if(messageAuxiliar.isEmpty()){
                return messageRepository.salvarMessage(message);
            }
            else{
                return message;
            }
        }

    }

}
