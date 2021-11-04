#language: pt
@cadastro
Funcionalidade: Cadastro de usuario
  Como usuario quero me cadastrar no site para efetuar compras

  Cenario: Validar email de cadastro
    Dado que eu estou na pagina de cadastro de usuario
    Quando informo o "email"
    E seleciono a acao de criar uma conta
    Entao sou redirecionado para a tela de novo usuario