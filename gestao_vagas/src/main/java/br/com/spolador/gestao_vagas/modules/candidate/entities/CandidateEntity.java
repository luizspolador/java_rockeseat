package br.com.spolador.gestao_vagas.modules.candidate.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Luiz Spolador", requiredMode = Schema.RequiredMode.REQUIRED
            , description = "Nome do candidato")
    private String name;

    @Pattern(regexp = "\\S+", message = "O campo username não deve conter espaço")
    @NotBlank
    @Schema(example = "luizspolador", requiredMode = Schema.RequiredMode.REQUIRED
            , description = "Username do candidato")
    private String username;

    @Email(message = "Informe um e-mail válido")
    @Schema(example = "luizspolador@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED
            , description = "E-mail do candidato")
    private String email;

    @Length(min = 8, max = 100, message = "A senha deve ter entre 8 e 100 caracteres")
    @Schema(example = "123456$%da", minLength = 8, maxLength = 100, requiredMode = Schema.RequiredMode.REQUIRED
            , description = "Senha do candidato")
    private String password;

    @Schema(example = "Desenvolvedor Java", requiredMode = Schema.RequiredMode.REQUIRED
            , description = "Breve descrição do candidato")
    private String description;

    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
