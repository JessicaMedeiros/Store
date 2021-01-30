package io.github.jessicamedeiros.store.enums;

public enum ClientType {

    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIDICA(2, "Pessoa Juridica");

    private int cod;
    private String description;

    private ClientType(int cod, String description){
        this.cod = cod;
        this.description = description;
    }

    public int getCod(){
        return cod;
    }

    public String getDescription(){
        return description;
    }

    public static ClientType toEnum(Integer cod){
        if(cod == null){
            return null;}

        for(ClientType x: ClientType.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido: " + cod);
    }
}
