package fr.afcepf.ai83.itinelib.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.afcepf.ai83.itinelib.model.Registre;
import fr.afcepf.ai83.itinelib.model.Resaglobale;
import fr.afcepf.ai83.itinelib.service.IResaGlobaleService;


@Component("adminResaGlobaleIndexBean")
@Scope("session")
public class AdminResaGlobaleIndexBean implements Serializable {
	
	
	private List<ReservationView> reservationsListView;
	private List<Resaglobale> resaGlobaleList;
	
	
	@Autowired
	private transient IResaGlobaleService resaGlobaleService;
	
	
	//METHODS
	@PostConstruct
	public void init() {
		reservationsListView = new ArrayList<ReservationView>();
		resaGlobaleList = resaGlobaleService.findAll();
		
		
		for(Resaglobale rg : resaGlobaleList) {
			ReservationView resaView = new ReservationView();
			
			// on remplit la r�sa globale courante
			// r�cup�ration de l'identifiant de la r�servation globale
			resaView.setIdresaglobale(rg.getIdresaglobale());
			
			// pr�paration du registre pour r�cup�rer ce que je veux
			Set<Registre> li = rg.getRegistres();
			Registre premierRegistre = (Registre) li.toArray()[0];
			
			// r�cup�ration du nom de la station de d�part de la r�servation (donc du premier registre)
			resaView.setNompointlocation( premierRegistre.getPointlocationByIdpointlocation().getNompointlocation() );
			//r�cup�ration de la date et de l'heure pr�vues de la r�servation
			resaView.setDhreservationprevue( premierRegistre.getDhreservationprevue() );
			
			// pr�paration de l'abonn�
			// r�cup�ration de l'identifiant de l'abonn�
			resaView.setIdabonne( rg.getAbonnement().getAbonne().getIdabonne() );
			// r�cup�ration du nom de l'abonn�
			resaView.setNomabonne( rg.getAbonnement().getAbonne().getNomabonne() );
			// r�cup�ration du pr�nom de l'abonn�
			resaView.setPrenomabonne( rg.getAbonnement().getAbonne().getPrenomabonne() );
			
			
			reservationsListView.add(resaView);
		}
	}
	
	
	
	//GETTERS & SETTERS
	public List<ReservationView> getReservationsListView() {
		return reservationsListView;
	}

	public void setReservationsListView(List<ReservationView> reservationsListView) {
		this.reservationsListView = reservationsListView;
	}

	public List<Resaglobale> getResaGlobaleList() {
		return resaGlobaleList;
	}

	public void setResaGlobaleList(List<Resaglobale> resaGlobaleList) {
		this.resaGlobaleList = resaGlobaleList;
	}

	public IResaGlobaleService getResaGlobaleService() {
		return resaGlobaleService;
	}

	public void setResaGlobaleService(IResaGlobaleService resaGlobaleService) {
		this.resaGlobaleService = resaGlobaleService;
	}

	
	
	
	
	
}
