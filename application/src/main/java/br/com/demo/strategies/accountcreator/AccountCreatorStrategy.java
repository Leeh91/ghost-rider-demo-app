package br.com.demo.strategies.accountcreator;

import br.com.demo.ports.in.dtos.AccountCriteriaDTO;
import br.com.demo.ports.in.dtos.AccountType;

public interface AccountCreatorStrategy {
    Long create(AccountCriteriaDTO accountCriteriaDTO);
    AccountType accountType();
}
