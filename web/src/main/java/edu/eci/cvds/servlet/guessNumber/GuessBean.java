package edu.eci.cvds.servlet.guessNumber;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean (name = "guessBean")
@ApplicationScoped
public class GuessBean {
	
	private int numAdivinar;
	private int numIntentos;
	private int premio;
	private String estadoJuego;
	private int intentoAdivinar;
	private ArrayList<Integer> numIntentados;
	
	public GuessBean() {
		setNumAdivinar((int)(Math.random()*10+1));
		setNumIntentos(0);
		setPremio(0);
		setEstadoJuego("Adivina el numero");
		setNumIntentados(new ArrayList<Integer>());
	}
	
	public void guess(int intentoAdivinar) {
		
	}
	
	public void restart() {}

	public int getNumAdivinar() {
		return numAdivinar;
	}

	public void setNumAdivinar(int numAdivinar) {
		this.numAdivinar = numAdivinar;
	}

	public int getNumIntentos() {
		return numIntentos;
	}

	public void setNumIntentos(int numIntentos) {
		this.numIntentos = numIntentos;
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

	public int getIntentoAdivinar() {
		return intentoAdivinar;
	}

	public void setIntentoAdivinar(int intentoAdivinar) {
		this.intentoAdivinar = intentoAdivinar;
	}

	public ArrayList<Integer> getNumIntentados() {
		return numIntentados;
	}

	public void setNumIntentados(ArrayList<Integer> numIntentados) {
		this.numIntentados = numIntentados;
	}
}
