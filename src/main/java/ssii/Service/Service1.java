package ssii.Service;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import ssii.dao.ParticipationRepository;
import ssii.dao.PersonneRepository;
import ssii.dao.ProjetRepository;
import ssii.entity.Participation;

public class Service1 {
    private final PersonneRepository personneDao;
    private final ProjetRepository projetDao;
    private final ParticipationRepository participationDao;

    public Service1(PersonneRepository personneDao, ProjetRepository projetDao, ParticipationRepository participationDao) {
        this.personneDao = personneDao;
        this.projetDao = projetDao;
        this.participationDao = participationDao;
    }

    @Transactional
    public Participation ajoutParticipation(@NonNull Integer personneMatricule, @NonNull Integer projetCode, @NonNull String role, @NonNull Float pourcentage) {
        // On vérifie que la personne existe
        var personne = personneDao.findById(personneMatricule).orElseThrow();

        // On vérifie que le projet existe
        var projet = projetDao.findById(projetCode).orElseThrow();


        return null;
    }

}
