package com.projet.stage.Service;


import com.projet.stage.Entity.Client;
import com.projet.stage.Entity.Freelancer;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client updateprofile(Client client);
    Client ajouterClient (Client client);
    Client modifierClient (Client client);
    List<Client> listerClient();
    void  SupprimerClient (Long id);
    Optional<Client > listeClientById (Long id);

}
