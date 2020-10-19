package steps;

import static org.junit.Assert.assertEquals;

import org.junit.Assert.*;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.*;
import com.jayway.restassured.response.Response;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.jupiter.api.*;




public class form_api_steps {
	
	private static String path;
	private Response response;
	
	private static String formulario = "{\r\n" + 
			"\"codigo\": 0,\r\n" + 
			"\"nome\": \"Aeqef Rommel Vonxswcwiuu\",\r\n" + 
			"\"cpf\": \"91310878908\",\r\n" + 
			"\"enderecos\": [\r\n" + 
			"{\r\n" + 
			"\"logradouro\": \"Rua Alexandre Dumas\",\r\n" + 
			"\"numero\": 123,\r\n" + 
			"\"complemento\": \"Empresa\",\r\n" + 
			"\"bairro\": \"Chacara Santo Antonio\",\r\n" + 
			"\"cidade\": \"São Paulo\",\r\n" + 
			"\"estado\": \"SP\"\r\n" + 
			"}\r\n" + 
			"],\r\n" + 
			"\"telefones\": [\r\n" + 
			"{\r\n" + 
			"\"ddd\": \"31\",\r\n" + 
			"\"numero\": \"981964690\"\r\n" + 
			"}]\r\n" + 
			"}";
	 
	 @BeforeAll
	    public static void setConfig() {
	        RestAssured.baseURI = "http://localhost:8080";
	        path = "/pessoas";
	 }

	 @Test
	 
	
	@Dado("^o endereço da APi para cadastro$")
	public void o_endereço_da_APi_para_cadastro() throws Throwable {
		 RestAssured.baseURI = "http://localhost:8080";
	        path = "/pessoas";  	   
	}

	@Quando("^realizar uma requisição para cadastrar uma pessoa e seus dados$")
	public void realizar_uma_requisição_para_cadastrar_uma_pessoa_e_seus_dados() throws Throwable {
		Response createUser = given()
				 .header("Accept", ContentType.JSON.getAcceptHeader())
	                .contentType("application/json;charset=UTF-8")
	                .body(formulario)
	                .post(path)
	                .then().extract().response();
		            Assertions.assertEquals(201, createUser.getStatusCode());
		            String cpf = createUser.jsonPath().get("cpf");
		            Assertions.assertEquals("91310878908", cpf); 
	}

	@Entao("^a APi deve retornar o cadastro da pessoa respondendo o código$")
	public void a_APi_deve_retornar_o_cadastro_da_pessoa_respondendo_o_código() throws Throwable {
		String cpf = response.jsonPath().get("cpf");
        Assertions.assertEquals("91310878908", cpf);          
	}

}
