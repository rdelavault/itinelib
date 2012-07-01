package fr.afcepf.ai83.itinelib.service;

import java.util.Date;
import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Abonnement;
import fr.afcepf.ai83.itinelib.model.Typeabonnement;

@Service("abonnementService")
@Transactional
public class AbonnementServiceImpl implements IAbonnementService {

	@Autowired
	private ITypeAbonnementService iTypeAbonnementService;
	@Autowired
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	@Override

	//Faire une liste de tous les abonnements
	public List<Abonnement> findAll() {
		List<Abonnement> liste = 
			sessionFactory.getCurrentSession().createQuery("from Abonnement ab ").list();
		return liste;
	}
	//Trouver un abonnement en fonction de son ID
	@Override
	public Abonnement findById(Integer id) {
		return (Abonnement) sessionFactory.getCurrentSession().get(Abonnement.class, id);
	}

	//Modifer ou creer un abonnement
	@Override
	public void save(Abonnement abonnement, Abonne abonne, Integer idType) {
		Typeabonnement typeAbonnement = iTypeAbonnementService.findById(idType);
		abonnement.setTypeabonnement(typeAbonnement);
		abonnement.setAbonne(abonne);
		abonnement.setDhsouscription(new Date());
		sessionFactory.getCurrentSession().saveOrUpdate(abonnement);
		System.out.println(abonnement.getIdabonnement());
	}

}
