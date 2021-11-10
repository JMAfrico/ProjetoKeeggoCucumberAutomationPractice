#language: pt

@login
Funcionalidade: Realizar login no sistema
  Como usuario quero acessar minha conta cadastrada

  @acesso_valido
  Cenario: Acessar minha conta cadastrada
    Dado que eu acessei a pagina de login
    Quando informo o email "fulano@hotmail.com"  
    E informo senha "123456"
    E seleciono a acao de logar no site
    Entao sou redirecionado para o menu da minha conta
     
 @acesso_invalido
  Cenario: Acessar conta nao cadastrada
    Dado que eu acessei a pagina de login
    Quando informo o email "naocadastrado@hotmail.com"  
    E informo senha "invalido"
    E seleciono a acao de logar no site
    Entao aparece uma mensagem de acesso invalido
    

