function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, '\\$&');
    const regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)');
    const results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
  }
  
  document.addEventListener('DOMContentLoaded', function () {
    const addToCartButton = document.querySelector('.add-to-cart');
    const cartItemsContainer = document.getElementById('cart-items');
    const cartTotal = document.getElementById('cart-total');
    const productDetailsContainer = document.getElementById('product-details');
  
    let carrinho = [];
  
    // Objeto contendo informações dos produtos
    const produtos = {
        produto1: {
        id: "produto1",
        nome: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
        preco: "5,00",
        vencimento: "12/12/2023",
        descricao: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
        imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto1.png"
    },
    produto2: {
        id: "produto2",
        nome: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
        preco: "5,00",
        vencimento: "12/12/2023",
        descricao: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
        imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto1.png"
    },
    produto3: {
        id: "produto3",
        nome: "Snack de Batata Cheddar Elma Chips Stax Pote 156g",
        preco: "5,00",
        vencimento: "12/12/2023",
        descricao: "Snack à Base de Batata com Queijo Cheddar Elma Chips Stax Pote 156g",
        imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto2.png"
    },
    produto4: {
        id: "produto4",
        nome: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
        preco: "5,00",
        vencimento: "12/12/2023",
        descricao: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
        imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto1.png"
    },
    produto5: {
        id: "produto5",
        nome: "Snack de Batata Cheddar Elma Chips Stax Pote 156g",
        preco: "5,00",
        vencimento: "12/12/2023",
        descricao: "Snack à Base de Batata com Queijo Cheddar Elma Chips Stax Pote 156g",
        imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto2.png"
    },
    produto6: {
        id: "produto6",
        nome: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
        preco: "5,00",
        vencimento: "12/12/2023",
        descricao: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
        imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto1.png"
    },
    produto7: {
        id: "produto7",
        nome: "Snack de Batata Cheddar Elma Chips Stax Pote 156g",
        preco: "5,00",
        vencimento: "12/12/2023",
        descricao: "Snack à Base de Batata com Queijo Cheddar Elma Chips Stax Pote 156g",
        imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto2.png"
    },
    produto8: {
        id: "produto8",
        nome: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
        preco: "5,00",
        vencimento: "12/12/2023",
        descricao: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
        imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto1.png"
    },
    produto9: {
      id: "produto9",
      nome: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
      preco: "5,00",
      vencimento: "12/12/2023",
      descricao: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
      imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto1.png"
    },
    produto10: {
        id: "produto10",
        nome: "Snack de Batata Cheddar Elma Chips Stax Pote 156g",
        preco: "5,00",
        vencimento: "12/12/2023",
        descricao: "Snack à Base de Batata com Queijo Cheddar Elma Chips Stax Pote 156g",
        imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto2.png"
    },
    produto11: {
    id: "produto11",
    nome: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
    preco: "5,00",
    vencimento: "12/12/2023",
    descricao: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
    imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto1.png"
    },
    produto12: {
    id: "produto12",
    nome: "Snack de Batata Cheddar Elma Chips Stax Pote 156g",
    preco: "5,00",
    vencimento: "12/12/2023",
    descricao: "Snack à Base de Batata com Queijo Cheddar Elma Chips Stax Pote 156g",
    imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto2.png"
    },
    produto13: {
    id: "produto13",
    nome: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
    preco: "5,00",
    vencimento: "12/12/2023",
    descricao: "Chocolate ao Leite Alpine Milk Milka Pacote 100g",
    imagemUrl: "https://raw.githubusercontent.com/JefDfelipe/ProjetoIntegradorSENAC/efa40fef3c04fb54c2a8720fd3f292f723eee886/produto1.png"
    },
};
  
    // Função para exibir detalhes do produto com base no produtoId
    function exibirDetalhesProduto(produtoId) {
      const produto = produtos[produtoId];
      if (produto) {
        const productImage = document.getElementById('product-image');
        productImage.src = produto.imagemUrl;

        // Converter o preço para um número antes de usar toFixed()
    const precoNumerico = parseFloat(produto.preco);

    if (!isNaN(precoNumerico)) {
        productDetailsContainer.innerHTML = `
        <h1>${produto.nome}</h1>
        <div class="price-and-quantity">
          <div class="price">
            <span class="label">Preço:</span>
            <div class="price-value">R$ <span class="value">${precoNumerico.toFixed(2)}</span></div>
          </div>
          <p class="product-expiry">VENCIMENTO: ${produto.vencimento}</p>
          <div class="quantity">
            <span class="label">Quantidade:</span>
            <input type="number" class="quantity-input" value="1" min="1">
          </div>
        </div>
        <button class="add-to-cart" data-id="${produtoId}" data-price="${precoNumerico}">Adicionar ao Carrinho</button>
        <div class="description">
          <h2>Descrição do Produto</h2>
          <hr>
          <p>${produto.descricao}</p>
        </div>
      `;
    } else {
        productDetailsContainer.innerHTML = 'Preço inválido.';
      }
    } else {
      productDetailsContainer.innerHTML = 'Produto não encontrado.';
    }
    }
  
    // Obter o valor do parâmetro 'produto' na URL
    var produtoId = getParameterByName('produto');
  
    // Exibir detalhes do produto com base no produtoId
    exibirDetalhesProduto(produtoId);
  
    // Restante do código para adicionar ao carrinho e atualizar o carrinho...
  
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
            <input type="number" class="quantity-input" value="${item.quantidade}" min="1" onchange="atualizarQuantidade('${item.id}', this.value)">
          </div>
          <div>R$ ${(item.preco * item.quantidade).toFixed(2)}</div>
          <div>
            <button onclick="removerDoCarrinho('${item.id}')">Remover</button>
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
  