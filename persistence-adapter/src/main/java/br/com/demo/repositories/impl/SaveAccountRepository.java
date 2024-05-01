package br.com.demo.repositories.impl;

import br.com.demo.repositories.mappers.AccountMapper;
import br.com.demo.annotations.PersistenceAdapter;
import br.com.demo.daos.AccountDAO;
import br.com.demo.domains.DriverAccount;
import br.com.demo.domains.PassengerAccount;
import br.com.demo.entities.Account;
import br.com.demo.ports.out.SaveDriverAccountUseCase;
import br.com.demo.ports.out.SavePassengerAccountUseCase;

import static java.util.Objects.isNull;

@PersistenceAdapter
public class SaveAccountRepository implements SaveDriverAccountUseCase, SavePassengerAccountUseCase {

    private final AccountMapper accountMapper;
    private final AccountDAO accountDAO;

    public SaveAccountRepository(final AccountMapper accountMapper, final AccountDAO accountDAO){
        this.accountMapper = accountMapper;
        this.accountDAO = accountDAO;
    }

    @Override
    public Long execute(DriverAccount driverAccount) {
        if(isNull(driverAccount)) {
            throw new IllegalArgumentException("Failed on saving driver account, account data is null");
        }
        Account account = accountMapper.driverAccountDomainToEntity(driverAccount);

        account.setDriver(Boolean.TRUE);
        account.setPassenger(Boolean.FALSE);

        Account savedAccount = accountDAO.save(account);

        return savedAccount.getId();
    }

    @Override
    public Long execute(PassengerAccount passengerAccount) {
        if(isNull(passengerAccount)) {
            throw new IllegalArgumentException("Failed on saving passenger account, account data is null");
        }
        Account account = accountMapper.passengerAccountDomainToEntity(passengerAccount);

        account.setDriver(Boolean.TRUE);
        account.setPassenger(Boolean.FALSE);

        Account savedAccount = accountDAO.save(account);

        return savedAccount.getId();
    }
}
