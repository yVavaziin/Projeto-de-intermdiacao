const formCadastro = document.getElementById('formCadastro');
const campoMensagem = document.getElementById('mensagem');

formCadastro.addEventListener('submit', async (event) => {
    event.preventDefault();

    // Mostra que está processando
    campoMensagem.innerText = "Processando cadastro...";
    campoMensagem.style.color = "#636e72";

    // Dentro do formCadastro.addEventListener no seu script.js:

    const dadosUsuario = {
        nome: document.getElementById('nome').value,
        email: document.getElementById('email').value,
        senha: document.getElementById('senha').value,
        // ADICIONE ESSES CAMPOS ABAIXO:
        endereco: document.getElementById('endereco') ? document.getElementById('endereco').value : "",
        tipoEstabelecimento: document.getElementById('tipoEstabelecimento') ? document.getElementById('tipoEstabelecimento').value : "",
        tiposResiduos: document.getElementById('tiposResiduos') ? document.getElementById('tiposResiduos').value : ""
    };

    try {
        const resposta = await fetch('http://localhost:8080/api/usuarios/cadastrar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dadosUsuario)
        });

        if (resposta.ok) {
            const usuarioCriado = await resposta.json();

            // Mensagem de Sucesso (Verde elegante para fundo claro)
            campoMensagem.innerText = `✅ Sucesso! Bem-vindo, ${usuarioCriado.nome}.`;
            campoMensagem.style.color = "#00b36b";

            formCadastro.reset();

            // REDIRECIONAMENTO: Depois de 2 segundos, manda para o Login
            setTimeout(() => {
                window.location.href = "indexLogin.html";
            }, 2000);

        } else {
            campoMensagem.innerText = "❌ Erro ao cadastrar. Verifique os dados.";
            campoMensagem.style.color = "#d63031"; // Vermelho mais vivo
        }

    } catch (error) {
        console.error("Erro de conexão:", error);
        campoMensagem.innerText = "⚠️ O servidor está desligado no IntelliJ!";
        campoMensagem.style.color = "#e67e22"; // Laranja para aviso
    }
});