package med.saudemais.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     // Definindo a anotação usada para API's REST, prestar atenção para não colocar somente (Controller)
@RequestMapping("/hello")   // Para saber qual o mapeamento, qual o controller que a URL passada irá responder.
public class HelloController {

        @GetMapping     //Para chamar esse método, caso a requisição do tipo http for do tipo (GET) chame essa função.
        public String olaMundo() {
            return "Hello Word Spring";
    }
}
