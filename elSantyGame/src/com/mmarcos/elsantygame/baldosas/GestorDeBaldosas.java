package com.mmarcos.elsantygame.baldosas;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import com.mmarcos.elsantygame.core.PanelDeJuego;

public class GestorDeBaldosas {
	
	PanelDeJuego pdj;
	Baldosa[] baldosa;
	int mapaNumeroBaldosa[][];
	
	public GestorDeBaldosas(PanelDeJuego pdj){
		this.pdj = pdj;
		baldosa = new Baldosa[10];
		mapaNumeroBaldosa = new int[pdj.maxColDeMundo][pdj.maxFilaDeMundo];
		obtenerImagenBaldosa();
		cargarMapa("/mapas/map-sample.txt");
	}
	
	public void cargarMapa(String path) {
		try {
			
			InputStream is = getClass().getResourceAsStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int fila = 0;
			
			while(col < pdj.maxColDeMundo && fila < pdj.maxFilaDeMundo) {
				
				String linea = br.readLine();
				
				while(col < pdj.maxColDePantalla) {
					
					String numeros[] = linea.split(" ");
					int numeroBaldosa = Integer.parseInt(numeros[col]);
					
					mapaNumeroBaldosa[col][fila] = numeroBaldosa;
					col++;
					
				}
				if(col == pdj.maxColDePantalla) {
					col = 0;
					fila++;
				}
				
			}
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void obtenerImagenBaldosa() {
		try {
			
			baldosa[0] = new Baldosa();
			baldosa[0].imagen = ImageIO.read(getClass().getResourceAsStream("/baldosas/grama.png"));
			
			baldosa[1] = new Baldosa();
			baldosa[1].imagen = ImageIO.read(getClass().getResourceAsStream("/baldosas/suelo.png"));
			
			baldosa[2] = new Baldosa();
			baldosa[2].imagen = ImageIO.read(getClass().getResourceAsStream("/baldosas/agua.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dibujar(Graphics2D g2) {
		
		int col = 0;
		int fila = 0;
		
		while(col < pdj.maxColDeMundo && fila < pdj.maxFilaDeMundo) {
			
			int numeroBaldosa = mapaNumeroBaldosa[col][fila];
			
			int xMundial = col * pdj.tamañoDeBaldosa;
			int yMundial = fila * pdj.tamañoDeBaldosa;
			
			int xPantalla = xMundial - pdj.camara.getXMundial() + pdj.camara.X_PANTALLA;
			int yPantalla = yMundial - pdj.camara.getYMundial() + pdj.camara.Y_PANTALLA;
			
			if (xMundial + pdj.tamañoDeBaldosa > pdj.camara.getXMundial() - pdj.camara.X_PANTALLA && 
				xMundial - pdj.tamañoDeBaldosa < pdj.camara.getXMundial() + pdj.camara.X_PANTALLA && 
				yMundial + pdj.tamañoDeBaldosa > pdj.camara.getYMundial() - pdj.camara.Y_PANTALLA && 
				yMundial - pdj.tamañoDeBaldosa < pdj.camara.getYMundial() + pdj.camara.Y_PANTALLA) 
			{
				g2.drawImage(baldosa[numeroBaldosa].imagen, xPantalla, yPantalla, pdj.tamañoDeBaldosa, pdj.tamañoDeBaldosa, null);
			}
			
			col++;
			
			if(col == pdj.maxColDeMundo) {
				col = 0;
				fila++;
			}
		}
		
	}

}
