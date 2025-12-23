package br.com.desafioapibuscaporcep.services;

import br.com.desafioapibuscaporcep.dtos.ViaCepAddress;
import br.com.desafioapibuscaporcep.entities.Address;
import br.com.desafioapibuscaporcep.exceptions.CepFormatException;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiCepService {
    private Address address;

    public Address getAddress(String cep) {
        String searchCep = cep.replace(" ", "").trim();
        String baseUrl = "https://viacep.com.br/ws/".concat(searchCep).concat("/json");

        try {
            if (searchCep.length() > 8) {
                throw new CepFormatException("O formato do cep fornecido é inválido");
            }

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl))
                    .build();
            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
            String json = res.body();

            Gson gson = new Gson();
            ViaCepAddress viaCepAddress = gson.fromJson(json, ViaCepAddress.class);

            this.address = new Address(viaCepAddress);
        } catch (CepFormatException e) {
            System.out.println(e.getMessage());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

        return this.address;
    }
}
