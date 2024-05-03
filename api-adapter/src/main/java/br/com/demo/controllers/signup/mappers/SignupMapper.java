package br.com.demo.controllers.signup.mappers;

import br.com.demo.controllers.signup.dtos.SignupRequestDTO;
import br.com.demo.ports.in.dtos.AccountCriteriaDTO;
import br.com.demo.ports.in.dtos.AccountType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring")
public interface SignupMapper {

    @Mapping(target = "accountType", source = "driver", qualifiedByName = "toEnum")
    AccountCriteriaDTO toAccountCriteriaDTO(SignupRequestDTO request);

    @Named("toEnum")
    default AccountType toEnum(boolean isDriver) {
        return isDriver ? AccountType.DRIVER : AccountType.PASSENGER;
    }
}
