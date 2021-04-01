package br.andrade.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.andrade.appium.core.BaseTest;
import br.andrade.appium.page.MenuPage;
import br.andrade.appium.page.seuBarriga.SBContasPage;
import br.andrade.appium.page.seuBarriga.SBLoginPage;
import br.andrade.appium.page.seuBarriga.SBMenuPage;
import br.andrade.appium.page.seuBarriga.SBMovimentacaoPage;

public class SBTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	
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
}
