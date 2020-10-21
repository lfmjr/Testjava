#language: pt


Funcionalidade: Validar as consultas por cliente pelo DDD e telefone

 
  	Cenario: Consultar cliente pelo número de telefone inexistente
						
			Dado o endereço da APi de consulta
			Quando eu envio o número do telefone inexistente
			Entao deve retornar erro quando buscar pessoa por telefone inexistente
		
	
	Cenario: Consultar cliente pelo número de telefone cadastrado no sistema
		
			Dado o endereço da APi de consulta
			Quando eu envio o número do telefone cadastrado no sistema
			Entao deve retornar o código 200
