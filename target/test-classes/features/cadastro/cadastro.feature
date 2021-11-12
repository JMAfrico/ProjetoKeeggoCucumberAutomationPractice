#language: pt
@cadastro
Funcionalidade: Cadastro de usuario
  Como usuario quero me cadastrar no site para efetuar compras

  @email_valido
  Cenario: Validar email de cadastro
    Dado que eu estou na pagina de login
    Quando informo o email para cadastro "mariazin@gmail.com"
    E seleciono a acao de criar uma conta
    Entao sou redirecionado para a tela de novo usuario
    
  @email_invalido
  Cenario: Email invalido de cadastro
    Dado que eu estou na pagina de login
    Quando informo o email "fulano" invalido
    E seleciono a acao de criar uma conta
    Entao uma mensagem de erro e mostrada
    
  @email_existente
  Cenario: Email ja existente de cadastro
    Dado que eu estou na pagina de login
    Quando informo o email "fulano@hotmail.com" que ja foi cadastrado
    E seleciono a acao de criar uma conta
    Entao uma mensagem de email ja cadastrado e mostrada
    
  @autenticao_valida
    Cenario: Autenticacao de cadastro valido
    Dado que tenho um email "joaa55112@gmail.com" valido de novo usuario 
    E que eu estou na pagina de cadastro de usuario
    Quando informo o genero "Mr."
    E informo o nome "Maria" 
    E informo o sobrenome "Silva" 
    E informo a senha "123456" 
    E informo o dia "21" de dia de nascimento 
    E informo o mes "May" de mes de nascimento 
    E informo o ano "1991" de ano de nascimento 
    E informo o endereco "Rua saltos" 
    E informo a cidade "Rio de Janeiro" 
    E informo o estado "Arizona" 
    E informo o cep "11155" 
    E informo o pais "United States" 
    E informo o numero de celular "11966666666" 
    E informo o endereco alternativo "Rua da praia" 
    E clico na acao registrar uma conta
    Entao eu sou redirecionado para o menu minha conta
    
    @autenticao_invalida
    Cenario: Autenticacao de cadastro invalida
    Dado que tenho um email "mariazinha66@gmail.com" valido de novo usuario 
    E que eu estou na pagina de cadastro de usuario
    Quando informo o genero ""
    E informo o nome "" 
    E informo o sobrenome "" 
    E informo a senha "" 
    E informo o dia "-" de dia de nascimento 
    E informo o mes "-" de mes de nascimento 
    E informo o ano "-" de ano de nascimento 
    E informo o endereco "" 
    E informo a cidade "" 
    E informo o estado "" 
    E informo o cep "" 
    E informo o pais "" 
    E informo o numero de celular "" 
    E informo o endereco alternativo "" 
    E clico na acao registrar uma conta
    Entao uma mensagem de cadastro com erro e mostrada