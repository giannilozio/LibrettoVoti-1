package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti ;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>() ;
	}
		
	
	/**
	 * Aggiunge un nuovo voto al libretto
	 * @param v il {link Voto} da aggiungere
	 */
	public void add(Voto v) {
		voti.add(v);
		}

	/**
	 * Seleziona il sottoinsieme di voti che hanno quel punteggio passato
	 * @param punti punteggio di ricerca 
	 * @return lista di Voti con quel punteggio
	 */
	public List<Voto> cercaVoti(int punti){ // LI METTO IN LIST PERCHE' POI MI SERVONO SULL INTERFACCIA GRAFICA
		List<Voto>result=new ArrayList<Voto>();					   // SE NO NON POTREI TENERLI A MEMORIA
		for(Voto v: voti) {
			if(v.getPunti()==punti) {
				result.add(v);
			}
		}
		return result;
	}
	
}	
