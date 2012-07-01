package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Abonnement;;

public interface IAbonnementService {

	List<Abonnement> findAll();
	Abonnement findById(Integer id);
	void save(Abonnement abonnement,Abonne abonne, Integer idType);
}
