document.addEventListener('DOMContentLoaded', function () {
  const addToCartButtons = document.querySelectorAll('.add-to-cart');
  const cartItemsContainer = document.getElementById('cart-items');
  const cartTotal = document.getElementById('cart-total');

  let carrinho = [];

  addToCartButtons.forEach((button, index) => {
    button.addEventListener('click', () => {
      // Obter informações do produto
      const productTitle = document.querySelectorAll('.product-title')[index].textContent;
      const productPrice = parseFloat(document.querySelectorAll('.product-details')[index].textContent.replace('R$', ''));

      // Adicionar o produto ao carrinho
      adicionarAoCarrinho({ nome: productTitle, preco: productPrice });

      // Atualizar o carrinho na interface
      updateCart();
    });
  });

  // Função para adicionar um item ao carrinho
  function adicionarAoCarrinho(item) {
    carrinho.push(item);
    calcularTotal();
  }

  // Função para remover um item do carrinho
  function removerDoCarrinho(index) {
    carrinho.splice(index, 1);
    calcularTotal();
  }

  // Função para calcular o total do carrinho
  function calcularTotal() {
    let total = 0;
    carrinho.forEach((item) => {
      total += item.preco;
    });
    return total;
  }

  // Função para atualizar a exibição do carrinho
  function updateCart() {
    // Limpar a tabela de itens do carrinho
    cartItemsContainer.innerHTML = '';

    // Atualizar o conteúdo do contêiner de itens do carrinho
    carrinho.forEach((item, index) => {
      const productBox = document.createElement('div'); // Criar uma div para cada produto
      productBox.classList.add('product-box'); // Adicionar uma classe CSS para a div do produto

      productBox.innerHTML = `
        <div>${item.nome}</div>
        <div>R$ ${item.preco.toFixed(2)}</div>
        <div>1</div>
        <div>R$ ${item.preco.toFixed(2)}</div>
        <div>
          <button onclick="removerDoCarrinho(${index})">Remover</button>
        </div>
      `;

      cartItemsContainer.appendChild(productBox);
    });

    // Atualizar o total do carrinho
    cartTotal.textContent = `Total: R$ ${calcularTotal().toFixed(2)}`;
  }

  // Função para redirecionar para a página de pagamento
  function irParaPagamento() {
    // Redirecione para a página de pagamento
    window.location.href = 'pagamento.html';
  }
});