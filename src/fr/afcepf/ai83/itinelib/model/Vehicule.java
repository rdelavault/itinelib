package fr.afcepf.ai83.itinelib.model;

// Generated 29 juin 2012 16:59:41 by Hibernate Tools 3.4.0.Beta1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vehicule generated by hbm2java
 */
@Entity
@Table(name = "vehicule", catalog = "itinelib")
public class Vehicule implements java.io.Serializable {

	private Integer idvehicule;
	private Categorievehicule categorievehicule;
	private Set<Registre> registres = new HashSet<Registre>(0);

	public Vehicule() {
	}

	public Vehicule(Categorievehicule categorievehicule) {
		this.categorievehicule = categorievehicule;
	}

	public Vehicule(Categorievehicule categorievehicule, Set<Registre> registres) {
		this.categorievehicule = categorievehicule;
		this.registres = registres;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "IDVEHICULE", unique = true, nullable = false)
	public Integer getIdvehicule() {
		return this.idvehicule;
	}

	public void setIdvehicule(Integer idvehicule) {
		this.idvehicule = idvehicule;
	}

	@ManyToOne()
	@JoinColumn(name = "IDCATEGORIEVEHICULE", nullable = false)
	public Categorievehicule getCategorievehicule() {
		return this.categorievehicule;
	}

	public void setCategorievehicule(Categorievehicule categorievehicule) {
		this.categorievehicule = categorievehicule;
	}

	@OneToMany(mappedBy = "vehicule")
	public Set<Registre> getRegistres() {
		return this.registres;
	}

	public void setRegistres(Set<Registre> registres) {
		this.registres = registres;
	}

}