package com.ies.poo.gustavo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Testes {
	private Jogador lucas;
	private Jogador nilo;
	private Jogador baiano;
	private Jogador luiz;
	private Jogo tictactoe;
	
	@Before
	public void configuracao() {
		lucas = new Jogador("Lucas");
		nilo = new Jogador("Nilo");
		baiano = new Jogador("Baiano");
		luiz = new Jogador("Luiz");
		
		tictactoe = new Jogo();
	}
	
	@Test
	public void iniciandoOJogo() throws Exception {
		Tabuleiro tabuleiro = tictactoe.obterTabuleiro();
		assertEquals(9, tabuleiro.obterCasas().size());
	}
	
	@Test
	public void jogadorUmOpcaoXis() throws Exception {
		Opcoes opcaoDoJogadorUm = tictactoe.registrarJogador(baiano);
		assertEquals(Opcoes.XIS, opcaoDoJogadorUm);
	}
	
	@Test
	public void jogadorDoisOpcaoBolinha() throws Exception {
		Opcoes opcaoDoJogadorUm = tictactoe.registrarJogador(baiano);
		Opcoes opcaoDoJogadorDois = tictactoe.registrarJogador(lucas);
		assertEquals(Opcoes.BOLINHA, opcaoDoJogadorDois);
		assertNotEquals(Opcoes.BOLINHA, opcaoDoJogadorUm);
	}
	
	@Test
	public void vencedorXis() throws Exception {
		Opcoes opcaoDoJogadorUm = tictactoe.registrarJogador(baiano);
		Opcoes opcaoDoJogadorDois = tictactoe.registrarJogador(lucas);
		
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterPrimeiraCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterSegundaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterQuintaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterNonaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterSetimaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterQuartaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterTerceiraCasa());
		
		assertEquals(Opcoes.XIS, tictactoe.obterOpcaoVencedora());
	}
	
	@Test
	public void vencedorBolinha() throws Exception {
		Opcoes opcaoDoJogadorUm = tictactoe.registrarJogador(nilo);
		Opcoes opcaoDoJogadorDois = tictactoe.registrarJogador(baiano);
		
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterNonaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterSegundaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterOitavaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterSetimaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterSextaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterQuartaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterPrimeiraCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterQuintaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterTerceiraCasa());
		
		assertEquals(Opcoes.BOLINHA, tictactoe.obterOpcaoVencedora());
	}
	
	@Test
	public void jogoTerminaEmpatado() throws Exception {
		Opcoes opcaoDoJogadorUm = tictactoe.registrarJogador(nilo);
		Opcoes opcaoDoJogadorDois = tictactoe.registrarJogador(luiz);
		
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterQuartaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterPrimeiraCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterTerceiraCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterSetimaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterQuintaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterSextaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterOitavaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterSegundaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterNonaCasa());
		
		assertNull(tictactoe.obterResultado());
		
	}
	
	@Test
	public void verificandoOpcaoDerrotada() throws Exception {
		Opcoes opcaoDoJogadorUm = tictactoe.registrarJogador(lucas);
		Opcoes opcaoDoJogadorDois = tictactoe.registrarJogador(luiz);
		
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterSegundaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterQuintaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterQuartaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterOitavaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterPrimeiraCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterSetimaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterTerceiraCasa());
		
		assertEquals(Opcoes.BOLINHA, tictactoe.obterOpcaoDerrotada());
	}
	
	@Test
	public void verificandoJogadorPerdedor() throws Exception {
		Opcoes opcaoDoJogadorUm = tictactoe.registrarJogador(baiano);
		Opcoes opcaoDoJogadorDois = tictactoe.registrarJogador(luiz);
		
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterPrimeiraCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterSegundaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterQuintaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterNonaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterSetimaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterTerceiraCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterQuartaCasa());
		
		assertEquals(baiano, tictactoe.obterJogadorPerdedor());
	}
	
	@Test
	public void verificandoJogadorVencedor() throws Exception {
		Opcoes opcaoDoJogadorUm = tictactoe.registrarJogador(baiano);
		Opcoes opcaoDoJogadorDois = tictactoe.registrarJogador(nilo);
		
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterPrimeiraCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterSetimaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterQuintaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterNonaCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterOitavaCasa());
		tictactoe.jogar(opcaoDoJogadorDois, tictactoe.obterTabuleiro().obterTerceiraCasa());
		tictactoe.jogar(opcaoDoJogadorUm, tictactoe.obterTabuleiro().obterSegundaCasa());
		
		assertEquals(tictactoe.obterRegras().get(4), tictactoe.obterRegraVencedora());
		assertEquals(opcaoDoJogadorUm, tictactoe.obterOpcaoVencedora());
		assertEquals(baiano, tictactoe.obterJogadorVencedor());
	}
	
	@Test
	public void testeARegraVerticalMeio() throws Exception {
		List<Regra> regras = tictactoe.obterRegras();
		Tabuleiro obterTabuleiro = tictactoe.obterTabuleiro();
		assertEquals(8, regras.size());
		assertEquals(obterTabuleiro.obterSegundaCasa(), regras.get(4).obterCasaUm());
		assertEquals(obterTabuleiro.obterQuintaCasa(), regras.get(4).obterCasaDois());
		assertEquals(obterTabuleiro.obterOitavaCasa(), regras.get(4).obterCasaTres());
	}
	
}