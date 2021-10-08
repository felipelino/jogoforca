package br.uerj.hangman.game; /**
 * Ultima atualizacao 10/01/2005 - 16:09
 * Autor: Felipe Goncalves de Oliveira Lino
 * Programa: Jogo da br.uerj.hangman.game.Forca - Classe br.uerj.hangman.game.Forca.java
 * 
 * Contem os metodos Principais do funcionamento do 
 * jogo.
 *
 */

import java.util.*;
public class Forca 
{
	private String escolhida;
	private int tam_esc=0;
	private int acerto=0;
	private int erro=0;
	private int divisor=2;
	private LinkedList<Boolean> verdade = new  LinkedList<Boolean>();
	private LinkedList<Boolean> usadas = new LinkedList<Boolean>();
	
	Forca(String temp) //palavra digitada pelo usuario
	{
		escolhida=temp;
		tam_esc=escolhida.length();
		inicializa();
	}
	
	Forca() // faz o sorteio da palavra
	{
		LinkedList banco=new LinkedList();
		int sorteio=0;
		Random randomico = new Random();
	
		banco.add("PALAVRA");
		banco.add("BICICLETA");
		banco.add("MOTOCICLETA");
		banco.add("INTEGRADO");
		banco.add("UNIVERSIDADE");
		banco.add("PORTARIA");
		banco.add("FLORICULTOR");
		banco.add("LARANJEIRA");
		banco.add("SERTANEJO");
		banco.add("TRITURADOR");
		banco.add("SALVADOR");
		banco.add("ARMAMENTO");
		banco.add("SOLDADO");
		banco.add("GEOGRAFIA");
		banco.add("GEOLOGIA");
		banco.add("MATEMATICA");
		banco.add("PORTUGUES");
		banco.add("TRABALHO");
		banco.add("SERINGUEIRA");
		banco.add("HARPA");
		banco.add("ELEFANTE");
		banco.add("GIRAFA");
		banco.add("PANTERA");
		banco.add("INCONSTITUCIONAL");
		banco.add("PROMESSA");
		banco.add("INACREDITAVEL");
		banco.add("INCRIVEL");
		banco.add("IMPORTANTE");
		banco.add("AVENTAL");
		banco.add("AVESTRUZ");
		banco.add("IGNORANTE");
		banco.add("GUILHOTINA");
		banco.add("ESPINGARDA");
		banco.add("LAPISEIRA");
		banco.add("JOGADORA");
		banco.add("MANDIBULA");
		banco.add("OREGANO");
		banco.add("MANTEIGA");
		banco.add("MARGARINA");
		banco.add("FLORICULTURA");
		banco.add("EMOCIONANTE");
		banco.add("APONTADOR");
		banco.add("CRIOULO");
		banco.add("BARALHO");
		banco.add("BOTEQUIM");
		banco.add("SOL");
		banco.add("BAR");
		banco.add("PE");
		banco.add("FE");
		banco.add("FIDELIDADE");
		banco.add("FRIGORIFICO");
		banco.add("FRAGILIDADE");
		banco.add("FRACASSO");
		banco.add("APROVEITAR");
		banco.add("AZULEJO");
		banco.add("ZOMBETEIRO");
		banco.add("ZUMBIDO");
		banco.add("XERIFE");
		banco.add("XINGAR");
		banco.add("XIXI");
		banco.add("VELHARIA");
		banco.add("TRAPACEIRO");
		banco.add("TRAPEZIO");
		banco.add("TRILOGIA");
		banco.add("SENHOR");
		banco.add("ANEIS");
		banco.add("DISCOTECA");
		banco.add("DANCETERIA");
		banco.add("TRATAMENTO");
		banco.add("ENGENHARIA");
		banco.add("ENFERMARIA");
		banco.add("ENGRENAGEM");
		banco.add("ENTREGA");
		banco.add("ANTA");
		banco.add("CAMELO");
		banco.add("CARAMELO");
		banco.add("TARTARUGA");
		banco.add("PARALELEPIPEDO");
		banco.add("IMPREVISIVEL");
		banco.add("IMPREVISTO");
		banco.add("REDEMOINHO");
		banco.add("DICIONARIO");
		banco.add("QUANTIDADE");
		banco.add("PRODUTO");
		banco.add("MONTANHA");
		banco.add("MEDICO");
		banco.add("MEDICINA");
		banco.add("LIMPEZA");
		banco.add("LINGUAGEM");
		banco.add("LITERATURA");
		banco.add("JUVENTUDE");
		banco.add("JACARE");
		banco.add("JAQUETA");
		banco.add("RESPONSABILIDADE");
		banco.add("INDEPENDENTE");
		banco.add("CONSAGRADO");
		banco.add("ESPIRITO");
		banco.add("HEXAGONO");
		banco.add("HISTORIA");
		banco.add("GUITARRA");
		banco.add("CARRO");
		banco.add("CIRCO");
		banco.add("GOLFINHO");
		banco.add("PAGODE");
		banco.add("PADARIA");
		banco.add("ORTOGRAFIA");
		banco.add("ALFABETO");
		banco.add("ORELHA");
		banco.add("SABADO");
		banco.add("DOMINGO");
		banco.add("FEIRA");
		banco.add("FREIRA");
		banco.add("CONSTRUTOR");
		banco.add("CALCULO");
		banco.add("COMPUTADOR");
		banco.add("INFORMATICA");
		banco.add("ESCADA");
		banco.add("ESCOVA");
		banco.add("ESTOMAGO");
		banco.add("ESQUISITO");
		banco.add("QUEIJO");
		banco.add("DENTADURA");
		banco.add("PA");
		banco.add("GELADEIRA");
		banco.add("GELATINA");
		banco.add("FERRADURA");
		banco.add("TRANSATLANTICO");
		banco.add("OCEANOGRAFO");
		banco.add("OCEANOGRAFIA");
		banco.add("TRANSPORTADORA");
		banco.add("LIXEIRA");
		banco.add("CROCODILO");
		banco.add("SERPENTE");
		banco.add("CARAMUJO");
		banco.add("CARACOL");
		banco.add("MAMADEIRA");
		banco.add("PULSEIRA");
		banco.add("COMPASSO");
		banco.add("DESODORANTE");
		banco.add("PERFUME");
		banco.add("BANDEIRA");
		banco.add("TRINCHEIRA");
		banco.add("HOTEL");
		banco.add("RIO");
		banco.add("MAR");
		banco.add("CHINELO");
		banco.add("DINHEIRO");
		banco.add("MARTELO");
		banco.add("MARUJO");
		banco.add("MARINHEIRO");
		banco.add("FORMIGA");
		banco.add("CADEIA");
		banco.add("MEL");
		banco.add("HELICOPTERO");
		banco.add("ARARA");
		banco.add("ASTRONAUTA");
		banco.add("ASTROLOGIA");
		banco.add("FISIOTERAPEUTA");
		banco.add("FISIOTERAPIA");
		banco.add("PSQUIATRIA");
		banco.add("PSICOLOGIA");
		banco.add("PNEUMATICO");
		banco.add("BORRACHARIA");
		banco.add("BOMBOM");
		banco.add("FLECHA");
		banco.add("TELEVISOR");
		banco.add("AUTOMOVEL");
		banco.add("KIBE");
		banco.add("CARTOLINA");
		banco.add("MERCADORIA");
		banco.add("MOTORISTA");
		banco.add("RADIALISTA");
		banco.add("DENTISTA");
		banco.add("ATOR");
		banco.add("ATRIZ");
		banco.add("COMPOSITOR");
		banco.add("COR");
		banco.add("AQUARELA");
		banco.add("PROGRAMADOR");
		banco.add("CORREIO");
		banco.add("PSCINA");
		banco.add("FOTOGRAFIA");
		banco.add("ORGANOGRAMA");
		banco.add("ORGANISMO");
		banco.add("RATOEIRA");
		banco.add("RINOCERONTE");
		banco.add("BOI");
		banco.add("CHUVEIRO");
		banco.add("CHAVEIRO");
		banco.add("URSO");
		banco.add("SAPO");
		banco.add("SORRISO");
		banco.add("LIMOEIRO");
		banco.add("PALMEIRA");
		banco.add("COQUEIRO");
		banco.add("PIZZA");
		banco.add("SALADA");
		banco.add("ROUPA");
		banco.add("CAMISA");
		banco.add("CAMISETA");
		banco.add("BERMUDA");
		banco.add("BRINCO");
		banco.add("SAIA");
		banco.add("PERUCA");
		banco.add("TOUCA");
		banco.add("CASACO");
		banco.add("SAPATO");
		banco.add("SANDALIA");
		banco.add("DESQUALIFICADO");
		banco.add("BLUSA");
		banco.add("CORRENTE");
		banco.add("BOLSA");
		banco.add("CINZEIRO");
		banco.add("CINTO");
		banco.add("CADEADO");
		banco.add("FECHADURA");
		banco.add("BALCONISTA");
		banco.add("RECEPCIONISTA");
		banco.add("RESTAURANTE");
		banco.add("TATUAGEM");
		banco.add("VIDEOCASSETE");
		banco.add("VIDEOGAME");
		banco.add("BIBLIOTECA");
		banco.add("LIVRARIA");
		banco.add("JORNAL");
		banco.add("TIGRE");
		banco.add("LEOPARDO");
		banco.add("HOMEM");
		banco.add("MULHER");
		banco.add("NATUREZA");
		banco.add("ESGRIMA");
		banco.add("FUTEBOL");
		banco.add("BASQUETE");
		banco.add("VOLEI");
		banco.add("CINEASTA");
		banco.add("CINEMA");
		banco.add("FILME");
		banco.add("CANTOR");
		banco.add("ARCO");
		banco.add("BARCO");
		banco.add("CANOA");
		banco.add("JANGADA");
		banco.add("LUZ");
		banco.add("NUVEM");
		banco.add("TECLADO");
		banco.add("VIOLONCELO");
		banco.add("VIOLINO");
		banco.add("TIJOLO");
		banco.add("JOALHERIA");
		banco.add("CAMINHONETE");
		banco.add("VEICULO");
		banco.add("JOELHO");
		banco.add("PERNA");
		banco.add("CABELO");
		banco.add("DEDO");
		banco.add("UNHA");
		banco.add("COTOVELO");
		banco.add("BOLA");
		banco.add("BOLICHE");
		banco.add("GOLFE");
		banco.add("HOQUEI");
		banco.add("CORNETA");
		banco.add("TROMBONE");
		banco.add("TROMPETE");
		banco.add("FLAUTA");
		banco.add("GAITA");
		banco.add("GATO");
		banco.add("CACHORRO");
		banco.add("RATO");
		banco.add("RATAZANA");
		banco.add("FEITICEIRA");
		banco.add("BRUXARIA");
		banco.add("RAPOSA");
		banco.add("SARGENTO");
		banco.add("MAJOR");
		banco.add("BRIGADEIRO");
		banco.add("SORVETE");
		banco.add("RECRUTA");
		banco.add("CORONEL");
		banco.add("GENERAL");
		banco.add("ESCRITORIO");
		banco.add("SECRETARIA");
		banco.add("LUVA");
		banco.add("LUNETA");
		banco.add("BINOCULO");
		banco.add("OCULOS");
		banco.add("MICROSCOPIO");
		banco.add("OSTETOSCOPIO");
		banco.add("FORNO");
		banco.add("AZEITONA");
		banco.add("AZEITE");
		banco.add("MORANGO");
		banco.add("BANANA");
		banco.add("LARANJA");
		banco.add("BANANEIRA");
		banco.add("JABUTICABEIRA");
		banco.add("JABUTICABA");
		banco.add("LITORAL");
		banco.add("BALEIA");
		banco.add("DINOSSAURO");
		banco.add("ARQUEOLOGIA");
		banco.add("NINHO");
		banco.add("GALINHA");
		banco.add("GALO");
		banco.add("PATO");
		banco.add("PEROLA");
		banco.add("TESOURO");
		banco.add("TESOURA");
		banco.add("PASTEL");
		banco.add("PASTELARIA");
		banco.add("PAPELARIA");
		banco.add("PAPEL");
		banco.add("LIVRO");
		banco.add("ESPADA");
		banco.add("ESPADACHIM");
		banco.add("ESPIONAGEM");
		banco.add("TINTURARIA");
		banco.add("TINTUREIRO");
		banco.add("COSTUREIRA");
		banco.add("CUSTURA");
		banco.add("LOCOMOTIVA");
		banco.add("TREM");
		banco.add("INTERVALO");
		banco.add("INTERNACIONALIDADE");
		banco.add("INTERNACIONAL");
		banco.add("NACIONALIDADE");
		banco.add("NACIONAL");
		banco.add("PISTOLA");
		banco.add("REVOLVER");
		banco.add("REVOLTA");
		banco.add("TEMPESTADE");
		banco.add("TERRESTRE");
		banco.add("AQUATICO");
		banco.add("AEREO");
		banco.add("VIAJANTE");
		banco.add("VILAREJO");
		banco.add("LUGAREJO");
		banco.add("ESTRANGEIRO");
		banco.add("IDIOMA");
		banco.add("LINGUA");
		banco.add("CONTINENTE");
		banco.add("INTERCONTINENTAL");
		banco.add("CONTINENTAL");
		banco.add("LINGUAGEM");
		banco.add("BARRIL");
		banco.add("DESINFETANTE");
		banco.add("DETERGENTE");
		banco.add("SANEAMENTO");
		banco.add("DISQUETE");
		banco.add("ZEBRA");
		banco.add("CONTABILIDADE");
		banco.add("SHOW");
		banco.add("HIEROSOLIMITANO");
		banco.add("SOTEROPOLITANO");
		banco.add("AMBULATORIO");
		banco.add("ARQUIPELAGO");
		banco.add("ATRAPALHADO");
		banco.add("AZUCRINANTE");
		banco.add("ASTIGMATISMO");
		banco.add("BACTERIOLOGISTA");
		banco.add("BACTERIOLOGIA");
		banco.add("BERIMBAU");
		banco.add("BIJUTERIA");
		banco.add("BIBLIOGRAFIA");
		banco.add("BIOQUIMICO");
		banco.add("BISBILHOTEIRO");
		banco.add("ABELHUDO");
		banco.add("BIODEGRADAVEL");
		banco.add("BUROCRACIA");
		banco.add("CAATINGA");
		banco.add("CALEIDOSCOPIO");
		banco.add("CAMARADAGEM");
		banco.add("CARDIOLOGISTA");
		banco.add("FRATERNIDADE");
		banco.add("CHIQUEIRO");
		banco.add("QUEIJO");
		banco.add("CIBERNETICO");
		banco.add("CINEGRAFISTA");
		banco.add("CINEMATOGRAFIA");
		banco.add("MATO");
		banco.add("JATO");
		banco.add("CURINGA");
		banco.add("CROMOSSOMO");
		banco.add("CRONOMETRAGEM");
		banco.add("DESCARACTERIZADO");
		banco.add("ENERGUMENO");
		banco.add("FLUORESCENTE");
		banco.add("GNOMO");
		banco.add("GLUTONARIA");
		banco.add("EFERVESCENTE");
		banco.add("ELETROCARDIOGRAMA");
		banco.add("ELETROMAGNETISMO");
		banco.add("EMAGRECIMENTO");
		banco.add("ELETROSTATICA");
		banco.add("ELETROTECNIA");
		banco.add("EMPREENDIMENTO");
		banco.add("EXTRATERRITORIAL");
		banco.add("EXTRATERRESTRE");
		banco.add("EXTROVERTIDO");
		banco.add("EXTRAVAGANTE");
		banco.add("EXTRAMATRIMONIAL");
		banco.add("EXTRAORDINARIO");
		banco.add("FANTASMAGORICO");
		banco.add("FILMOTECA");
		banco.add("FRUTICULTURA");
		banco.add("GAFANHOTO");
		banco.add("PERNILONGO");
		banco.add("GIRASSOL");
		banco.add("GUAXINIM");
		banco.add("HALTEROFILISMO");
		banco.add("HALTERIFILISTA");
		banco.add("HARMONIOSO");
		banco.add("HELIOCENTRISMO");
		banco.add("HEREDITARIEDADE");
		banco.add("HIDROMINERAL");
		banco.add("HIPOTENUSA");
		banco.add("CATETO");
		banco.add("HIEROGLIFO");
		banco.add("HIEROSOLIMITA");
		banco.add("HIDROSFERICO");
		banco.add("HIENA");
		banco.add("HIEROGLIFO");
		banco.add("HILARIANTE");
		banco.add("HIPERSENSIBILIDADE");
		banco.add("HINDUISMO");
		banco.add("HIPNOTIZAVEL");
		banco.add("HORRIPILANTE");
		banco.add("HUMANITARIO");
		banco.add("IMPERECEDOURO");
		banco.add("IMORTALIDADE");
		banco.add("IMPERCEPTIBILIDADE");
		banco.add("INACESSIBILIDADE");
		banco.add("INCOMPATIBILIDADE");
		banco.add("INVEROSSIMIL");
		banco.add("JERIMU");
		banco.add("JUJUTSU");
		banco.add("JENIPAPEIRO");
		banco.add("UNIFORME");
		banco.add("UTILITARISMO");
		banco.add("VEGETOMINERAL");
		banco.add("XAMPU");
		banco.add("XAROPE");
		banco.add("XAVECO");
		banco.add("ZARABATANA");
		banco.add("ZOOLOGICO");
		banco.add("VOCABULARIO");
		banco.add("REVEZAMENTO");
		banco.add("RELOJOEIRO");
		banco.add("RELOJOARIA");
		banco.add("MISERICORDIA");
		banco.add("MATRIMONIAL");
		banco.add("LOMBRIGUEIRO");
		banco.add("LESGISLATURA");
		banco.add("LEGISLATIVO");
		banco.add("HISTORIOGRAFO");
		banco.add("HISTORICIDADE");
		banco.add("HISTORIOGRAFIA");
		banco.add("GALAXIA");
		banco.add("LAGARTIXA");
		banco.add("CARANGUEJO");
		banco.add("CARANGUEJEIRA");
		banco.add("CARBOIDRATO");
		banco.add("BOTA");
		banco.add("JOVIALIDADE");
		banco.add("JURISPRUDENTE");
		banco.add("JUSTIFICAVEL");
		banco.add("KUWAITIANO");
		banco.add("KUWAITI");
		banco.add("LADRILHEIRO");
		banco.add("LUMBAGO");
		banco.add("MACHUCADURA");
		banco.add("MACROCEFALIA");
		banco.add("MALCRIADO");
		banco.add("MAQUIAVELICO");
		banco.add("MASCULINIDADE");
		banco.add("MEQUETREFE");
		banco.add("METRALHADORA");
		banco.add("MIMEOGRAFO");
		banco.add("MOMENTANEO");
		banco.add("MONSTRUOSIDADE");
		banco.add("MULTIMILENARIO");
		banco.add("NAMORADEIRA");
		banco.add("NUTRICIONISTA");
		banco.add("OBRIGATORIEDADE");
		banco.add("OCTOGENARIO");
		banco.add("ONOMATOPEIA");
		banco.add("OTORRINOLARINGOLOGIA");
		banco.add("ORQUESTRA");
		banco.add("PAISAGISTICA");
		banco.add("PANFLETARIO");
		banco.add("PARAPSICOLOGIA");
		banco.add("PETROQUIMICA");
		banco.add("PERSONALIDADE");
		banco.add("PLURIPARTIDARIO");
		banco.add("PONTIAGUDO");
		banco.add("RADIOPATRULHA");
		banco.add("QUILOMBOLA");
		banco.add("QUINQUILHARIA");
		banco.add("QUADRANGULAR");
		banco.add("PROFETICO");
		banco.add("MALETA");
				
		sorteio=Math.abs(randomico.nextInt()) % banco.size();
		
		escolhida=(String)banco.remove(sorteio);
		tam_esc=escolhida.length();
		inicializa();
	}
	
	void inicializa()
	{
		for(int i=0;i<=26;i++)
		{
			verdade.add(false);
			usadas.add(false);
		}
	}
	
	void verifica(char letra) //verifica se a letra esta na palavra
	{
		boolean retorno=true;
		if(usadas.get(letra-'A') == false)
		{
			usadas.remove(letra-'A');
			usadas.add(letra-'A',true);
			retorno=false;
			for(int i=0;i<tam_esc;i++)
			{
				if(letra==escolhida.charAt(i))
				{
					verdade.remove(i);
					verdade.add(i,true);
					retorno=true;
					acerto++;
				}
			}
			if(retorno==false)
				erro++;
		}
	}
	
	boolean verFimJogo() // verifica se o jogo terminou 
	{
		if(erro==5)
		{
			return true;
		}
		else
		{
			if(acerto==tam_esc)
				return true;
			else 
				return false;
		}
	}

	boolean verSeVenceu() //verifica se venceu o jogo
	{
		if(acerto==tam_esc)
			return true;
		else
			return false;
	}

	boolean verSeVenceu(String palavra)//verifica se venceu o jogo digitando a palavra correta
	{
		int i=0;
		String temp;
		if(palavra.startsWith(" "))
		{
			temp=palavra.substring(1,palavra.length());
			palavra=temp;
		}
		if(escolhida.equalsIgnoreCase(palavra))
		{
			acerto=tam_esc;
			divisor=1;
			return true;
		}
		else
		{
			divisor=2;
			return false;
		}
	}

	public String toString() // retorno a palvra escolhida
	{
		return escolhida;
	}
	
	int getAcerto()
	{
		return acerto;
	}
	
	int getErro()
	{
		return erro;
	}
	
	int getTamanho()
	{
		return tam_esc;
	}
	
	int getDivisor()
	{
		return divisor;
	}

	String getUsadas()
	{
		int i=0;
		String retorno="";
		
		char k;
		for(i=0;i<=26;i++)
		{
			if(usadas.get(i)== true)
			{
				k=(char)('A'+i);
				retorno=retorno+k;
			}
		}
		
		return retorno;
	}
	
	String getOculta()
	{
		int i=0;
		String retorno="";
		
		for(i=0;i<tam_esc;i++)
		{
			if(verdade.get(i) == true)
			{
				retorno=retorno+escolhida.charAt(i)+" ";
			}
			else
			{
				retorno=retorno+"_"+" ";
			}
		}
		
		return retorno;	
	}
}
