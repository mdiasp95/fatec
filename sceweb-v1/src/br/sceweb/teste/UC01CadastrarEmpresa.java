package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Controle;
import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	static Controle controle;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		controle = new Controle();
		
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		empresaDAO.exclui("89424232000180");
		assertEquals(1, empresaDAO.adiciona(empresa));
		empresaDAO.exclui("89424232000180");
	}

	@Test(expected = RuntimeException.class)
	public void CT02UC01A2Cadastra_empresa_cnpj_ja_cadastrado(){
		empresaDAO.adiciona(empresa);
		assertEquals(0, empresaDAO.adiciona(empresa));		
	}
	
	@Test
	public void CT03UC01A3Cadastra_empresa_cnpj_invalido(){
		Empresa empresa2 = new Empresa();
		
		try {
			empresa2.setCnpj("894242320001800");

			fail("deveria disparar uma exception");	
		} catch (Exception e) {
			assertEquals("CNPJ inválido!", e.getMessage());
		}
	}

	@Test
	public void CT04UC01Cadastra_Empresa_Atraves_Controle(){
		controle.excluirEmpresa("73688761000151");
		controle.cadastrarEmpresa("73688761000151", "Empresa Y", "Y", "Rua xyz", "2323-4455");
		controle.excluirEmpresa("73688761000151");	
	}
	
	@Test
	public void CT05UC01Cadastra_Empresa_Nome_Em_Branco(){
		Empresa empresa02 = new Empresa();
		
		try {
			empresa02.setNomeDaEmpresa("");
		} catch (Exception e) {

		}
		
	}
}
