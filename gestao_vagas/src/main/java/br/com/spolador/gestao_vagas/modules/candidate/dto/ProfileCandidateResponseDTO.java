package br.com.spolador.gestao_vagas.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {
    @Schema(example = "Desenvolvedor Java")
    private String description;
    @Schema(example = "luizh")
    private String username;
    @Schema(example = "luizh@gmail.com")
    private String email;
    private UUID id;
    @Schema(example = "Luiz Henrique")
    private String name;
}
