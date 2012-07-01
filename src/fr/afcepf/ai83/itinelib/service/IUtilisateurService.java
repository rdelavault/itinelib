package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import fr.afcepf.ai83.itinelib.model.Utilisateur;;

public interface IUtilisateurService {

	
	List<Utilisateur> findAll();
	Utilisateur findById(Integer id);
	List<Utilisateur> findByEmail(String email);
	void saveAbonne(Utilisateur utilisateur, Integer id, String password);
}
