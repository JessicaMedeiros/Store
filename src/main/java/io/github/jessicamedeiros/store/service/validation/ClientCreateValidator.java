package io.github.jessicamedeiros.store.service.validation;

import io.github.jessicamedeiros.store.dto.NewClientDTO;
import io.github.jessicamedeiros.store.enums.ClientType;
import io.github.jessicamedeiros.store.model.Client;
import io.github.jessicamedeiros.store.repository.ClientRepository;
import io.github.jessicamedeiros.store.service.exceptions.FieldMessage;
import io.github.jessicamedeiros.store.service.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClientCreateValidator implements ConstraintValidator<ClientCreate, NewClientDTO> {

    @Autowired
    public ClientRepository repository;

    @Override
    public void initialize(ClientCreate ann) {
    }

    @Override
    public boolean isValid(NewClientDTO objDto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getType().equals(ClientType.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfORcnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
        }

        if (objDto.getType().equals(ClientType.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfORcnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
        }

            Client aux = repository.findByEmail(objDto.getEmail());
            if (aux != null) {
                list.add(new FieldMessage("email", "Email já existente"));
            }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}