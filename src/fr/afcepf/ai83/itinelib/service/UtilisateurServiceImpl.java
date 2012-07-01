package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Utilisateur;
import fr.afcepf.ai83.itinelib.model.Ville;

@Service("utilisateurService")
@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService {

	@Autowired
	private IAbonneService iAbonneService;
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//Faire la liste de tout les utilisateur
	@Override
	@SuppressWarnings("unchecked")
	public List<Utilisateur> findAll() {
		List<Utilisateur> liste = 
			sessionFactory.getCurrentSession().createQuery("from Utilisateur u ").list();
		return liste;
	}
	
	//Chercher un utilisateur en fonction de son ID
	@Override
	public Utilisateur findById(Integer id) {
		return (Utilisateur) sessionFactory.getCurrentSession().get(Utilisateur.class, id);
	}
	
	//Chercher  utilisateur en fonction de l'email
	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findByEmail(String email) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Utilisateur u WHERE email =:email");
		query.setString("email", email);
		List<Utilisateur> liste= query.list();
		return liste;
	}

	//Modifier ou creer un utilisateur
	@Override
	public void saveAbonne(Utilisateur utilisateur, Integer id, String password) {
		Abonne abonne = iAbonneService.findById(id);
		utilisateur.setAbonne(abonne);
		utilisateur.setRole("User");
		utilisateur.setMotdepassHash(password);
		utilisateur.setMotdepassSalt(password);
		sessionFactory.getCurrentSession().saveOrUpdate(utilisateur);
		System.out.println(utilisateur.getAbonne().getIdabonne());
		
	}


}
