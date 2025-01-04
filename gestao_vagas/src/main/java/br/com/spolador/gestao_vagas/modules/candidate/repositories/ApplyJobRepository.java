package br.com.spolador.gestao_vagas.modules.candidate.repositories;

import br.com.spolador.gestao_vagas.modules.candidate.entities.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
}
