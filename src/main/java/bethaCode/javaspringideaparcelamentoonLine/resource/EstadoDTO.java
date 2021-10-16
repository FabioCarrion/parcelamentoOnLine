//package bethaCode.javaspringideaparcelamentoonLine.resource;
//
//import bethaCode.javaspringideaparcelamentoonLine.model.Estado;
//
//public class EstadoDTO {
//
//    private Long id;
//    private String nome;
//    private String sigla;
//    private Long IdPaises;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getSigla() {
//        return sigla;
//    }
//
//    public void setSigla(String sigla) {
//        this.sigla = sigla;
//    }
//
//    public Long getIdPaises() {
//        return IdPaises;
//    }
//
//    public void setIdPaises(Long idPaises) {
//        this.IdPaises = idPaises;
//    }
//
//    public static EstadoDTO toDTO (Estado estado){
//        EstadoDTO dto = new EstadoDTO();
//        dto.setId(estado.getId());
//        dto.setNome(estado.getNome());
//        dto.setSigla(estado.getSigla());
//        //getSigladto.setIdPaises(estado.getIdPaises());
//        return dto;
//    }
//
//    public static Estado fromDTO(EstadoDTO dto){
//        Estado entity = new Estado();
//        entity.setId(dto.getId());
//        entity.setNome(dto.getNome());
//        //entity.setIdPaises(dto.getIdPaises());
//        return entity;
//    }
//
//}