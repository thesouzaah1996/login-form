
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o envio tradicional do formulário

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const loginData = {
        email: email,
        password: password
    };

    fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    })
    .then(response => {
        if (response.ok) {
            return response.text();
        } else {
            throw new Error('Credenciais inválidas');
        }
    })
    .then(data => {
        alert(data); // Exibe a mensagem de sucesso
        // Redirecionar ou fazer algo após o login bem-sucedido
    })
    .catch(error => {
        alert(error.message); // Exibe a mensagem de erro
    });
});