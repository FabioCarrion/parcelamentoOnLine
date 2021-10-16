package bethaCode.javaspringideaparcelamentoonLine.resource;

import bethaCode.javaspringideaparcelamentoonLine.model.Loteamento;
import bethaCode.javaspringideaparcelamentoonLine.repository.LoteamentoRepository;
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
@RequestMapping("/api/loteamentos")
public class LoteamentoController{

    @Autowired
    private LoteamentoRepository repository;

    @GetMapping
    public List<Loteamento> getLoteamento(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Loteamento getLoteamentoId(@PathVariable(value = "id") Long loteamentoId, @RequestBody Loteamento loteamento) throws EntityNotFoundException {
        Loteamento loteamentoFind = repository.findById(loteamentoId)
                .orElseThrow(() -> new EntityNotFoundException("Loteamento não encontrado com ID: " + loteamentoId));
        return loteamentoFind;
    }

    @PostMapping
    public Loteamento create(@Valid @RequestBody Loteamento loteamento){
        return repository.save(loteamento);
    }

    @PutMapping("/{id}")
    public Loteamento update(@PathVariable(value = "id")Long loteamentoId,
                         @RequestBody Loteamento loteamento) throws EntityNotFoundException{
        Loteamento loteamentoFind = repository.findById(loteamentoId)
                .orElseThrow(() -> new EntityNotFoundException("Loteamento não encontrado com ID: " + loteamentoId));
        loteamentoFind.setId(loteamento.getId());
        loteamentoFind.setNome(loteamento.getNome());
        loteamentoFind.setBairro(loteamento.getBairro());
        loteamentoFind.setAreaComum(loteamento.getAreaComum());
        loteamentoFind.setAreaTotal(loteamento.getAreaTotal());
        loteamentoFind.setAreaRemanescente(loteamento.getAreaRemanescente());

        return repository.save(loteamentoFind);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long loteamentoId) throws EntityNotFoundException{
        Loteamento loteamentoFind = repository.findById(loteamentoId)
                .orElseThrow(() -> new EntityNotFoundException("Loteamento não encontrado com ID: " + loteamentoId));
        repository.delete(loteamentoFind);
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