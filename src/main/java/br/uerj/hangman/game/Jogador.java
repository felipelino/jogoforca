package br.uerj.hangman.game;

/**
 * Ultima atualizacao 14/01/2005 - 16:50
 * Autor: Felipe Goncalves de Oliveira Lino
 * Programa: Jogo da Forca - Classe Jogador.java
 * 
 * Contem os metodos referentes ao Jogador. Pontuacao.
 *
 */
public class Jogador 
{
	private String nome;
	private int pontos;
	Forca partida;	
	
	Jogador()
	{
		nome="Desconhecido";
		pontos=0;
	}
	
	Jogador(String temp)
	{
		nome=temp;
		pontos=0;
	}
	
	void setNome(String temp)
	{
		nome=temp;
	}
	
	boolean novoJogo(String palavra)
	{
		partida = new Forca(palavra);	
		
		return true;
	}
	
	boolean novoJogo()
	{
		partida = new Forca();
		
		return true;
	}
	
	int pontuacao()
	{
		if(partida.getAcerto()==0)
			pontos=0;
		else
		pontos=(int)100-(partida.getErro()*20)+(100*partida.getAcerto()/partida.getTamanho());
		
		pontos=(int)pontos / partida.getDivisor();
		
		return pontos;
	}
	
	public String toString() //retorna o nome
	{
		String espaco="";
		for(int i=0;i<(30-nome.length());i++)
		{
			espaco=espaco+" ";
		}
		return nome+espaco+pontuacao()+"\n";
	}
	
}
