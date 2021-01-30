package io.github.jessicamedeiros.store.enums;

public enum PaymentStatus {


    PENDENTE(1,"PENDENTE"),
    QUITADO(2,"QUITADO"),
    CANCELADO(3,"CANCELADO");

    private int cod;
    private String description;

    private PaymentStatus(int cod, String description){
        this.cod = cod;
        this.description = description;
    }

    public int getCod(){
        return cod;
    }

    public String getDescription(){
        return description;
    }

    public static PaymentStatus toEnum(Integer cod){
        if(cod == null){
            return null;}

        for(PaymentStatus x: PaymentStatus.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido: " + cod);
    }
}
