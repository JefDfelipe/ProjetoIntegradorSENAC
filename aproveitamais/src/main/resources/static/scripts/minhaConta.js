$(document).ready(function () {
  $('.btn-edit-profile').click(function () {
    // Esconder informações do perfil e mostrar formulário de edição
    $('.profile-info').hide();
    $('.edit-profile').show();
  });

  $('.btn-save-profile').click(function (e) {
    e.preventDefault();
    // Processar o envio do formulário de edição e atualizar as informações do perfil
    const novoNome = $('#edit-nome').val();
    const novoEmail = $('#edit-email').val();
    const novaSenha = $('#edit-senha').val();



    // Enviar as informações para o servidor e atualizar o perfil do usuário

    // Após a atualização bem-sucedida, atualize as informações exibidas
    $('#nome').val(novoNome);
    $('#email').val(novoEmail);
    $('#senha').val(novoSenha);


    // Esconder o formulário de edição e mostrar as informações do perfil
    $('.edit-profile').hide();
    $('.profile-info').show();
  });
});