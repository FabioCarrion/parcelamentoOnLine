package bethaCode.javaspringideaparcelamentoonLine.resource;

import bethaCode.javaspringideaparcelamentoonLine.model.Bairro;
import bethaCode.javaspringideaparcelamentoonLine.model.Pessoa;
import bethaCode.javaspringideaparcelamentoonLine.repository.BairroRepository;
import bethaCode.javaspringideaparcelamentoonLine.repository.PessoaRepository;
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
@RequestMapping("/api/pessoas")
public class PessoaController{

    @Autowired
    private PessoaRepository repository;

    @GetMapping
    public List<Pessoa> getPessoa(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pessoa getPessoaId(@PathVariable(value = "id") Long pessoaId, @RequestBody Pessoa pessoa) throws EntityNotFoundException {
        Pessoa pessoaFind = repository.findById(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + pessoaId));
        return pessoaFind;
    }

    @PostMapping
    public Pessoa create(@Valid @RequestBody Pessoa pessoa){
        return repository.save(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa update(@PathVariable(value = "id") Long pessoaId,
                         @RequestBody Pessoa pessoa) throws EntityNotFoundException{
        Pessoa pessoaFind = repository.findById(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + pessoaId));
        pessoaFind.setId(pessoa.getId());
        pessoaFind.setTipoPessoa(pessoa.getTipoPessoa());
        pessoaFind.setNome(pessoa.getNome());
        pessoaFind.setLogradouro(pessoa.getLogradouro());
        pessoaFind.setBairro(pessoa.getBairro());
        pessoaFind.setLoteamento(pessoa.getLoteamento());
        pessoaFind.setDistrito(pessoa.getDistrito());
        pessoaFind.setCep(pessoa.getCep());
        pessoaFind.setBloco(pessoa.getBloco());
        pessoaFind.setApto(pessoa.getApto());
        pessoaFind.setComplemento(pessoa.getComplemento());
        pessoaFind.setNumero(pessoa.getNumero());

        return repository.save(pessoaFind);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long pessoaId) throws EntityNotFoundException{
        Pessoa pessoaFind = repository.findById(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + pessoaId));
        repository.delete(pessoaFind);
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