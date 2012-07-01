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
 * Emplacement generated by hbm2java
 */
@Entity
@Table(name = "emplacement", catalog = "itinelib")
public class Emplacement implements java.io.Serializable {

	private Integer idemplacement;
	private Categorievehicule categorievehicule;
	private Pointlocation pointlocation;
	private Set<Registre> registres = new HashSet<Registre>(0);

	public Emplacement() {
	}

	public Emplacement(Categorievehicule categorievehicule,
			Pointlocation pointlocation) {
		this.categorievehicule = categorievehicule;
		this.pointlocation = pointlocation;
	}

	public Emplacement(Categorievehicule categorievehicule,
			Pointlocation pointlocation, Set<Registre> registres) {
		this.categorievehicule = categorievehicule;
		this.pointlocation = pointlocation;
		this.registres = registres;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "IDEMPLACEMENT", unique = true, nullable = false)
	public Integer getIdemplacement() {
		return this.idemplacement;
	}

	public void setIdemplacement(Integer idemplacement) {
		this.idemplacement = idemplacement;
	}

	@ManyToOne()
	@JoinColumn(name = "IDCATEGORIEVEHICULE", nullable = false)
	public Categorievehicule getCategorievehicule() {
		return this.categorievehicule;
	}

	public void setCategorievehicule(Categorievehicule categorievehicule) {
		this.categorievehicule = categorievehicule;
	}

	@ManyToOne()
	@JoinColumn(name = "IDPOINTLOCATION", nullable = false)
	public Pointlocation getPointlocation() {
		return this.pointlocation;
	}

	public void setPointlocation(Pointlocation pointlocation) {
		this.pointlocation = pointlocation;
	}

	@OneToMany(mappedBy = "emplacement")
	public Set<Registre> getRegistres() {
		return this.registres;
	}

	public void setRegistres(Set<Registre> registres) {
		this.registres = registres;
	}

}
