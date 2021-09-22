package com.contratacao;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contratacao.model.Pessoa;
import com.contratacao.service.PessoaService;

@SpringBootApplication
public class ContratacaoApplication implements CommandLineRunner {

	@Autowired
	PessoaService pessoaService;

	public static void main(String[] args) {
		SpringApplication.run(ContratacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Joaquim");
		pessoa1.setSobrenome("Maria Machado de Assis");
		pessoa1.setCpf("50921874251");
		pessoa1.setDataNascimento(new GregorianCalendar(1839, 05, 21));

		pessoaService.salva(pessoa1);

		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("José");
		pessoa2.setSobrenome("Martiniano de Alencar");
		pessoa2.setCpf("65611588735");
		pessoa2.setDataNascimento(new GregorianCalendar(1829, 05, 01));

		pessoaService.salva(pessoa2);

		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Antônio");
		pessoa3.setSobrenome("Frederico de Castro Alves");
		pessoa3.setCpf("77906536444");
		pessoa3.setDataNascimento(new GregorianCalendar(1847, 02, 14));

		pessoaService.salva(pessoa3);

		Pessoa pessoa4 = new Pessoa();
		pessoa4.setNome("Jorge");
		pessoa4.setSobrenome("Leal Amado de Faria");
		pessoa4.setCpf("05631565463");
		pessoa4.setDataNascimento(new GregorianCalendar(1912, 07, 10));

		pessoaService.salva(pessoa4);
		
		Pessoa pessoa5 = new Pessoa();
		pessoa5.setNome("Carlos");
		pessoa5.setSobrenome("Drummond de Andrade");
		pessoa5.setCpf("48425754330");
		pessoa5.setDataNascimento(new GregorianCalendar(1902, 9, 31));

		pessoaService.salva(pessoa5);
		
		Pessoa pessoa6 = new Pessoa();
		pessoa6.setNome("Aluísio");
		pessoa6.setSobrenome("Tancredo Gonçalves de Azevedo");
		pessoa6.setCpf("65992536361");
		pessoa6.setDataNascimento(new GregorianCalendar(1057, 03, 14));

		pessoaService.salva(pessoa6);
		
		Pessoa pessoa7 = new Pessoa();
		pessoa7.setNome("José");
		pessoa7.setSobrenome("Maria de Eça de Queiroz");
		pessoa7.setCpf("02833435088");
		pessoa7.setDataNascimento(new GregorianCalendar(1845, 9, 25));

		pessoaService.salva(pessoa7);
		
		Pessoa pessoa8 = new Pessoa();
		pessoa8.setNome("Antônio");
		pessoa8.setSobrenome("Gonçalves Dias");
		pessoa8.setCpf("13610528990");
		pessoa8.setDataNascimento(new GregorianCalendar(1823, 07, 10));

		pessoaService.salva(pessoa8);
		
		Pessoa pessoa9 = new Pessoa();
		pessoa9.setNome("Manoel");
		pessoa9.setSobrenome("Antônio Álvares de Azevedo");
		pessoa9.setCpf("50650964810");
		pessoa9.setDataNascimento(new GregorianCalendar(1831, 8, 31));

		pessoaService.salva(pessoa9);
		
		Pessoa pessoa10 = new Pessoa();
		pessoa10.setNome("Joaquim");
		pessoa10.setSobrenome("Aurélio Barreto Nabuco de Araújo");
		pessoa10.setCpf("27151762283");
		pessoa10.setDataNascimento(new GregorianCalendar(1849, 07, 19));

		pessoaService.salva(pessoa10);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
