package fr.afcepf.ai83.itinelib.web;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import fr.afcepf.ai83.itinelib.model.Abonne;
import fr.afcepf.ai83.itinelib.model.Utilisateur;
import fr.afcepf.ai83.itinelib.service.IAbonneService;


@Component("adminAbonnesIndexBean")
@Scope("session")
public class AdminAbonnesIndexBean implements Serializable {
	private List<Abonne> abonneList;
	private List<AbonneView> abonneListView;
	
	
	
	@Autowired
	private transient IAbonneService iabonneservice;
	
	@PostConstruct
	public void init() {
		abonneListView = new ArrayList<AbonneView>();
		abonneList = iabonneservice.findAll();
	
		
		for (Abonne abo : abonneList) {
			AbonneView abonneView = new AbonneView();
			abonneView.setIdabonne(abo.getIdabonne());
			abonneView.setNomabonne(abo.getNomabonne());
			abonneView.setPrenomabonne(abo.getPrenomabonne());
			abonneView.setAdresse(abo.getAdresse());
			abonneView.setTel(abo.getTel());
			abonneView.setDatenaissance(abo.getDatenaissance());
			abonneView.setSexe(abo.getSexe());
			abonneView.setTitulairecompte(abo.getTitulairecompte());
			abonneView.setCodebanque(abo.getCodebanque());
			abonneView.setCodeagence(abo.getCodeagence());
			abonneView.setNumerocompte(abo.getNumerocompte());
			abonneView.setClefrib(abo.getClefrib());
			abonneView.setIdville(abo.getVille().getIdville());
			abonneView.setNomville(abo.getVille().getNomville());
			abonneView.setCodepostal(abo.getVille().getCodepostal());
			
			for (Utilisateur util : abo.getUtilisateurs()) {
				abonneView.setEmail(util.getEmail());
			}
			abonneListView.add(abonneView);
		}
	}

	
	/* Accessors */
	
	public List<Abonne> getAbonneList() {
		return abonneList;
	}

	public void setAbonneList(List<Abonne> abonneList) {
		this.abonneList = abonneList;
	}

	public List<AbonneView> getAbonneListView() {
		return abonneListView;
	}


}
