package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Ville;

@Service("abonneService")
@Transactional
public class AbonneServiceImpl implements IAbonneService {
	
	@Autowired
	private IVilleService iVilleService;
	@Autowired
	private SessionFactory sessionFactory;
	
	//Faire la liste de tout les abonnés
	@Override
	@SuppressWarnings("unchecked")
	public List<Abonne> findAll() {
		List<Abonne> liste = 
			sessionFactory.getCurrentSession().createQuery("from Abonne a LEFT JOIN FETCH a.utilisateurs").list();
		return liste;
	}
	
	//Trouver un abonne en fonction de son ID
	@Override
	public Abonne findById(Integer id) {
		return (Abonne) sessionFactory.getCurrentSession().get(Abonne.class, id);
	}

	//Chercher un abonne en fonction de son prenom
	@SuppressWarnings("unchecked")
	@Override
	public List<Abonne> findByPrenom(String prenom) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Abonne a WHERE prenom =:prenom");
		query.setString("prenom", prenom);
		List<Abonne> liste= query.list();
		return liste;
	}
	
	//Chercher un abonne en fonction de son nom
	@SuppressWarnings("unchecked")
	@Override
	public List<Abonne> findByNom(String nom) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Abonne a WHERE nom =:nom");
		query.setString("nom", nom);
		List<Abonne> liste= query.list();
		return liste;
	}

	//Chercher un abonne en fonction de son telephone
	@SuppressWarnings("unchecked")
	@Override
	public List<Abonne> findByTelephone(String telephone) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Abonne a WHERE tel =:telephone");
		query.setString("tel", telephone);
		List<Abonne> liste= query.list();
		return liste;
	}
	
	//Modifier ou creer un abonne
	@Override
	public void save(Abonne abonne, String codepostal) {
		Ville ville = iVilleService.findByCodePostal(codepostal);
		abonne.setVille(ville);
		sessionFactory.getCurrentSession().saveOrUpdate(abonne);
		System.out.println(abonne.getVille().getCodepostal());
	}
}
