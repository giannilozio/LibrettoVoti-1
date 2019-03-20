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
	 * @return true se lo aggiunge e false se non riesce ad aggiungerlo
	 */
	public boolean add(Voto v) {
		if(!esisteVoto(v) && !votoInConflitto(v)) {
		voti.add(v);
		return true;
		}else {
			return false;
		}
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
		/*for(Voto v: voti) {
			if(v.getCorso().compareTo(nomeEsame)==0) { // .equals(nomeEsame); ES coordinate 22 34 != ma compareto non sa risp
				return v;
			}
		}
		return null;
	*/
		Voto v= new Voto(0,nomeEsame,null); // creo un voto fake per avere l oggetto che mi richiede il metodo indexof
		int pos= voti.indexOf(v);			// anche se a me interessa solo il nome dell esame
		if(pos==-1)
		return null;
		else
			return voti.get(pos); // ho l indice di quell oggetto e ritorno quel voto con quell indice
	}
	
	public boolean esisteVoto(Voto v) {
		/*Voto trovato= this.cercaEsame(v.getCorso());
		
		if(trovato==null)
				return false;
		
		if(trovato.getPunti()==v.getPunti()) {
			return true;
		}else {
			return false;
		}
    }	
    */
		int pos= voti.indexOf(v);
		if(pos==-1) {
			return false;
		}else	
			return (v.getPunti()==voti.get(pos).getPunti());
		
	}
	
	/**
	 * mi dice se il voto e' in conflitto con uno di quelli esistenti.
	 * Se non esiste non c'e conflitto, se esiste ed ha punteggio diverso c'e conflitto
	 * @param v
	 * @return true se il voto esiste ed ha punteggio diverso
	 * 		   false se il voto non esiste, o ha lo stesso punteggio
	 */
	public boolean votoInConflitto(Voto v) {
		int pos= voti.indexOf(v);
		if(pos==-1) {
			return false;
		}else	
			return (v.getPunti() != voti.get(pos).getPunti());
		
		
	}
	
	public String toString() {
		return this.voti.toString();
	}
	
	public Libretto librettoMIgliorato() {
		Libretto nuovo= new Libretto();
		for(Voto v: this.voti) {
			//nuovo.add(v);			 SE LO CAMBIO QUI CAMBIA ANCHE NELL ALTRO LIBRETTO
			//nuovo.add(new Voto(v.getPunti(),v.getCorso(),v.getData())); // CLONO L OGGETTO DEL LIBRETTO PRECEDENTE
		nuovo.add(v.clonati());
		}
		for(Voto v: nuovo.voti) {
			int punti= v.getPunti();
			if(punti<24) {
				punti=punti + 1;
			}
				else if(punti <=28) {
				punti+=2;
				v.setPunti(punti);
			}
		}
			return nuovo;
	}
	public void cancellaVoto() {
		List<Voto> cancellare= new ArrayList<Voto>();
		for(Voto v: voti) {
			if(v.getPunti()<24) {
				cancellare.add(v);
			}
		}
		this.voti.removeAll(cancellare);
	}
	
}