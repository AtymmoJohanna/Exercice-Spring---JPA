package ssii.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ssii.entity.Personne;
import ssii.entity.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
}
