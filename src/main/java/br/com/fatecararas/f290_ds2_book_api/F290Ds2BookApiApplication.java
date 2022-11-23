package br.com.fatecararas.f290_ds2_book_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fatecararas.f290_ds2_book_api.model.entity.Locacao;
import br.com.fatecararas.f290_ds2_book_api.service.LocacaoService;

@SpringBootApplication
public class F290Ds2BookApiApplication implements CommandLineRunner{

	@Autowired
	private LocacaoService service;

	public static void main(String[] args) {
		SpringApplication.run(F290Ds2BookApiApplication.class, args);
	}
	// Moscardi, Nardi, Venesian, Jonas, Ricieri, Larissa
	// Ricardo, Guilerme, Favio, Alex

	@Override
	public void run(String... args) throws Exception {
		List<Locacao> locacoes = service.buscarLocacoesPorEmail("bzr4@icloud.com");
		System.out.println(locacoes);
		locacoes.forEach(l -> {
			System.out.println(l.getLivro().getTitulo());
		});
		
	}
}
