package med.saudemais.api.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoDeErros {

    // Error 404

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErroNotFound404() {
        return ResponseEntity.notFound().build();
    }

    //Error 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErroBinValidation400(MethodArgumentNotValidException exception){
        var erros = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(RecordDadosErroValidacao::new).toList());
    }

    private record RecordDadosErroValidacao(String campo, String mensagem){
        public RecordDadosErroValidacao(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
