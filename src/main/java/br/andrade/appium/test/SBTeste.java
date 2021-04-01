package br.andrade.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.page.MenuPage;
import br.andrade.appium.page.seuBarriga.SBContasPage;
import br.andrade.appium.page.seuBarriga.SBHomePage;
import br.andrade.appium.page.seuBarriga.SBLoginPage;
import br.andrade.appium.page.seuBarriga.SBMenuPage;
import br.andrade.appium.page.seuBarriga.SBMovimentacaoPage;
import br.andrade.appium.page.seuBarriga.SBResumoPage;

public class SBTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();
	
	@Before
	public void setup() {
		menu.acessarSBNativo();
		login.setEmail("laercio@teste");
		login.setSenha("123");
		login.entrar();
	}
	
	@Test
	public void InserirConta() {
		//Passo01: Acessar Contas
		menuSB.acessarContas();
		
		//Passo02: Digitar Nome Conta
		contas.setConta("Conta de Teste");
		
		
		//Passo03: Salvar
		contas.salvar();
		
		
		//Passo04: Verificar Mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
	
	@Test 
	public void ExcluirConta() {
		//Passo01: Acessar Contas
		menuSB.acessarContas();
		
		//Passo02: Clique Longo na Conta
		contas.selecionarConta("A");
		
		//Passo03: Excluir
		contas.excluir();
		
		//Verificar Mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta exclu�da com sucesso"));
		
	}
	
	@Test
	public void IncluirMovimentacao() {
		//Passo01: acessar tela de movimenta��es
		menuSB.acessarMovimentacoes();
		
		//Passo02: validar descri��o
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Descri��o � um campo obrigat�rio"));
		
		//Passo03: validar interessado
		mov.setDescri��o("Desc");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Interessado � um campo obrigat�rio"));
		
		//Passo04: validar valor
		mov.setInteressado("interess");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Valor � um campo obrigat�rio"));
		
		//Passo05 validar conta
		mov.setValor("500");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Conta � um campo obrigat�rio"));
		
		//Passo06: inserir com sucesso
		mov.setConta("Conta de Teste");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Movimenta��o cadastrada com sucesso"));
		
	
	}
	
	@Test
	public void deveAtualizarSoldoAoExcluirMovimentacao() {
		//Passo01: Verificar saldo Conta para saldo = 354.00
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
				
		//Ir para resumo
		menuSB.acessarResumo();
		
		//Excluir Movimentacao 3
		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
		
		//Validar a mensagem "Movimenta��o removida com sucesso"
		Assert.assertTrue(resumo.existeElementoPorTexto("Movimenta��o removida com sucesso!"));
		
		//voltar home
		menuSB.acessarHome();
		
		//atualizar saldos
		esperar(1000);
		home.scroll(0.2, 0.9);
		
		//verificar saldo = -1000
		Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
	}
}
