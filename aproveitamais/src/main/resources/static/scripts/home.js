document.addEventListener('DOMContentLoaded', function () {
  const products = document.querySelectorAll('.product');

  products.forEach((product) => {
    const addToCartButton = product.querySelector('.add-to-cart');
    const productId = addToCartButton.dataset.id;

    // Adicionar um evento de clique ao elemento do produto
    product.addEventListener('click', () => {
      // Construir o URL da página de detalhes do produto com base no productId
      const productDetailsURL = `detalhesproduto.html?produto=${productId}`;
      
      // Redirecionar o usuário para a página de detalhes do produto
      window.location.href = productDetailsURL;
    });

    addToCartButton.addEventListener('click', (event) => {
      // Impedir a propagação do evento de clique para evitar redirecionamentos duplicados
      event.stopPropagation();

      // Obter informações do produto
      const productTitle = product.querySelector('.product-title').textContent;
      const productPrice = parseFloat(addToCartButton.dataset.price);
      const productId = parseInt(addToCartButton.dataset.id);

      // Adicionar o produto ao carrinho
      adicionarAoCarrinho({ id: productId, nome: productTitle, preco: productPrice, quantidade: 1 });

      // Atualizar o carrinho na interface
      updateCart();
    });
  });

  // Função para adicionar um item ao carrinho
  function adicionarAoCarrinho(item) {
    const produtoExistente = carrinho.find((produto) => produto.id === item.id);

    if (produtoExistente) {
      // Se o produto já existe no carrinho, apenas aumente a quantidade
      produtoExistente.quantidade += 1;
    } else {
      // Se o produto não existe no carrinho, adicione-o com quantidade 1
      carrinho.push(item);
    }

    calcularTotal();
  }

  // Função para atualizar a exibição do carrinho
  function updateCart() {
    // Limpar a tabela de itens do carrinho
    cartItemsContainer.innerHTML = '';

    // Atualizar o conteúdo do contêiner de itens do carrinho
    carrinho.forEach((item) => {
      const productBox = document.createElement('div'); // Criar uma div para cada produto
      productBox.classList.add('product-box'); // Adicionar uma classe CSS para a div do produto

      productBox.innerHTML = `
        <div>${item.nome}</div>
        <div>R$ ${item.preco.toFixed(2)}</div>
        <div>
          <input type="number" class="quantity-input" value="${item.quantidade}" min="1" onchange="atualizarQuantidade(${item.id}, this.value)">
        </div>
        <div>R$ ${(item.preco * item.quantidade).toFixed(2)}</div>
        <div>
          <button onclick="removerDoCarrinho(${item.id})">Remover</button>
        </div>
      `;

      cartItemsContainer.appendChild(productBox);
    });

    // Atualizar o total do carrinho
    cartTotal.textContent = `Total: R$ ${calcularTotal().toFixed(2)}`;
  }

  // Função para atualizar a quantidade de um produto no carrinho
  function atualizarQuantidade(id, quantidade) {
    const produtoExistente = carrinho.find((produto) => produto.id === id);

    if (produtoExistente) {
      produtoExistente.quantidade = parseInt(quantidade);
    }

    calcularTotal();
  }

  // Função para remover um produto do carrinho
  function removerDoCarrinho(id) {
    carrinho = carrinho.filter((produto) => produto.id !== id);
    calcularTotal();
  }

  // Função para calcular o total do carrinho
  function calcularTotal() {
    let total = 0;
    carrinho.forEach((item) => {
      total += item.preco * item.quantidade;
    });
    return total;
  }
});
