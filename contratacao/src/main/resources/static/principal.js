/**
 * 
 */

function save() {
	const nome = document.getElementById('inputNome').value;
	const sobrenome = document.getElementById('inputSobreNome').value;
	const Cpf = document.getElementById('inputCpf').value;
	const data = document.getElementById('inputData').value;
	const tbody = document.querySelector('#dtable tbody');
	tbody.appendChild(createRow(nome, sobrenome, Cpf, data));
}

function createRow(nome, sobrenome, Cpf, data) {
	const tr = document.createElement('tr');
	tr.appendChild(createTd(nome));
	tr.appendChild(createTd(sobrenome));
	tr.appendChild(createTd(Cpf));
	tr.appendChild(createTd(data));
	return tr;
}

function createTd(value) {
	const td = document.createElement('td');
	td.innerText = value;
	return td;
}
