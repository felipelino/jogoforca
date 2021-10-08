package br.uerj.hangman.game;
/**
 * Ultima atualizacao 06/01/2005 - 10:19
 * Autor: Felipe Goncalves de Oliveira Lino
 * Tirado da Apostila Introducao ao Java 
 * 		de Peter Jandl Junior.
 * Programa: Jogo da Forca - CloseWindowAndExit.java
 * 
 * Funcao de Fechar a Janela e Sair
 *
 */

import java.awt.event.*;
public class CloseWindowAndExit extends WindowAdapter  
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	
	public void windowActivated(WindowEvent e)
	{
		e.getWindow().setFocusable(true);
	}
}
