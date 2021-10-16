package bethaCode.javaspringideaparcelamentoonLine.resource;

import bethaCode.javaspringideaparcelamentoonLine.model.Bairro;
import bethaCode.javaspringideaparcelamentoonLine.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.persistence.SqlResultSetMapping;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/bairros")
public class BairroController{

    @Autowired
    private BairroRepository repository;

    @GetMapping
    public List<Bairro> getBairro(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Bairro getBairroId(@PathVariable(value = "id") Long bairroId, @RequestBody Bairro bairro) throws EntityNotFoundException {
        Bairro bairroFind = repository.findById(bairroId)
                .orElseThrow(() -> new EntityNotFoundException("Bairro não encontrado com ID: " + bairroId));
        return bairroFind;
    }

    @PostMapping
    public Bairro create(@Valid @RequestBody Bairro bairro){
        return repository.save(bairro);
    }

    @PutMapping("/{id}")
    public Bairro update(@PathVariable(value = "id") Long bairroId,
                           @RequestBody Bairro bairro) throws EntityNotFoundException{
        Bairro bairroFind = repository.findById(bairroId)
                .orElseThrow(() -> new EntityNotFoundException("Bairro não encontrado com ID: " + bairroId));
        bairroFind.setId(bairro.getId());
        bairroFind.setNome(bairro.getNome());
        bairroFind.setDistrito(bairro.getDistrito());

        return repository.save(bairroFind);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long bairroId) throws EntityNotFoundException{
        Bairro bairroFind = repository.findById(bairroId)
                .orElseThrow(() -> new EntityNotFoundException("Bairro não encontrado com ID: " + bairroId));
        repository.delete(bairroFind);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}