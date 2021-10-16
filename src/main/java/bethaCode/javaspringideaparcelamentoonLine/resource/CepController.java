package bethaCode.javaspringideaparcelamentoonLine.resource;

import bethaCode.javaspringideaparcelamentoonLine.model.Cep;
import bethaCode.javaspringideaparcelamentoonLine.repository.BairroRepository;
import bethaCode.javaspringideaparcelamentoonLine.repository.CepRepository;
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
@RequestMapping("/api/ceps")
public class CepController{

    @Autowired
    private CepRepository repository;

    @GetMapping
    public List<Cep> getCep(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Cep getCepId(@PathVariable(value = "id") Long cepId, @RequestBody Cep cep) throws EntityNotFoundException {
        Cep cepFind = repository.findById(cepId)
                .orElseThrow(() -> new EntityNotFoundException("Cep não encontrado com ID: " + cepId));
        return cepFind;
    }

    @PostMapping
    public Cep create(@Valid @RequestBody Cep cep){
        return repository.save(cep);
    }

    @PutMapping("/{id}")
    public Cep update(@PathVariable(value = "id") Long cepId,
                         @RequestBody Cep cep) throws EntityNotFoundException{
        Cep cepFind = repository.findById(cepId)
                .orElseThrow(() -> new EntityNotFoundException("Bairro não encontrado com ID: " + cepId));
        cepFind.setId(cep.getId());
        cepFind.setLogradouro(cep.getLogradouro());
        cepFind.setCep(cep.getCep());
        cepFind.setNumInicial(cep.getNumInicial());
        cepFind.setNumFinal(cep.getNumFinal());

        return repository.save(cepFind);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long cepId) throws EntityNotFoundException{
        Cep cepFind = repository.findById(cepId)
                .orElseThrow(() -> new EntityNotFoundException("Cep não encontrado com ID: " + cepId));
        repository.delete(cepFind);
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