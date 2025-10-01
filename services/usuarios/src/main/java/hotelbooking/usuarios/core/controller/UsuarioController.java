package hotelbooking.usuarios.core.controller;

import hotelbooking.usuarios.core.dto.CadastroReq;
import hotelbooking.usuarios.core.dto.LoginReq;
import hotelbooking.usuarios.core.dto.LoginRes;
import hotelbooking.usuarios.core.mapper.LoginMapper;
import hotelbooking.usuarios.core.mapper.UsuarioMapper;
import hotelbooking.usuarios.core.service.LoginService;
import hotelbooking.usuarios.core.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuarios")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioMapper usuarioMapper;
    private final UsuarioService usuarioService;
    private final LoginMapper loginMapper;
    private final LoginService loginService;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody CadastroReq req){
        usuarioService.salvar(usuarioMapper.mapear(req));
        loginService.salvar(loginMapper.mapear(req));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/autenticacao")
    public ResponseEntity<LoginRes> login(@RequestBody LoginReq req){
        if (loginService.efetuarLogin(req).equals(false)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(loginMapper.mapear(loginService.retornarLogin(req.email())), HttpStatus.OK);
    }
}
