package com.mmarcos.elsantygame.ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import com.mmarcos.elsantygame.componentes.Boton;

public class BotonUI {
	
	Graphics2D g2;
	public Boton model;
	
	public BotonUI(Boton model, Graphics2D g2) {
		this.g2 = g2;
		this.model = model;
	}
	
	public void dibujar(float escalado) {
		int x = model.getArea().x;
		int y = model.getArea().y;
		int ancho = model.getArea().width;
		int alto = model.getArea().height;
		int curva = 8;
		
		int ajusteAltura = 4;

		g2.setFont(TemaUI.getMarumonica(TemaUI.TAM_BOTON, escalado));
		String texto = model.getTexto();
		
		FontMetrics fm = g2.getFontMetrics();
		int textoX = x + (ancho - fm.stringWidth(texto)) / 2;
		int textoY = y + ((alto - fm.getHeight()) / 2) + fm.getAscent();
		
		g2.setColor(TemaUI.UI_SOMBRA);
		g2.fillRoundRect(x + ajusteAltura, y + ajusteAltura, ancho, alto, curva, curva);
		
		g2.setColor(TemaUI.UI_PRIMARIO);
		g2.fillRoundRect(x, y, ancho, alto, curva, curva);
		
		g2.setColor(TemaUI.UI_TEXTO);
		g2.drawRoundRect(x, y, ancho, alto, curva, curva);

		g2.drawString(texto, textoX, textoY);
		
		if(model.isPresionado()) {
			g2.setColor(TemaUI.UI_TEXTO);
			g2.fillRoundRect(x, y, ancho, alto, curva, curva);
		}
		else if(model.isResaltado()) {
			g2.setColor(TemaUI.UI_LUZ);
			g2.fillRoundRect(x, y, ancho, alto, curva, curva);
			
			g2.setColor(TemaUI.UI_SOMBRA);
			g2.drawString(texto, textoX, textoY);
		}	
		
	}

}