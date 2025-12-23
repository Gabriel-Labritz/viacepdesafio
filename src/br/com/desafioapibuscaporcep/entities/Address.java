package br.com.desafioapibuscaporcep.entities;

import br.com.desafioapibuscaporcep.dtos.ViaCepAddress;

public class Address {
    private String cep;
    private String street;
    private String neighborhood;
    private String city;
    private String uf;

    public Address (ViaCepAddress viaCepAddress) {
        this.cep = viaCepAddress.cep();
        this.street = viaCepAddress.logradouro();
        this.neighborhood = viaCepAddress.bairro();
        this.city = viaCepAddress.localidade();
        this.uf = viaCepAddress.uf();
    }

    public String getCep() {
        return cep;
    }

    public String getStreet() {
        return street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return "Cep: " + this.getCep()
                + " Rua: " + this.getStreet()
                + " Bairro: " + this.getNeighborhood()
                + " Cidade: " + this.getCity()
                + " UF: " + this.getUf();
    }
}
