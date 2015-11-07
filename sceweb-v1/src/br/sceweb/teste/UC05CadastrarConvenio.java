package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.*;

import br.sceweb.modelo.Convenio;
import br.sceweb.modelo.ConvenioDao;

public class UC05CadastrarConvenio {

	static ConvenioDao convenioDao;
	static Convenio convenio;
	static String dataInicio;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		convenioDao = new ConvenioDao();
		convenio = new Convenio();
		// datainicio = "29/10/2015";
	}

	@Test
	public void CT01UC05CadastrarConvenio_com_sucesso_data_valida() {
		dataInicio = "29/10/2015";
		assertTrue(convenio.validaData(dataInicio));
	}

	@Test
	public void CT02UC05CadastrarConvenio_com_data_invalida() {
		dataInicio = "42/04/2015";
		assertFalse(convenio.validaData(dataInicio));
	}

	@Test
	public void CT03UC05CadastrarConvenio_com_sucesso_data_valida() {
		dataInicio = "29/10/2015";
		convenio.setDataInicio(dataInicio);
		assertTrue(dataInicio.equals(convenio.getDataInicio()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void CT04UC05CadastrarConvenio_com_data_invalida() {
		convenio.setDataInicio("242/10/2015");
	}

	@Test 

	 public void CT05UC05CadastrarConvenio_com_sucesso() { 
		convenioDao.adiciona(convenio); 
		assertTrue (convenioDao.adiciona(convenio)); 
		convenioDao.exclui(convenio.getCnpj()); 
	 }

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

}
