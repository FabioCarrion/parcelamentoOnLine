package bethaCode.javaspringideaparcelamentoonLine.resource;

import bethaCode.javaspringideaparcelamentoonLine.model.Estado;
import bethaCode.javaspringideaparcelamentoonLine.repository.EstadoRepository;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<Estado> getEstado(){
        return repository.findAll();
    }
//    public List<EstadoDTO> getEstado(){
//        return repository.findAll().stream().map(p-> EstadoDTO.toDTO(p)).collect(Collectors.toList());
//    }

    @GetMapping("/{id}")
    public Estado getEstadoId(@PathVariable(value = "id") Long estadoId, @RequestBody Estado estado) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID: " + estadoId));
        return estadoFind;
    }
//    public EstadoDTO getEstadoId(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException {
//
//        Estado estadoFind = repository.findById(estadoId)
//                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID: " + estadoId));
//
//        return EstadoDTO.toDTO(estadoFind);
//    }

    @PostMapping
    public Estado create(@Valid @RequestBody Estado estado){
        return repository.save(estado);
    }
//    public EstadoDTO create(@Valid @RequestBody Estado estado){
//        return EstadoDTO.toDTO(repository.save(estado));
//    }

    @PutMapping("/{id}")
    public Estado update(@PathVariable(value = "id") Long estadoId,
                         @RequestBody Estado estado) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID: " + estadoId));
        estadoFind.setId(estado.getId());
        estadoFind.setNome(estado.getNome());
        estadoFind.setSigla(estado.getSigla());
        estadoFind.setIdPaises(estado.getIdPaises());
        return repository.save(estadoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException{
        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID: " + estadoId));

        repository.delete(estadoFind);
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