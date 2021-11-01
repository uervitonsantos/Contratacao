/**
 * 
 */

var selectedRow = null

function formSubmit(){
	if(insertForm == true){
		var formDate = insertForm();
		if(selectedRow == null){
			createRow(formDate);	
		}else{
			updateRecord(formdate);
			clearForm();
		}	
	}
}


//Função que verificam se os campos do formulario de cadastro de candidato estão vazios e rtorna uma mensagem.
//Se os campos forem preenchidos corretamnte, a função transfere os dados para o database
function insertForm() {
	if (document.getElementById("inputTitulo").value.length == '') {
		alert('Por favor, preencha o campo titulo');
		document.getElementById("inputTitulo").focus();
		return false
	} else if (document.getElementById("inputDescricao").value.length == '') {
		alert('Por favor, preencha o campo descrição');
		document.getElementById("inputDescricao").focus();
		return false
	} else if (document.getElementById("inputQuantidadeVagas").value.length == '') {
		alert('Por favor, preencha o campo quantidades de vagas');
		document.getElementById("inputQuantidadeVagas").focus();
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
		clearForm();
	}
}

function clearForm() {
	document.getElementById("inputTitulo").value = "";
	document.getElementById("inputDescricao").value = "";
	document.getElementById("inputQuantidadeVagas").value = "";
	document.getElementById("inputMaximoCandidatos").value = "";
	document.getElementById("inputData").value = "";
	document.getElementById("inputTitulo").focus();
}

//Função que realiza a criação das colunas no database
function createRow(nome, sobrenome, Cpf, data) {
	const tr = document.createElement('tr');

	var oRows = document.getElementById('dtable').getElementsByTagName('tr');
	var iRowCount = oRows.length;
	if (iRowCount > 10) {
		alert('Atenção, você está tentando incluir ' + (iRowCount) + ' itens na tabela. Porém só é permitido ' + (iRowCount - 1) + ' itens por transação!');
		return false;
	}
	cell1 = tr.insertCell(0);
	cell1.innerHTML = nome;
	cell2 = tr.insertCell(1);
	cell2.innerHTML = sobrenome;
	cell3 = tr.insertCell(2);
	cell3.innerHTML = Cpf;
	cell4 = tr.insertCell(3);
	cell4.innerHTML = data;
	cell5 = tr.insertCell(4);
	cell5.innerHTML = `<button type="button" onclick="onEdit(this)" class="btn btn-warning btn btn-primary btn-sm"><i class="glyphicon glyphicon-pencil"></i></button>
						<button type="button" onclick="onDelete(this)" class="btn btn-danger btn btn-primary btn-sm"><i class="glyphicon glyphicon-trash"></i></button>`;
	return tr;
}

//Função que realiza a criação das linhas no database
function createTd(value) {
	const td = document.createElement('td');
	td.innerText = value;
	return td;
}


function onEdit(td) {
	selectedRow = td.parentElement.parentElement;
	document.getElementById("inputNome").value = selectedRow.cells[0].innerHTML;
	document.getElementById("inputSobreNome").value = selectedRow.cells[1].innerHTML;
	document.getElementById("inputCpf").value = selectedRow.cells[2].innerHTML;
	document.getElementById("inputData").value = selectedRow.cells[3].innerHTML;
}


function updateRecord(formData) {
	selectedRow.cells[0].innerHTML = formData.inputNome;
	selectedRow.cells[1].innerHTML = formData.inputSobreNome;
	selectedRow.cells[2].innerHTML = formData.inputCpf;
	selectedRow.cells[3].innerHTML = formData.inputData;
}


function onDelete(td) {
	if (confirm('Tem certeza que deseja excluir este registro?')) {
		row = td.parentElement.parentElement;
		document.getElementById("dtable").deleteRow(row.rowIndex);
		clearForm();
	}
}









