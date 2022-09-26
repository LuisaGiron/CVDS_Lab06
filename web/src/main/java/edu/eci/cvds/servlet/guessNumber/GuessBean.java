package edu.eci.cvds.servlet.guessNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Parte logica del juego adivinar un numero
 * @author Luisa Bermudez - Daniela Ladino
 * @version 1 (25/09/2022)
 */
@ManagedBean (name = "guessBean")
@ApplicationScoped
//@SessionScoped 
public class GuessBean {
	
	private int numAdivinar;
	private int numIntento;
	private int premio;
	private String estadoJuego;
	
	private ArrayList<Integer> numIntentados;
		
	public GuessBean() {
		restart();
	}
	
	public int getNumAdivinar() {
		return numAdivinar;
	}

	public void setNumAdivinar(int numAdivinar) {
		this.numAdivinar = numAdivinar;
	}

	public int getNumIntento() {
		return numIntento;
	}

	public void setNumIntento(int numIntento) {
		this.numIntento = numIntento;
	}

	public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}

	public String getEstadoJuego() {
		return estadoJuego;
	}

	public void setEstadoJuego(String estadoJuego) {
		this.estadoJuego = estadoJuego;
	}

	public ArrayList<Integer> getNumIntentados() {
		return numIntentados;
	}

	/**
	 * Permite saber si se adivino el numero, cuanto intentos fallidos tuvo, de cuanto es el premio
	 * y el estado del juego
	 * @param intentoAdivinar numero que ingresa el usuario para intentar adivinar el numero
	 */
	public void guess(int intentoAdivinar) {
		if(numIntentados.contains(intentoAdivinar)) {
			estadoJuego = "Ya ingreso este numero, intente con otro";
			
		}else if(intentoAdivinar!=numAdivinar) {
			
			numIntento++;
			premio -= 10000;
			estadoJuego="Sigue intentado";
			if(numIntento==10) {
				estadoJuego = "Perdio";
			}
			numIntentados.add(intentoAdivinar);
			
		}else {
			estadoJuego = "Ganaste, tu premio es de: " + String.valueOf(premio);
		}
		
	}
	
	/**
	 * Debe volver a iniciar el juego (inicializar de nuevo el número a adivinar, y restaurar 
	 * el premio a su valor original).
	 */
	public void restart() {
		numAdivinar = ((int)(Math.random()*20+1));
        numIntento =0;
        premio =100000;
        estadoJuego = "";
        numIntentados = new ArrayList<Integer>();
	}


}
