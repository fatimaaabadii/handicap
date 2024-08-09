package ma.entraide.handicap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Beneficiaire {
    public Beneficiaire(Long id, Province province, Association association, Programme programme, String fullName,
			int age, String sexe, TypeHandicap typeHandicap, String degreHandicap, Etablissement etablissement,
			List<ServiceOffert> services) {
		super();
		this.id = id;
		this.province = province;
		this.association = association;
		this.programme = programme;
		this.fullName = fullName;
		this.age = age;
		this.sexe = sexe;
		this.typeHandicap = typeHandicap;
		this.degreHandicap = degreHandicap;
		this.etablissement = etablissement;
		this.services = services;
	}

	public Beneficiaire() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public TypeHandicap getTypeHandicap() {
		return typeHandicap;
	}

	public void setTypeHandicap(TypeHandicap typeHandicap) {
		this.typeHandicap = typeHandicap;
	}

	public String getDegreHandicap() {
		return degreHandicap;
	}

	public void setDegreHandicap(String degreHandicap) {
		this.degreHandicap = degreHandicap;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public List<ServiceOffert> getServices() {
		return services;
	}

	public void setServices(List<ServiceOffert> services) {
		this.services = services;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beneficiaire_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "province_id")
    private Province province;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "association_id")
    private Association association;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "programme_id")
    private Programme programme;

    private String fullName;

    private int age;

    private String sexe;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "handicap_id")
    private TypeHandicap typeHandicap;

    private String degreHandicap;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "etablissement_id")
    private Etablissement etablissement;

   
    
    @OneToMany(cascade = CascadeType.DETACH)
    //@JoinColumn(name = "service_id")
    private List<ServiceOffert> services;




}
