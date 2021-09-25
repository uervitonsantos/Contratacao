/**
 * 
 */

//Função que verificam se os campos do formulario de cadastro de candidato estão vazios e rtorna uma mensagem.
//Se os campos forem preenchidos corretamnte, a função transfere os dados para o database
function save() {
	if (document.getElementById("inputNome").value.length == '') {
		alert('Por favor, preencha o campo nome');
		document.getElementById("inputNome").focus();
		return false
	} else if (document.getElementById("inputSobreNome").value.length == '') {
		alert('Por favor, preencha o campo sobrenome');
		document.getElementById("inputNome").focus();
		return false
	} else if (document.getElementById("inputCpf").value.length == '') {
		alert('Por favor, preencha o campo cpf');
		document.getElementById("inputNome").focus();
		return false
	} else if (document.getElementById("inputData").value.length == '') {
		alert('Por favor, preencha o campo data');
		document.getElementById("inputNome").focus();
		return false
	} else {
		const nome = document.getElementById('inputNome').value;
		const sobrenome = document.getElementById('inputSobreNome').value;
		const Cpf = document.getElementById('inputCpf').value;
		const data = document.getElementById('inputData').value;
		const tbody = document.querySelector('#dtable tbody');
		tbody.appendChild(createRow(nome, sobrenome, Cpf, data));

		document.getElementById("inputNome").value = "";
		document.getElementById("inputSobreNome").value = "";
		document.getElementById("inputCpf").value = "";
		document.getElementById("inputData").value = "";
		document.getElementById("inputNome").focus();

	}

}


//Função que realiza a criação das colunas no database
function createRow(nome, sobrenome, Cpf, data) {
	const tr = document.createElement('tr');
	tr.appendChild(createTd(nome));
	tr.appendChild(createTd(sobrenome));
	tr.appendChild(createTd(Cpf));
	tr.appendChild(createTd(data));
	return tr;
}

//Função que realiza a criação das linhas no database
function createTd(value) {
	const td = document.createElement('td');
	td.innerText = value;
	return td;
}


