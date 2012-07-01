package fr.afcepf.ai83.itinelib.service;

import java.util.List;

import fr.afcepf.ai83.itinelib.model.Abonne;

public interface IAbonneService  {
	List<Abonne> findAll();
	List<Abonne> findByPrenom(String prenom);
	List<Abonne> findByNom(String nom);
	List<Abonne> findByTelephone(String telephone);
	Abonne findById(Integer id);
	void save(Abonne abonne, String codepostal);
}
