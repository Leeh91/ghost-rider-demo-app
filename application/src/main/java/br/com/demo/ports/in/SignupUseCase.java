package br.com.demo.ports.in;

import br.com.demo.ports.in.dtos.AccountCriteriaDTO;

public interface SignupUseCase {
    Long execute(AccountCriteriaDTO accountCriteriaDTO);
}
