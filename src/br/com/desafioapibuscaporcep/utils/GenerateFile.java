package br.com.desafioapibuscaporcep.utils;

import br.com.desafioapibuscaporcep.entities.Address;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateFile {
    public void jsonSave(Address address) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String addressJson = gson.toJson(address);

        try {
            FileWriter writer = new FileWriter(address.getCep().concat(".json"));
            writer.write(addressJson);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao encontrar o arquivo: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro na escrita do arquivo: " + e.getMessage());
        }
    }
}
