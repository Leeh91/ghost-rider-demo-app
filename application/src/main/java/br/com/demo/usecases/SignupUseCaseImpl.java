package br.com.demo.usecases;

import br.com.demo.annotations.UseCase;
import br.com.demo.ports.in.SignupUseCase;
import br.com.demo.ports.in.dtos.AccountCriteriaDTO;
import br.com.demo.strategies.accountcreator.GetAccountCreatorStrategy;

@UseCase
public class SignupUseCaseImpl implements SignupUseCase {

    private final GetAccountCreatorStrategy getAccountCreatorStrategy;

    public SignupUseCaseImpl(final GetAccountCreatorStrategy getAccountCreatorStrategy) {
        this.getAccountCreatorStrategy = getAccountCreatorStrategy;
    }

    @Override
    public Long execute(AccountCriteriaDTO accountCriteriaDTO) {
        return getAccountCreatorStrategy
                .getStrategy(accountCriteriaDTO.getAccountType())
                .create(accountCriteriaDTO);
    }
}
