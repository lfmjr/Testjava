package steps;

import static org.junit.Assert.assertEquals;
import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.*;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.jupiter.api.*;




public class form_api_steps {
	
	private static String path;
	private Response response;
	
	private String formulario = "{\r\n" + 
			"\"codigo\": 0,\r\n" + 
			"\"nome\": \"Client 1\",\r\n" + 
			"\"cpf\": \"84337194088\",\r\n" + 
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
			"\"ddd\": \"16\",\r\n" + 
			"\"numero\": \"981364693\"\r\n" + 
			"}]\r\n" + 
			"}";
	
	private String formularioB = "{\r\n" + 
			"\"codigo\": 0,\r\n" + 
			"\"nome\": \"Client 2\",\r\n" + 
			"\"cpf\": \"82553824025\",\r\n" + 
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
			"\"ddd\": \"16\",\r\n" + 
			"\"numero\": \"981364693\"\r\n" + 
			"}]\r\n" + 
			"}";

	 @Test
	 
	
	@Dado("^o endereço da APi para cadastro$")
	public void o_endereço_da_APi_para_cadastro() throws Throwable {
		 RestAssured.baseURI = "http://localhost:8080";
	        path = "/pessoas";  	   
	}

	@Quando("^realizar uma requisição para cadastrar uma pessoa e seus dados$")
	public void realizar_uma_requisição_para_cadastrar_uma_pessoa_e_seus_dados() throws Throwable {
		 response = given()
				   .header("Accept", ContentType.JSON.getAcceptHeader())
				   .contentType("application/json;charset=UTF-8")
				   .body(formulario)
				   .post(path)
	               .then().extract().response();
	}
	
	@Quando("^realizo o cadastro com um CPF já cadastrado$")
	public void realizo_o_cadastro_com_um_CPF_já_cadastrado() throws Throwable {
		response = given()
				   .header("Accept", ContentType.JSON.getAcceptHeader())
				   .contentType("application/json;charset=UTF-8")
				   .body(formulario)
				   .post(path)
	               .then().extract().response();
	}
	
	@Quando("^realizo o cadastro com um telefone já cadastrado$")
	public void realizo_o_cadastro_com_um_telefone_já_cadastrado() throws Throwable {
		response = given()
				   .header("Accept", ContentType.JSON.getAcceptHeader())
				   .contentType("application/json;charset=UTF-8")
				   .body(formularioB)
				   .post(path)
	               .then().extract().response();
	}
	
	
	@Entao("^o código de status da resposta deve ser (\\d+)$")
	public void o_código_de_status_da_resposta_deve_ser(int code) throws Throwable {			
				Assertions.assertEquals(code, response.getStatusCode());				
	}       
	
	
	@Entao("^a APi não deve permitir cadastrar duas pessoas com o mesmo CPF$")
	public void a_APi_não_deve_permitir_cadastrar_duas_pessoas_com_o_mesmo_CPF() throws Throwable {
		String body = response.asString();
		Assert.assertEquals("{\"erro\":\"Já existe pessoa cadastrada com o CPF 84337194088\"}", body);
	    
	}


	@Entao("^a APi não deve permitir duas pessoas com o mesmo telefone$")
	public void a_APi_não_deve_permitir_duas_pessoas_com_o_mesmo_telefone() throws Throwable {
		String body = response.asString();
		Assert.assertEquals("{\"erro\":\"Já existe pessoa cadastrada com o Telefone (16)981364693\"}", body);    
	}

}
