package br.com.demo.strategies.accountcreator;

import br.com.demo.annotations.Internal;
import br.com.demo.ports.in.dtos.AccountType;

import java.util.EnumMap;

@Internal
public class GetAccountCreatorStrategy {

    private final EnumMap<AccountType, AccountCreatorStrategy> accountStrategyMap = new EnumMap<>(AccountType.class);

    public GetAccountCreatorStrategy(final PassengerAccountCreator passengerAccountCreator,
                                     final DriverAccountCreator driverAccountCreator) {
        accountStrategyMap.put(AccountType.PASSENGER, passengerAccountCreator);
        accountStrategyMap.put(AccountType.DRIVER, driverAccountCreator);
    }

    public AccountCreatorStrategy getStrategy(final AccountType accountType) {
        return accountStrategyMap.get(accountType);
    }
}
