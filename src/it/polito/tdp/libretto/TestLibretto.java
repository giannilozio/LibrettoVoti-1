package it.polito.tdp.libretto;

import java.util.List;
import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto libr= new Libretto ();
		libr.add(new Voto(30,"Analisi 1",LocalDate.of(2017, 2, 15)));
		libr.add(new Voto(21,"Analisi 2",LocalDate.of(2018, 2, 15)));
		libr.add(new Voto(25,"Fisica 2",LocalDate.of(2017, 1, 11)));
		libr.add(new Voto(24,"Fisica 1",LocalDate.of(2019, 2, 28)));
		libr.add(new Voto(18,"Geometria",LocalDate.of(2017, 9, 15)));
		libr.add(new Voto(19,"Informatica",LocalDate.of(2017, 6, 19)));
		libr.add(new Voto(26,"Programmazione a oggetti",LocalDate.of(2019, 02, 18)));
		libr.add(new Voto(20,"Economia",LocalDate.of(2018, 7, 24)));
		libr.add(new Voto(25,"Ricerca operativa",LocalDate.of(2019, 6, 22)));
		libr.add(new Voto(25,"Sistemi di produzione",LocalDate.of(2018, 9, 26)));
		
		List<Voto>venticinque =libr.cercaVoti(25);
		System.out.println(venticinque);
	}

}
