package br.com.desafioapibuscaporcep;

import br.com.desafioapibuscaporcep.entities.Address;
import br.com.desafioapibuscaporcep.services.ApiCepService;
import br.com.desafioapibuscaporcep.utils.GenerateFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiCepService service = new ApiCepService();
        GenerateFile file = new GenerateFile();

        System.out.print("Informe o cep para busca: ");
        String cep = scanner.nextLine();

        Address address = service.getAddress(cep);
        file.jsonSave(address);
    }
}