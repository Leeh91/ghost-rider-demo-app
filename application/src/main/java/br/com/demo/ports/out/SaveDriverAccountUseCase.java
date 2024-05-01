package br.com.demo.ports.out;

import br.com.demo.domains.DriverAccount;

public interface SaveDriverAccountUseCase {
    Long execute(DriverAccount driverAccount);
}
