package br.com.demo.ports.out;

import br.com.demo.domains.PassengerAccount;

public interface SavePassengerAccountUseCase {
    Long execute(PassengerAccount passengerAccount);
}
