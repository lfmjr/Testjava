#language: pt

Funcionalidade: Validar cadastro via APi

	Cenario: Cadastrar um cliente novo
  
    Dado o endereço da APi para cadastro
    Quando realizar uma requisição para cadastrar uma pessoa e seus dados
    Entao o código de status da resposta deve ser 201
		
	Cenario: Cadastrar um cliente com CPF já cadastrado
		
		Dado o endereço da APi para cadastro
    Quando realizo o cadastro com um CPF já cadastrado
    Entao a APi não deve permitir cadastrar duas pessoas com o mesmo CPF
	
	Cenario: Cadastrar um cliente com telefone já cadastrado	
		
		Dado o endereço da APi para cadastro
    Quando realizo o cadastro com um telefone já cadastrado
    Entao a APi não deve permitir duas pessoas com o mesmo telefone
