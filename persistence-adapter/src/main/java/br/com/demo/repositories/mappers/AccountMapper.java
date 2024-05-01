package br.com.demo.repositories.mappers;

import br.com.demo.domains.DriverAccount;
import br.com.demo.domains.PassengerAccount;
import br.com.demo.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper( AccountMapper.class );

    @Mapping(target = "id", source = "id", qualifiedByName = "unwrap")
    @Mapping(target = "carPlate", source = "car.carPlate")
    Account driverAccountDomainToEntity(DriverAccount driverAccount);

    @Mapping(target = "id", source = "id", qualifiedByName = "unwrap")
    Account passengerAccountDomainToEntity(PassengerAccount passengerAccount);

    @Named("unwrap")
    default <T> T unwrap(Optional<T> optional) {
        return optional.orElse(null);
    }
}
