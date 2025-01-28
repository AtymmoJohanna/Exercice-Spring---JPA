package ssii.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString

public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) // la clé est auto-générée par la BD, On ne veut pas de "setter"
    private Integer code;

    @NonNull
    @Column(unique=true, length = 255)
    @Size(min = 1, max = 255)
    private String nom;

    @Basic(optional = false)
    @Column(nullable = false)
    @ToString.Exclude
    // Initialisée avec la date de création
    private LocalDate debut = LocalDate.now();


    @Basic(optional = true)
    @ToString.Exclude
    private LocalDate fin = null;

    @ToString.Exclude
    @OneToMany(mappedBy = "affectation", cascade = CascadeType.ALL)
    private List<Participation> participationsauProjet = new LinkedList<>();

}
