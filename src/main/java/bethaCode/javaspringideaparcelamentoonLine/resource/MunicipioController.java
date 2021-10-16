package bethaCode.javaspringideaparcelamentoonLine.resource;

import bethaCode.javaspringideaparcelamentoonLine.model.Estado;
import bethaCode.javaspringideaparcelamentoonLine.model.Municipio;
import bethaCode.javaspringideaparcelamentoonLine.repository.MunicipioRepository;
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
@RequestMapping("/api/municipios")
public class MunicipioController{

    @Autowired
    private MunicipioRepository repository;

    @GetMapping
    public List<Municipio> getMunicipio(){
        return repository.findAll();
    }
//    public List<MunicipioDTO> getMunicipio(){
//        return repository.findAll().stream().map(p-> MunicipioDTO.toDTO(p)).collect(Collectors.toList());
//    }

    @GetMapping("/{id}")
    public Municipio getMunicipioId(@PathVariable(value = "id") Long municipioId, @RequestBody Municipio municipio) throws EntityNotFoundException {
        Municipio municipioFind = repository.findById(municipioId)
                .orElseThrow(() -> new EntityNotFoundException("Município não encontrado com ID: " + municipioId));
        return municipioFind;
    }
//    public MunicipioDTO getMunicipioId(@PathVariable(value = "id") Long municipioId) throws EntityNotFoundException {
//
//        Municipio municipioFind = repository.findById(municipioId)
//                .orElseThrow(() -> new EntityNotFoundException("Município não encontrado com ID: " + municipioId));
//        return MunicipioDTO.toDTO(municipioFind);
//    }


    @PostMapping
    public Municipio create(@Valid @RequestBody Municipio municipio){
        return repository.save(municipio);
    }
//    public MunicipioDTO create(@Valid @RequestBody Municipio municipio){
//        return MunicpioDTO.toDTO(repository.save(municipio));
//    }

    @PutMapping("/{id}")
    public Municipio update(@PathVariable(value = "id") Long municipioId,
                         @RequestBody Municipio municipio) throws EntityNotFoundException{
        Municipio municipioFind = repository.findById(municipioId)
                .orElseThrow(() -> new EntityNotFoundException("Município não encontrado com ID: " + municipioId));
        municipioFind.setId(municipio.getId());
        municipioFind.setNome(municipio.getNome());
        municipioFind.setEstado(municipio.getEstado());
        municipioFind.setCepGeral(municipio.getCepGeral());

        return repository.save(municipioFind);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long municipioId) throws EntityNotFoundException{
        Municipio municipioFind = repository.findById(municipioId)
                .orElseThrow(() -> new EntityNotFoundException("Município não encontrado com ID: " + municipioId));

        repository.delete(municipioFind);
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
