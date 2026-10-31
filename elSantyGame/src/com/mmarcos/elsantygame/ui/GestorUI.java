package com.mmarcos.elsantygame.ui;

import java.awt.Graphics2D;

import com.mmarcos.elsantygame.core.PanelDeJuego;

public class GestorUI {
	
	PanelDeJuego pdj;
	Graphics2D g2;
	
	private BotonUI btnCerrar;
	private BotonUI btnMaximizar;
	private BotonUI btnMinimizar;
	
	public float escala;
	
	public GestorUI(PanelDeJuego pdj) {
		this.pdj = pdj;
		
		btnCerrar = new BotonUI(pdj.btnCerrar);
		btnMaximizar = new BotonUI(pdj.btnMaximizar);
		btnMinimizar = new BotonUI(pdj.btnMinimizar);
		
	}
	
	public void dibujar(Graphics2D g2) {
		this.g2 = g2;
		
		this.escala = Math.min(
		        (float) pdj.getWidth() / pdj.anchoDePantalla,
		        (float) pdj.getHeight() / pdj.altoDePantalla
		    );
		
		escala = Math.min(escala, 1.10f);
		
		/////////////////////////////////////////////
		
		dibujarPantallaDeJuego();
		
		/////////////////////////////////////////////

		g2.setColor(TemaUI.UI_NEGRO);
		g2.fillRect(0 - pdj.tamañoDeBaldosa, 0, pdj.tamañoDeBaldosa, pdj.altoDePantalla);
		g2.fillRect(pdj.anchoDePantalla, 0, pdj.tamañoDeBaldosa, pdj.altoDePantalla);
		
		btnMinimizar.dibujar(escala, g2);
		btnMaximizar.dibujar(escala, g2);
		btnCerrar.dibujar(escala, g2);
	}
	
	private void dibujarPantallaDeJuego() {
		pdj.camara.dibujar(g2);
	}

}