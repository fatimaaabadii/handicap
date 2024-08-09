package ma.entraide.handicap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fonctionnaire {
    public Fonctionnaire(Long id, Province province, Association association, String fullName,
			Specialite specialite, double salaireMensuel, String contrat, String cnss, String fraisCnss,
			double montantAnnuel) {
		super();
		this.id = id;
		this.province = province;
		this.association = association;
		this.fullName = fullName;
		this.specialite = specialite;
		this.salaireMensuel = salaireMensuel;
		this.contrat = contrat;
		this.cnss = cnss;
		this.fraisCnss = fraisCnss;
		this.montantAnnuel = montantAnnuel;
	}

	public Fonctionnaire() {
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public double getSalaireMensuel() {
		return salaireMensuel;
	}

	public void setSalaireMensuel(double salaireMensuel) {
		this.salaireMensuel = salaireMensuel;
	}

	public String getContrat() {
		return contrat;
	}

	public void setContrat(String contrat) {
		this.contrat = contrat;
	}

	public String getCnss() {
		return cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
	}

	public String getFraisCnss() {
		return fraisCnss;
	}

	public void setFraisCnss(String fraisCnss) {
		this.fraisCnss = fraisCnss;
	}

	public double getMontantAnnuel() {
		return montantAnnuel;
	}

	public void setMontantAnnuel(double montantAnnuel) {
		this.montantAnnuel = montantAnnuel;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fonctionnaire_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "province_id")
    private Province province;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "association_id")
    private Association association;

    private String fullName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialite_id")
    private Specialite specialite;

    private double salaireMensuel;

    //صيغة التعاقد
    private String contrat;

    //"التصريح بالصندوق الوطني
    // للضمان الاجتماعي CNSS"
    private String cnss;

    private String fraisCnss;

    private double montantAnnuel;


}
