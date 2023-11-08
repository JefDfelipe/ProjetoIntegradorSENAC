// Função para mostrar campos de CPF e ocultar campos de CNPJ
function showCPF() {
  document.getElementById("cpf-field").style.display = "block";
  document.getElementById("cnpj-field").style.display = "none";
  document.getElementById("razao-social-field").style.display = "none";
  document.getElementById("nome-fantasia-field").style.display = "none";
  document.getElementById("inscricao-estadual-field").style.display = "none";
  document.getElementById("isencao-estadual-field").style.display = "none";
}

// Função para mostrar campos de CNPJ e ocultar campos de CPF
function showCNPJ() {
  document.getElementById("cpf-field").style.display = "none";
  document.getElementById("cnpj-field").style.display = "block";
  document.getElementById("razao-social-field").style.display = "block";
  document.getElementById("nome-fantasia-field").style.display = "block";
  document.getElementById("inscricao-estadual-field").style.display = "block";
  document.getElementById("isencao-estadual-field").style.display = "block";
}

// Detectar mudanças na seleção
document.getElementById("tipo").addEventListener("change", function () {
  var tipoSelecionado = this.value;

  if (tipoSelecionado === "pessoa-fisica") {
    showCPF();
  } else if (tipoSelecionado === "pessoa-juridica") {
    showCNPJ();
  }
});

// Inicialmente, mostrar campos de CPF por padrão
showCPF();

//Verificação de veracidade de CPF
function validarCPF(cpf) {
  cpf = cpf.replace(/[^\d]+/g, ''); // Remove caracteres não numéricos

  if (cpf === '' || cpf.length !== 11 || /^(\d)\1+$/.test(cpf)) {
    return false; // CPF inválido
  }

  let sum = 0;
  let remainder;

  for (let i = 1; i <= 9; i++) {
    sum += parseInt(cpf.substring(i - 1, i)) * (11 - i);
  }

  remainder = (sum * 10) % 11;

  if (remainder === 10 || remainder === 11) {
    remainder = 0;
  }

  if (remainder !== parseInt(cpf.substring(9, 10))) {
    return false; // CPF inválido
  }

  sum = 0;

  for (let i = 1; i <= 10; i++) {
    sum += parseInt(cpf.substring(i - 1, i)) * (12 - i);
  }

  remainder = (sum * 10) % 11;

  if (remainder === 10 || remainder === 11) {
    remainder = 0;
  }

  if (remainder !== parseInt(cpf.substring(10, 11))) {
    return false; // CPF inválido
  }

  return true; // CPF válido
}

// Função para verificar o CEP usando a API ViaCEP
function verificarCEP(cep) {
  fetch(`https://viacep.com.br/ws/${cep}/json/`)
    .then((response) => response.json())
    .then((data) => {
      if (!data.erro) {
        // CEP válido, preencha os campos de endereço
        document.getElementById("endereco").value = data.logradouro;
        document.getElementById("cidade").value = data.localidade;
        document.getElementById("estado").value = data.uf;
      } else {
        // CEP inválido, exiba uma mensagem de erro
        alert("CEP não encontrado. Verifique o CEP informado.");
      }
    })
    .catch((error) => {
      console.error("Erro ao consultar CEP:", error);
    });
}

// Adicionar evento de clique ao botão "Consultar CEP"
document.getElementById("cep-consulta").addEventListener("click", function () {
  const cep = document.getElementById("cep").value.replace(/\D/g, ''); // Remove caracteres não numéricos
  if (cep.length === 8) {
    verificarCEP(cep);
  } else {
    alert("O CEP deve conter 8 dígitos.");
  }
});