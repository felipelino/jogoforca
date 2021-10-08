package br.uerj.hangman.game; /**
 * Ultima atualizacao 12/03/2005 - 15:25
 * Autor: Felipe Goncalves de Oliveira Lino
 * Programa: Jogo da Forca - TelaJogo.java
 * 
 * Contem a GUI do Jogo
 *
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.JOptionPane;

public class TelaJogo extends JFrame 
implements ActionListener,ItemListener,KeyListener
{
	/* Variaveis do Jogo */
	private boolean bolNovo=false;
	private String word="NENHUMA";
	private Jogador player;
	private List strPontuacao = new ArrayList();
	private String nome;
	private boolean m2Opcao=true;
	private TelaPontuacao tela;
	
	/* Botoes de Opcao */
	private JMenuBar barraMenu;
	private JMenuItem m1NovoJogo;
	private JMenuItem m1NovoJogador;
	private JMenuItem m1Sair; 
	private JRadioButton m2Sorteio;
	private JRadioButton m2Palavra;
	private ButtonGroup grupoBotaoM2;
	private JMenuItem m3Pontuacao;
	private JMenuItem m3Sobre;
	
	/* Barra de Status */
	private JTextField barraStatus;
		
	/* Botoes de letras */
	private Map<Character, JButton> mapCharButton;
	
	/* Botao ok para dizer uma palavra */
	private JButton ok;
	
	/* T�tulos que aparecem no Jogo */
	private JLabel escolhida,digite,tentativa,titulo;
	
	/* Area de texto com a palavra digitada pelo jogador */
	private JTextField palavra;
	
	/* Figura com a Forca */
	private Image imagem;
	
	private Container cp;
	/* Construtor de TelaJogo */
	TelaJogo()
	{
		super("Emocionante Jogo da Forca - Felipe Lino IME/UERJ");
		setSize(860,660);
		this.setResizable(true);
		
		tela = new TelaPontuacao();
				
		/*Instanciacao dos Componentes */
		titulo = new JLabel("Emocionante Jogo da Forca");
		titulo.setFont(new Font("Verdana",Font.ITALIC,44));
		titulo.addKeyListener(this);
		escolhida = new JLabel("P A L A V R A  O C U L T A");
		escolhida.setFont(new Font("Arial",Font.TRUETYPE_FONT,40));
		escolhida.addKeyListener(this);
		tentativa = new JLabel("Palavra de  _  letras  |  Tentativas 0/5");
		tentativa.setFont(new Font("Arial",Font.TRUETYPE_FONT,40));
		tentativa.addKeyListener(this);
		digite = new JLabel("Digite a palavra:");
		digite.setFont( new Font("SanSerif", Font.TRUETYPE_FONT, 30));
		digite.addKeyListener(this);
		
		barraMenu = new JMenuBar();
		barraMenu.addKeyListener(this);
		// Menu Jogo
		JMenu menuJogo = new JMenu("Jogo");
		menuJogo.addKeyListener(this);
		m1NovoJogo = new JMenuItem("Novo Jogo     F2");
		m1NovoJogo.addKeyListener(this);
		m1NovoJogador = new JMenuItem("Novo Jogador  F3");
		m1NovoJogador.addKeyListener(this);
		m1Sair = new JMenuItem("Sair      Ctrl Q");
		m1Sair.addKeyListener(this);
		m1NovoJogo.addActionListener(this);
		m1NovoJogador.addActionListener(this);
		m1Sair.addActionListener(this);
		menuJogo.add(m1NovoJogo);
		menuJogo.add(m1NovoJogador);
		menuJogo.addSeparator();
		menuJogo.add(m1Sair);
		barraMenu.add(menuJogo);
		
		// Menu Opcoes
		JMenu menuOpcoes = new JMenu("Op\u00E7\u00F5es");
		menuOpcoes.addKeyListener(this);
		m2Sorteio = new JRadioButton("Palavra Sorteada",true);
		m2Palavra = new JRadioButton("Palavra do Jogador",false);
		m2Sorteio.addKeyListener(this);
		m2Palavra.addKeyListener(this);
		grupoBotaoM2 = new ButtonGroup();
		grupoBotaoM2.add(m2Sorteio);
		grupoBotaoM2.add(m2Palavra);
		m2Sorteio.addItemListener(this);
		m2Palavra.addItemListener(this);
		menuOpcoes.add(m2Sorteio);
		menuOpcoes.add(m2Palavra);
		barraMenu.add(menuOpcoes);
		
		// Menu Ver
		JMenu menuVer = new JMenu("Ver");
		menuVer.addKeyListener(this);
		m3Pontuacao = new JMenuItem("Pontua\u00E7\u00E3o  F4");
		m3Sobre = new JMenuItem("Sobre      F1");
		m3Pontuacao.addActionListener(this);
		m3Sobre.addActionListener(this);
		m3Pontuacao.addKeyListener(this);
		m3Sobre.addKeyListener(this);
		menuVer.add(m3Pontuacao);
		menuVer.add(m3Sobre);
		barraMenu.add(menuVer);
		setJMenuBar(barraMenu);
		
		/* Barra de Status */
		barraStatus = new JTextField("F2 Para iniciar Novo Jogo. Em op\u00E7\u00F5es selecione o modo de jogo");
		barraStatus.setEditable(false);
		barraStatus.setBackground(SystemColor.control);
		barraStatus.setFont(new Font("SansSerif", Font.PLAIN,20));
		barraStatus.addKeyListener(this);

		this.mapCharButton = new HashMap<>();
		for (char ch: new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'})
		{
			JButton bt = new JButton(""+ch);
			bt.setFont(new Font("Arial", Font.PLAIN,48));
			bt.addKeyListener(this);
			bt.addActionListener(this);
			this.mapCharButton.put(ch, bt);
		}

		ok = new JButton("Ok");
		ok.setFont(new Font("Arial", Font.TRUETYPE_FONT, 30));
		ok.addActionListener(this);
		ok.addKeyListener(this);
		palavra = new JTextField("",17);
		palavra.setFont(new Font("Arial", Font.TRUETYPE_FONT, 24));
		palavra.addActionListener(this);
		palavra.addKeyListener(this);
		/* Adicao dos Componentes aos Panel */
		cp = getContentPane();
		cp.addKeyListener(this);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		cp.setLayout(gbl);
		
		gbc.gridx = 0; 
		gbc.gridy = 0; 
		gbc.gridwidth = GridBagConstraints.REMAINDER; 
		gbc.insets = new Insets(0, 0, 20, 0); 
		gbc.weightx = 0; 
		gbc.weighty = 0; 
		gbc.ipadx = 0; 
		gbc.ipady = 0;
		cp.add(titulo,gbc);
		
		gbc.gridwidth = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 1, 5, 1); 
		gbc.gridx = 0; 
		gbc.gridy = 1; 
		cp.add(mapCharButton.get('A'),gbc);
		
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = 1;
		cp.add(mapCharButton.get('B'),gbc);
		cp.add(mapCharButton.get('C'),gbc);
		cp.add(mapCharButton.get('D'),gbc);
		cp.add(mapCharButton.get('E'),gbc);
		cp.add(mapCharButton.get('F'),gbc);
		cp.add(mapCharButton.get('G'),gbc);
		cp.add(mapCharButton.get('H'),gbc);
		cp.add(mapCharButton.get('I'),gbc);

		gbc.gridy = 2;
		gbc.insets = new Insets(0, 1, 0, 1); 
		cp.add(mapCharButton.get('J'),gbc);
		cp.add(mapCharButton.get('K'),gbc);
		cp.add(mapCharButton.get('L'),gbc);
		cp.add(mapCharButton.get('M'),gbc);
		cp.add(mapCharButton.get('N'),gbc);
		cp.add(mapCharButton.get('O'),gbc);
		cp.add(mapCharButton.get('P'),gbc);
		cp.add(mapCharButton.get('Q'),gbc);
		cp.add(mapCharButton.get('R'),gbc);
		
		JPanel p1 = new JPanel();
		p1.add(mapCharButton.get('S'));
		p1.add(mapCharButton.get('T'));
		p1.add(mapCharButton.get('U'));
		p1.add(mapCharButton.get('V'));
		p1.add(mapCharButton.get('W'));
		p1.add(mapCharButton.get('X'));
		p1.add(mapCharButton.get('Y'));
		p1.add(mapCharButton.get('Z'));
		p1.addKeyListener(this);
		gbc.gridy = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER; 
		gbc.insets = new Insets(0, 1, 5, 1); 
		cp.add(p1,gbc);
		
		gbc.gridy = 4;
		cp.add(escolhida,gbc);
		
		gbc.gridy = 5;
		gbc.insets = new Insets(5, 1, 5, 1); 
		cp.add(tentativa,gbc);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER; 
		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0,0,0,0);
		cp.add(digite,gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;

		gbc.gridwidth = 5;
		cp.add(palavra,gbc);
		gbc.gridwidth = 1;
		cp.add(ok,gbc);
		
		gbc.gridy = 7;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(20,0,0,0);
		cp.add(barraStatus,gbc);
		
		desabilitaBotoes();
	}
	
	/* Implementacao da Interface ActioListener */
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==m2Sorteio)
		{
				m2Opcao=true;
				barraStatus.setText("Na op\u00E7\u00E3o escolhida a palavra ser\u00E1 sorteada pelo computador");
		}
		else
			if(e.getSource()==m2Palavra)
			{
				m2Opcao=false;
				barraStatus.setText("Na op\u00E7\u00E3o escolhida a palavra ser\u00E1 informada pelo jogador");
			}
	}
	
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource()==palavra)
		{
			botaoOk();
		}
		if(evento.getSource()==m1NovoJogo)
		{
			novoJogo();
		}// fim primeiro if m1 NovoJogo
		if(evento.getSource()==m1NovoJogador)
		{
			msgInserirNome();
		}
		else
		{
			if(evento.getSource()==m1Sair)
				System.exit(0);
			else
					if(evento.getSource()==m3Pontuacao)
					{
						msgPontuacao();
					}
					else
						if(evento.getSource()==m3Sobre)
						{
							msgSobre();
						}
						else
							if(evento.getSource()==tela.ok)
							{
								tela.dispose();
							}
						    else // else if(bolNovo)
						    	if(bolNovo)
						    	{
						    		if(evento.getSource()==ok)
						    		{
						    			botaoOk();
						    		} // fim do botao ok
						    		else
						    		{
						    			if (evento.getSource() instanceof JButton)
						    			{ // se o botao for uma letra
						    				JButton botaoLetra = (JButton)evento.getSource();
						    				botaoLetra.setEnabled(false);
						    				player.partida.verifica(botaoLetra.getLabel().charAt(0));
						    				escolhida.setText(player.partida.getOculta());
						    				tentativa.setText("Palavra de  "+player.partida.getTamanho()+"  letras  |  Tentativas: "+player.partida.getErro()+"/5");
						    			}
				
						    			if(player.partida.verFimJogo())
						    			{
						    				desabilitaBotoes();
						    				bolNovo=false;
						    				ok.setEnabled(false);
						    				palavra.setText("");
						    				palavra.setEnabled(false);
						    				barraStatus.setText("Partida encerrada. V\u00E1 em Novo Jogo e inicie nova partida");
						    				if(player.partida.verSeVenceu())
						    					mensagemVenceu();
						    				else
						    					mensagemPerdeu();
						    			}
						    		}// fim else botoes cp
						    	}// fim if bolNovo	
		} // fim primeiro else
	}
	
	public void keyPressed(KeyEvent evento)
	{
		switch(evento.getKeyCode())
		{
			case 112:msgSobre();break;
			case 113:novoJogo();break;
			case 114:msgInserirNome();break;
			case 115:msgPontuacao();break;
			case KeyEvent.VK_Q:System.exit(0);break;
			case 10: if(palavra.getText().length()>0)
						botaoOk();
		}
	}
	
	public void keyReleased(KeyEvent evento)
	{
	}
	
	public void keyTyped(KeyEvent evento)
	{
	}
	
	void botaoOk()
	{
		desabilitaBotoes();
		bolNovo=false;
		barraStatus.setText("Partida encerrada. V\u00E1 em Novo Jogo e inicie nova partida");
		if(player.partida.verSeVenceu(palavra.getText())==true)
			mensagemVenceu();
		else
			mensagemPerdeu();
	}
	
	void novoJogo()
	{
		if(strPontuacao.isEmpty())
		{
			msgInserirNome();
		}
		if(m2Opcao)
		{
			bolNovo=player.novoJogo();
			escolhida.setText(player.partida.getOculta());
		}
		else
		{
			boolean tudobem=false;
			word=JOptionPane.showInputDialog("Digite a Palavra:");
			while(tudobem==false)
			{
				word=word.toUpperCase();
				tudobem=true;
				for(int i=0;i<word.length();i++)
				{
					if((word.charAt(i)>'Z' || word.charAt(i)<'A'))
					{
						tudobem=false;
						word=JOptionPane.showInputDialog("Palavra Inv\u00E1lida, digite outra:");
						break;
					}
				}
			}
			bolNovo=player.novoJogo(word);
		}
		tentativa.setText("Palavra de  "+player.partida.getTamanho()+"  letras  |  Tentativas: 0/5");
		habilitaBotoes();
		palavra.setText("");
		escolhida.setText(player.partida.getOculta());
		barraStatus.setText("Para chutar uma letra clique nos bot\u00F5es");
	}
	
	void msgInserirNome()
	{
		nome=JOptionPane.showInputDialog(null,"Digite seu nome: ");
		if(nome==null)
			nome="Jogador Desconhecido";
		if(bolNovo==false)
		{
			player = new Jogador(nome);
		}
		else
		{
			player.setNome(nome);
		}
		
	}
	
	void mensagemVenceu()   
	{      
		String cadeia = player.toString();
		strPontuacao.add(cadeia);
		JOptionPane.showMessageDialog(null,nome+", voc\u00EA venceu!\n A Palavra era: "+player.partida+"\nPontos: "+player.pontuacao());
	}
	
	void mensagemPerdeu()
	{
		String cadeia = player.toString();
		strPontuacao.add(cadeia);
		JOptionPane.showMessageDialog(null,nome+", voc\u00EA perdeu!\n A Palavra era: "+player.partida+"\nPontos: "+player.pontuacao());
	}
	
	void msgSobre()
	{
		JOptionPane.showMessageDialog(null,"\"O temor do Senhor \u00E9 o princ\u00EDpio do \n saber, mas os loucos desprezam\n a sabedoria e o ensino.\"\n (Prov\u00E9rbios 1:7)\n\n"+
				"Emocionante Jogo da Forca vers\u00E3o: 1.1\nAutor:  Felipe Lino IME/UERJ\nE-mail: felipelino44@gmail.com"+
				"\nRio de Janeiro, 12 de Mar\u00E7o de 2005");
	}
	
	void msgPontuacao()
	{
		tela.adicionarTexto(strPontuacao);
		tela.addWindowListener(new FechaJanela());
		tela.ok.addActionListener(this);
		tela.show();
	}
	
	void desabilitaBotoes()
	{
		this.mapCharButton.entrySet().stream().forEach(characterJButtonEntry -> { characterJButtonEntry.getValue().setEnabled(false); });
		palavra.setEnabled(false);
		ok.setEnabled(false);
	}
	
	void habilitaBotoes()
	{
		this.mapCharButton.entrySet().stream().forEach(characterJButtonEntry -> { characterJButtonEntry.getValue().setEnabled(true); });
		
		palavra.setEnabled(true);
		ok.setEnabled(true);
	}
	
	/* metodo main */
	public static void main(String args[])
	{
		TelaJogo janela = new TelaJogo();
		janela.addWindowListener(new CloseWindowAndExit());
		janela.addKeyListener(janela);
		janela.show();
	}
	
}
