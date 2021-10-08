package br.uerj.hangman.game;

import java.awt.event.*;
public class FechaJanela extends WindowAdapter
{
	WindowEvent evento;
	public void windowClosing(WindowEvent e)
	{
		e.getWindow().dispose();
		evento=e;
	}
	
}
