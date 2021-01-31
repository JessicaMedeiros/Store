package io.github.jessicamedeiros.store.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class NewClientDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String name;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Email(message = "Email inválido")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatorio")
    private String cpfORcnpj;

    private Integer type;

    @NotEmpty(message = "Preenchimento obrigatorio")
    private String street;
    @NotEmpty(message = "Preenchimento obrigatorio")
    private String number;

    private String complement;
    private String district;
    private String zipcode;

    @NotEmpty(message = "Preenchimento obrigatorio")
    private String telephone1;

    private String telephone2;
    private String telephone3;

    private Integer cityId;

    public  NewClientDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfORcnpj() {
        return cpfORcnpj;
    }

    public void setCpfORcnpj(String cpfORcnpj) {
        this.cpfORcnpj = cpfORcnpj;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getTelephone3() {
        return telephone3;
    }

    public void setTelephone3(String telephone3) {
        this.telephone3 = telephone3;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
