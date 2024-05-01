package br.com.demo.strategies.accountcreator;

import br.com.demo.annotations.Strategy;
import br.com.demo.domains.Car;
import br.com.demo.domains.DriverAccount;
import br.com.demo.exceptions.IllegalArgumentException;
import br.com.demo.ports.in.dtos.AccountCriteriaDTO;
import br.com.demo.ports.in.dtos.AccountType;
import br.com.demo.ports.out.SaveDriverAccountUseCase;

import static java.util.Objects.isNull;

@Strategy
public class DriverAccountCreator implements AccountCreatorStrategy {

    private final SaveDriverAccountUseCase saveDriverAccountUseCase;

    public DriverAccountCreator(final SaveDriverAccountUseCase saveDriverAccountUseCase) {
        this.saveDriverAccountUseCase = saveDriverAccountUseCase;
    }

    @Override
    public Long create(AccountCriteriaDTO accountCriteriaDTO) {
        if(isNull(accountCriteriaDTO)) {
            throw new IllegalArgumentException("Failed saving driver account, account data is null");
        }

        Car car = Car.getBuilder()
                .carPlate(accountCriteriaDTO.getCarPlate())
                .build();

        DriverAccount driverAccount = DriverAccount
                .getBuilder()
                .id(null)
                .name(accountCriteriaDTO.getName())
                .email(accountCriteriaDTO.getEmail())
                .cpf(accountCriteriaDTO.getCpf())
                .car(car)
                .build();

        return saveDriverAccountUseCase.execute(driverAccount);
    }

    @Override
    public AccountType accountType() {
        return AccountType.DRIVER;
    }
}
