package br.pro.adalto.appcomprasweb_2020_2;

public class Produto {

    public String id;
    public String nome;
    public double quantidade;

    @Override
    public String toString() {
        return nome + " - " + quantidade;
    }
}
