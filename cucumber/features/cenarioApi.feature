#language: pt


Funcionalidade: Cadastrar pela APi

  Cenario: Validar a consulta via APi
  
    Dado o endereço da APi para cadastro
    Quando realizar uma requisição para cadastrar uma pessoa e seus dados
    Entao a APi deve retornar o cadastro da pessoa respondendo o código

  Cenario: Consultar cliente pelo número de telefone não cadastrado
						
	Dado o endereço da APi de consulta
	Quando eu envio o número do telefone não cadastrado
	Entao deve retornar a consulta