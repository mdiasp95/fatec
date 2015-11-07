package br.sceweb.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		
		empresaDAO.exclui("89424232000180");
		
		empresa.setNomeDaEmpresa("Empresa X");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("X");
		empresa.setEndereco("Rua ABC, 23");
		empresa.setTelefone("2222");
		empresaDAO.adiciona(empresa);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}

	@Test
	public void Consultar_Empresa_Com_Sucesso() {
		//73688761000151 cnpj valido
		//15595638000190
		assertTrue(empresa.equals(empresaDAO.consultaEmpresas("89424232000180")));
	}

	@Test
	public void Consultar_Lista_De_Empresas_Com_Sucesso() {
		assertTrue(!empresaDAO.consultaEmpresas().isEmpty());
		assertTrue(empresaDAO.consultaEmpresas().size() != 0);
		
	}

}
