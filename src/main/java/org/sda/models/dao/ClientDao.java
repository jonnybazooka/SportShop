package org.sda.models.dao;

import org.sda.models.dto.Client;

public interface ClientDao {
    void saveClient(Client client);
    Client getClientByEmail(String email);

}
