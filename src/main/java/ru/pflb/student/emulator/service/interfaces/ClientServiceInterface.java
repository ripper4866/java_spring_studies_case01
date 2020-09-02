package ru.pflb.student.emulator.service.interfaces;

import ru.pflb.student.emulator.model.dto.ClientDto;

public interface ClientServiceInterface {
    ClientDto getClient(long id);
    ClientDto updateClient(long id, ClientDto client);
    boolean addClient(ClientDto client);
    boolean deleteClient(long id);
}
