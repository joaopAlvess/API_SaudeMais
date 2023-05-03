package med.saudemais.api.controller;

import jakarta.validation.Valid;
import med.saudemais.api.domain.users.RecordDadosAutentica;
import med.saudemais.api.domain.users.Usuario;
import med.saudemais.api.infra.security.RecordDadosToken;
import med.saudemais.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity efetuarLogin(@RequestBody @Valid RecordDadosAutentica dados) {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            var authentication = manager.authenticate(authenticationToken);

            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new RecordDadosToken(tokenJWT));
    }
}
