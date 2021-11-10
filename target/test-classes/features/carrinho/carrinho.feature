#language: pt

@carrinho
Funcionalidade: Carrinho de compras
  Como usuario cadastrado, quero ter um carrinho de compras

  @adicionar_produto
  Cenario: Adicionar produto no carrinho de compras
    Dado que eu tenho estou logado no site com email "fulano@hotmail.com" e senha "123456"
    Quando pesquiso e seleciono o produto "t-shirt"
    Entao o produto e adicionado ao carrinho de compras

  @remover_produto
  Cenario: Remover produto do carrinho de compras
    Dado que eu tenho estou logado no site com email "fulano@hotmail.com" e senha "123456"
    Quando pesquiso e seleciono o produto "t-shirt"
    Entao o produto e adicionado ao carrinho de compras
    E o produto e removido do carrinho de compras
