package ssii.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) // la clé est auto-générée par la BD, On ne veut pas de "setter"
    private Integer matricule;

    @NonNull
    @Column(unique=true, length = 255)
    @Size(min = 1, max = 255)
    private String nom;

    @NonNull
    @Column(unique=false, length = 255)
    @Size(min = 1, max = 255)
    private String prenom;

    @NonNull
    @Column(unique=false, length = 255)
    @Size(min = 1, max = 255)
    private String poste;

    @ToString.Exclude
    @OneToMany(mappedBy = "contributeur")
    private List<Participation> participations = new LinkedList<>();

    @OneToMany(mappedBy = "superieur")
    @ToString.Exclude
    private List<Personne> subordonnees = new LinkedList<>();

    @ManyToOne(optional = true)
    private Personne superieur ;


}
