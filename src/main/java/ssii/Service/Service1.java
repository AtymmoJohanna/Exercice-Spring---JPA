package ssii.Service;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import ssii.dao.ParticipationRepository;
import ssii.dao.PersonneRepository;
import ssii.dao.ProjetRepository;
import ssii.entity.Participation;
import ssii.entity.Projet;

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

        var nbProjet = personne.getParticipations().size();
        var tauxParticipation = participationDao.tauxParticapationpourX(personneMatricule);

        int i=0;
        for(Participation p: personne.getParticipations()){
            if (p.getAffectation().getCode().equals( projetCode)){
                i=1;
                break;
            }
        }

        if (i!=0 || 3<=nbProjet || 100<(pourcentage+tauxParticipation)) {
            throw new IllegalStateException ();
        }

        var participation = new Participation(personne, projet, role, pourcentage);
        participationDao.save(participation);
        return participation;
    }

}
