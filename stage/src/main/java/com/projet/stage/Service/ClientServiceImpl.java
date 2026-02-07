package com.projet.stage.Service;


import com.projet.stage.Entity.Client;

import com.projet.stage.Repositary.ClientRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientServiceImpl implements ClientService {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    ClientRepositiry clientRepositiry;
    @Override
    public Client ajouterClient(Client client) {
        return clientRepositiry.save(client);
    }


    @Override
    public Client modifierClient(Client client) {
        return clientRepositiry.save(client);
    }

    @Override
    public List<Client> listerClient() {
        return clientRepositiry.findAll();
    }

    @Override
    public void SupprimerClient(Long id) {
        clientRepositiry.deleteById(id);
    }

    @Override
    public Optional<Client> listeClientById(Long id) {
        return clientRepositiry.findById(id);
    }
    @Override
    public Client updateprofile(Client client) {
        Optional<Client> optionalClient = clientRepositiry.findById(client.getId());
        if (optionalClient.isPresent()) {
            Client client1 =optionalClient.get();
            client1.setNom(client.getNom());
            client1.setPrenom(client.getPrenom());
            client1.setEmail(client.getEmail());
            client1.setMdp(this.bCryptPasswordEncoder.encode(client.getMdp()));

            client1.setTlf(client.getTlf());





            return clientRepositiry.save(client);
        } else {
            throw new RuntimeException("employer not found");
        }
    }

}
