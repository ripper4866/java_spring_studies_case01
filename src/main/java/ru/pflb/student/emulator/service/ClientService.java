package ru.pflb.student.emulator.service;

import org.springframework.stereotype.Service;
import ru.pflb.student.emulator.model.dto.ClientDto;
import ru.pflb.student.emulator.service.interfaces.ClientServiceInterface;

import java.util.Random;

@Service
public class ClientService implements ClientServiceInterface {

    @Override
    public ClientDto getClient(long id) {
        ClientDto client = ClientDto.builder()
                .id(id)
                .firstName(this.createRandomString(6, false))
                .lastName(this.createRandomString(8, false))
                .cardNumber(this.createRandomString(16, true))
                .individualTaxpayerNumber(this.createRandomString(12, true))
                .passPhoto("name")
                .build();
        return client;
    }

    @Override
    public boolean deleteClient(long id) {
        System.out.println("Deleted");
        return true;
    }

    @Override
    public boolean addClient(ClientDto client) {
        System.out.println("Adding new client:" +
                "\nID: " + client.getId() +
                "\nFirst Name: " + client.getFirstName() +
                "\nLast Name: " + client.getLastName() +
                "\nCard Number: " + client.getCardNumber() +
                "\nINN: " + client.getIndividualTaxpayerNumber() +
                "\nActivity Status: " + client.isActive());
        return true;
    }

    @Override
    public ClientDto updateClient(long id, ClientDto client) {
        client.setId(id);
        System.out.println("Updating client:" +
                "\nID: " + client.getId() +
                "\nFirst Name: " + client.getFirstName() +
                "\nLast Name: " + client.getLastName() +
                "\nCard Number: " + client.getCardNumber() +
                "\nINN: " + client.getIndividualTaxpayerNumber() +
                "\nActivity Status: " + client.isActive());
        return client;
    }

    private String createRandomString(int targetStringLength, boolean fromDigits) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        if (fromDigits) {
            leftLimit = 48; // digit '0'
            rightLimit = 57; // digit '9'
        }
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString.substring(0, 1).toUpperCase() + generatedString.substring(1);
    }
}
