package br.uerj.hangman.game;
/**
 * Ultima atualizacao 14/01/2005 - 17:25
 * Autor: Felipe Goncalves de Oliveira Lino
 * Programa: Jogo da Forca - TelaPontuacao.java
 * 
 * Contem a GUI da Janela Pontuacao
 *
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TelaPontuacao extends JFrame
{
	public JButton ok;
	private JTextArea areaTexto;
  	private Container cp;
    	
    TelaPontuacao()
	{
		super("Pontua\u00E7\u00E3o");
		setSize(620,660);
		this.setResizable(true);
		
		cp= getContentPane();
		cp.setLayout(new FlowLayout());
		
		areaTexto = new JTextArea("",13,0);
		areaTexto.setEditable(false);
		areaTexto.setFont(new Font("Courier",Font.PLAIN,28));
		areaTexto.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(areaTexto,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		cp.add(scrollPane);
		
		ok = new JButton("OK");
		cp.add(ok);	
		
	}
   	
   	void adicionarTexto(List lista)
   	{
   		areaTexto.setText("Nome do Jogador       Pontua\u00E7\u00E3o\n\n");
   		for(int i=0;i<lista.size();i++)
		{
			areaTexto.append(lista.get(i).toString());
		}
   	}
}
