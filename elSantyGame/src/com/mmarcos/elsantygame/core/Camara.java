package com.mmarcos.elsantygame.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Camara {
	
	PanelDeJuego pdj;
	private int xMundial;
	private int yMundial;
	private int velocidad;
	private Rectangle area;
	
	public final int X_PANTALLA;
	public final int Y_PANTALLA;
	
	public Camara(PanelDeJuego pdj){
		
		this.pdj = pdj;
		this.xMundial = 0;
		this.yMundial = 0;
		
		this.velocidad = 4;

		this.X_PANTALLA = pdj.anchoDePantalla / 2 - (pdj.tamañoDeBaldosa / 2);
		this.Y_PANTALLA = pdj.altoDePantalla / 2 - (pdj.tamañoDeBaldosa / 2);
		
		this.area = new Rectangle(X_PANTALLA, Y_PANTALLA, pdj.tamañoDeBaldosa, pdj.tamañoDeBaldosa);
		
	}
	
	public void actualizar() {
		mover();
	}
	
	private void mover() {
		if(pdj.teclado.W) {
			this.yMundial-= velocidad;
		}
		if(pdj.teclado.S) {
			this.yMundial+= velocidad;
		}
		if(pdj.teclado.D) {
			this.xMundial+= velocidad;
		}
		if(pdj.teclado.A) {
			this.xMundial-= velocidad;
		}
	}
	
	public void dibujar(Graphics2D g2) {
		g2.setColor(Color.red);
		g2.drawRect(area.x, area.y, area.width, area.height);
	}

	public int getXMundial() {
		return xMundial;
	}

	public void setXMundial(int posX) {
		this.xMundial = posX;
	}

	public int getYMundial() {
		return yMundial;
	}

	public void setYMundial(int posY) {
		this.yMundial = posY;
	}

	public Rectangle getArea() {
		return area;
	}

	public void setArea(Rectangle area) {
		this.area = area;
	}

}
