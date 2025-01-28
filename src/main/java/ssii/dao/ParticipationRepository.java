package ssii.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ssii.entity.Participation;

import java.math.BigDecimal;

public interface ParticipationRepository extends JpaRepository<Participation, Integer> {
    @Query("""
        SELECT COUNT(*)
        FROM Participation p
        WHERE p.contributeur.matricule = :matriculeParticipant
    """)
    Integer nbProjetpourX(Integer matriculeParticipant);

    @Query("""
        SELECT SUM(p.pourcentage)
        FROM Participation p
        WHERE p.contributeur.matricule = :matriculeParticipant
    """)
    float tauxParticapationpourX(Integer matriculeParticipant);

}
