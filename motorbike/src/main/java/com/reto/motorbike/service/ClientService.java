package com.reto.motorbike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.motorbike.model.Client;
import com.reto.motorbike.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    public ClientRepository clientRepository;

    public List<Client> obtenerClientCompleta(){
        return clientRepository.obtenerClientCompleta();

    }

    public Optional<Client> obtenerClientId(Integer id){
        return clientRepository.obtenerClientId(id);
    }

    public Client salvarClient(Client client){
        if(client.getIdClient()==null){
            return clientRepository.salvarClient(client);
        }
        else{
            Optional <Client> clientAuxiliar = clientRepository.obtenerClientId(client.getIdClient());
            if(clientAuxiliar.isEmpty()){
                return clientRepository.salvarClient(client);
            }
            else{
                return client;
            }
        }

    }


}
