package steps;

import org.junit.Assert;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class form_consult_steps {
	
	private static final String BASE_URL = "http://localhost:8080/pessoas/";
	 private static Response response;
	 private static String body;
	

	 @Test
	
	@Dado("^o endereço da APi de consulta$")
	public void o_endereço_da_APi_de_consulta() throws Throwable {
		 RestAssured.baseURI = BASE_URL;
			RequestSpecification request = RestAssured.given();
	}
	
	@Quando("^eu envio o número do telefone inexistente$")
	public void eu_envio_o_número_do_telefone_inexistente() throws Throwable {
		RequestSpecification request = RestAssured.given(); 
		request.header("Content-Type", "application/json");
		 response = request.get("http://localhost:8080/pessoas/11/981388366");
	}
	
	@Quando("^eu envio o número do telefone cadastrado no sistema$")
	public void eu_envio_o_número_do_telefone_cadastrado_no_sistema() throws Throwable {
		RequestSpecification request = RestAssured.given(); 
		request.header("Content-Type", "application/json");
		 response = request.get("http://localhost:8080/pessoas/16/981364693");
	}

	
	@Entao("^deve retornar erro quando buscar pessoa por telefone inexistente$")
	public void deve_retornar_erro_quando_buscar_pessoa_por_telefone_inexistente() throws Throwable {
		String body = response.asString();
		 int jsonString = response.getStatusCode();
	    Assert.assertEquals(404, jsonString);
	    Assert.assertEquals("{\"erro\":\"Não existe pessoa com o telefone (11)981388366\"}", body);
	}

	@Entao("^deve retornar o código (\\d+)$")
	public void deve_retornar_o_código(int code) throws Throwable {
		 int jsonString = response.getStatusCode();
	    Assert.assertEquals(code, jsonString);
	
	}
	

}
