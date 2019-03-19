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
	
	/**
	 * Ricerca un voto relativo al corso di cui mi passa il nome
	 * @param nomeEsame
	 * @return il voto corrispondente oppure null se non c'e quell esame
	 */
	public Voto cercaEsame(String nomeEsame) {
		for(Voto v: voti) {
			if(v.getCorso().compareTo(nomeEsame)==0) { // .equals(nomeEsame); ES coordinate 22 34 != ma compareto non sa risp
				return v;
			}
		}
		return null;
	
	}
	
}	
