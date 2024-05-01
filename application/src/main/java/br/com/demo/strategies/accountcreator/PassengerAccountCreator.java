package br.com.demo.strategies.accountcreator;

import br.com.demo.annotations.Strategy;
import br.com.demo.domains.PassengerAccount;
import br.com.demo.exceptions.IllegalArgumentException;
import br.com.demo.ports.in.dtos.AccountCriteriaDTO;
import br.com.demo.ports.in.dtos.AccountType;
import br.com.demo.ports.out.SavePassengerAccountUseCase;

import static java.util.Objects.isNull;

@Strategy
public class PassengerAccountCreator implements AccountCreatorStrategy {

    private final SavePassengerAccountUseCase savePassengerAccountUseCase;

    public PassengerAccountCreator(final SavePassengerAccountUseCase savePassengerAccountUseCase) {
        this.savePassengerAccountUseCase = savePassengerAccountUseCase;
    }

    @Override
    public Long create(AccountCriteriaDTO accountCriteriaDTO) {
        if(isNull(accountCriteriaDTO)) {
            throw new IllegalArgumentException("Failed saving passenger account, account data is null");
        }

        PassengerAccount passengerAccount = PassengerAccount.getBuilder()
                .id(null)
                .name(accountCriteriaDTO.getName())
                .email(accountCriteriaDTO.getEmail())
                .cpf(accountCriteriaDTO.getCpf())
                .build();

        return savePassengerAccountUseCase.execute(passengerAccount);
    }

    @Override
    public AccountType accountType() {
        return AccountType.PASSENGER;
    }
}
