package bethaCode.javaspringideaparcelamentoonLine.resource;

import bethaCode.javaspringideaparcelamentoonLine.model.Logradouro;
import bethaCode.javaspringideaparcelamentoonLine.repository.BairroRepository;
import bethaCode.javaspringideaparcelamentoonLine.repository.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/logradouros")
public class LogradouroController {

    @Autowired
    private LogradouroRepository repository;

    @GetMapping
    public List<Logradouro> getLogradouro() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Logradouro getLogradouroId(@PathVariable(value = "id") Long logradouroId, @RequestBody Logradouro logradouro) throws EntityNotFoundException {
        Logradouro logradouroFind = repository.findById(logradouroId)
                .orElseThrow(() -> new EntityNotFoundException("Logradouro não encontrado com ID: " + logradouroId));
        return logradouroFind;
    }

    @PostMapping
    public Logradouro create(@Valid @RequestBody Logradouro logradouro) {
        return repository.save(logradouro);
    }

    @PutMapping("/{id}")
    public Logradouro update(@PathVariable(value = "id") Long logradouroId,
                             @RequestBody Logradouro logradouro) throws EntityNotFoundException {
        Logradouro logradouroFind = repository.findById(logradouroId)
                .orElseThrow(() -> new EntityNotFoundException("Logradouro não encontrado com ID: " + logradouroId));
        logradouroFind.setId(logradouro.getId());
        logradouroFind.setNome(logradouro.getNome());
        logradouroFind.setBairro(logradouro.getBairro());

        return repository.save(logradouroFind);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long logradouroId) throws EntityNotFoundException {
        Logradouro logradouroFind = repository.findById(logradouroId)
                .orElseThrow(() -> new EntityNotFoundException("Logradouro não encontrado com ID: " + logradouroId));
        repository.delete(logradouroFind);
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