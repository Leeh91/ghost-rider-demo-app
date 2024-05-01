package br.com.demo.controllers.signup;

import br.com.demo.controllers.signup.dtos.SignupRequestDTO;
import br.com.demo.controllers.signup.dtos.SignupResponseDTO;
import br.com.demo.controllers.signup.mappers.SignupMapper;
import br.com.demo.ports.in.SignupUseCase;
import br.com.demo.ports.in.dtos.AccountCriteriaDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    private final SignupUseCase signupUseCase;
    private final SignupMapper signupMapper;

    public SignupController(final SignupUseCase signupUseCase, final SignupMapper signupMapper) {
        this.signupMapper = signupMapper;
        this.signupUseCase = signupUseCase;
    }

    @PostMapping("/signup")
    public SignupResponseDTO signup(@RequestBody SignupRequestDTO request) {
        SignupResponseDTO response = new SignupResponseDTO();

        AccountCriteriaDTO accountCriteriaDTO = signupMapper.toAccountCriteriaDTO(request);
        Long id = signupUseCase.execute(accountCriteriaDTO);
        response.setId(id);

        return response;
    }
}
