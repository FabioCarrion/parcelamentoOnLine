package bethaCode.javaspringideaparcelamentoonLine.resource;

import bethaCode.javaspringideaparcelamentoonLine.model.Distrito;
import bethaCode.javaspringideaparcelamentoonLine.repository.DistritoRepository;
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
@RequestMapping("/api/distritos")
public class DistritoController{

    @Autowired
    private DistritoRepository repository;

    @GetMapping
    public List<Distrito> getDistrito(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Distrito getDistritoId(@PathVariable(value = "id") Long distritoId, @RequestBody Distrito distrito) throws EntityNotFoundException {
        Distrito distritoFind = repository.findById(distritoId)
                .orElseThrow(() -> new EntityNotFoundException("Distrito não encontrado com ID: " + distritoId));
        return distritoFind;
    }


    @PostMapping
    public Distrito create(@Valid @RequestBody Distrito distrito){
        return repository.save(distrito);
    }

    @PutMapping("/{id}")
    public Distrito update(@PathVariable(value = "id") Long distritoId,
                            @RequestBody Distrito distrito) throws EntityNotFoundException{
        Distrito distritoFind = repository.findById(distritoId)
                .orElseThrow(() -> new EntityNotFoundException("Distrito não encontrado com ID: " + distritoId));
        distritoFind.setId(distrito.getId());
        distritoFind.setNome(distrito.getNome());
        distritoFind.setMunicipio(distrito.getMunicipio());

        return repository.save(distritoFind);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long distritoId) throws EntityNotFoundException{
        Distrito distritoFind = repository.findById(distritoId)
                .orElseThrow(() -> new EntityNotFoundException("Distrito não encontrado com ID: " + distritoId));
        repository.delete(distritoFind);
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