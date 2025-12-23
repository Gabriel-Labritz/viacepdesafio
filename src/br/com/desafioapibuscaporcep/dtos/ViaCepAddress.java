package br.com.desafioapibuscaporcep.dtos;

public record ViaCepAddress
        (String cep,
         String logradouro,
         String bairro,
         String localidade,
         String uf
        ) {
}
