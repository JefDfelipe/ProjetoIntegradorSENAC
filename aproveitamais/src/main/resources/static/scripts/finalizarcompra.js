 const produtosNoCarrinho = [
    { nome: "Produto 1", preco: 10.00 },
    { nome: "Produto 2", preco: 15.00 },
    // Adicione mais produtos conforme necessário
  ];

  // Função para calcular o subtotal
  function calcularSubtotal() {
    let subtotal = 0;
    produtosNoCarrinho.forEach((produto) => {
      subtotal += produto.preco;
    });
    return subtotal;
  }

  // Função para atualizar os valores do subtotal e do total
  function atualizarValores() {
    const subtotal = calcularSubtotal();
    const total = subtotal; // Se desejar, você pode adicionar custos de envio, impostos, etc.

    // Atualiza os elementos HTML com os valores calculados
    document.getElementById("subtotal-value").textContent = `R$ ${subtotal.toFixed(2)}`;
    document.getElementById("total-value").textContent = `R$ ${total.toFixed(2)}`;
  }

  // Chame a função para atualizar os valores quando a página carregar
  window.addEventListener("load", atualizarValores);