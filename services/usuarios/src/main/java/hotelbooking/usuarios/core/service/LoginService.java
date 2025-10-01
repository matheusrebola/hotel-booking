package hotelbooking.usuarios.core.service;

import hotelbooking.usuarios.core.dto.LoginReq;
import hotelbooking.usuarios.core.model.Login;
import hotelbooking.usuarios.core.repository.LoginRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository repository;

    @Transactional
    public Login salvar(Login login){
        return repository.save(login);
    }

    public Login retornarLogin(String email){
        return encontrarPeloEmail(email);
    }

    public Boolean efetuarLogin(LoginReq req){
        Login usuario = encontrarPeloEmail(req.email());
        return !(usuario == null) && validarSenha(req.senha(), usuario.getSenha());
    }

    private Boolean validarSenha(String info, String salva){
        return salva.equals(info);
    }

    private Login encontrarPeloEmail(String email){
        return repository.findLoginByEmail(email);
    }
}
