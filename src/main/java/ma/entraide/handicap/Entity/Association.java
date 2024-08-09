package ma.entraide.handicap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Association {
    public Association(Long id, Province deleguation, String name, Programme programme,
			List<Etablissement> etablissements, String emploiSelonAnnee, String fullName, String telephone,
			String adresse, String email) {
		super();
		this.id = id;
		this.deleguation = deleguation;
		this.name = name;
		this.programme = programme;
		this.etablissements = etablissements;
		this.emploiSelonAnnee = emploiSelonAnnee;
		this.fullName = fullName;
		this.telephone = telephone;
		this.adresse = adresse;
		this.email = email;
	}

	public Association() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Province getDeleguation() {
		return deleguation;
	}

	public void setDeleguation(Province deleguation) {
		this.deleguation = deleguation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public List<Etablissement> getEtablissements() {
		return etablissements;
	}

	public void setEtablissements(List<Etablissement> etablissements) {
		this.etablissements = etablissements;
	}

	public String getEmploiSelonAnnee() {
		return emploiSelonAnnee;
	}

	public void setEmploiSelonAnnee(String emploiSelonAnnee) {
		this.emploiSelonAnnee = emploiSelonAnnee;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "association_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "province_id")
    private Province deleguation;

    private String name;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "programme_id")
    private Programme programme;

    @OneToMany(cascade = CascadeType.DETACH)
   // @JoinColumn(name = "etablissement_id")
    private List<Etablissement> etablissements;

    //اشتغال وفق السنة (الدراسية/ المالية/أخر)
    private String emploiSelonAnnee;

    private String fullName;

    private String telephone;

    private String adresse;

    private String email;
}
