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

	@Quando("^eu envio o número do telefone não cadastrado$")
	public void eu_envio_o_número_do_telefone_não_cadastrado() throws Throwable {
		RequestSpecification request = RestAssured.given(); 
		request.header("Content-Type", "application/json");
		 response = request.get("http://localhost:8080/pessoas/11/981388366");
	}

	@Entao("^deve retornar a consulta$")
	public void envia_a_mensagem() throws Throwable {
		String body = response.asString();
		 int jsonString = response.getStatusCode();
	    Assert.assertEquals(404, jsonString);
	    Assert.assertEquals("{\"erro\":\"Não existe pessoa com o telefone (11)981388366\"}", body);
	}

}
