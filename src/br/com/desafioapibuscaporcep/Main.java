package br.com.desafioapibuscaporcep;

import br.com.desafioapibuscaporcep.entities.Address;
import br.com.desafioapibuscaporcep.services.ApiCepService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiCepService service = new ApiCepService();

        System.out.print("Informe o cep para busca: ");
        String cep = scanner.nextLine();

        Address address = service.getAddress(cep);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String addressJson = gson.toJson(address);

        try {
            FileWriter writer = new FileWriter("address.json");
            writer.write(addressJson);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao encontrar o arquivo: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro na escrita do arquivo: " + e.getMessage());
        }
    }
}