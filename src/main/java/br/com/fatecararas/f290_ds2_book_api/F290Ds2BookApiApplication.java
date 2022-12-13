package br.com.fatecararas.f290_ds2_book_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fatecararas.f290_ds2_book_api.service.impl.LocacaoService;

@SpringBootApplication
public class F290Ds2BookApiApplication implements CommandLineRunner{

	@Autowired
	private LocacaoService service;

	public static void main(String[] args) {
		SpringApplication.run(F290Ds2BookApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// List<Locacao> locacoes = service.buscarLocacoesPorEmail("bzr4@icloud.com");
		// System.out.println(locacoes);
		// locacoes.forEach(l -> {
		// 	System.out.println(l.getLivro().getTitulo());
		// });
		
	}
}
