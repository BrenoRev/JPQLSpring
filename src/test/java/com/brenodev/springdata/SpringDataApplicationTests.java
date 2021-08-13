package com.brenodev.springdata;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.brenodev.springdata.model.Telefone;
import com.brenodev.springdata.model.Usuario;
import com.brenodev.springdata.repository.TelefoneRepository;
import com.brenodev.springdata.repository.UsuarioRepository;
import com.brenodev.springdata.services.UsuarioService;

@SpringBootTest
class SpringDataApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UsuarioRepository interfaceSpringDataUser;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TelefoneRepository interfaceTelefone;
	
	@Test
	public void testeInsert() {

		Usuario usuarioSpringData = new Usuario();

		usuarioSpringData.setEmail("javaavancado@javaavancado.com");
		usuarioSpringData.setIdade(31);
		usuarioSpringData.setLogin("teste 123");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("Egidio Alex");

		interfaceSpringDataUser.save(usuarioSpringData);

		System.out.println("Usuario cadastrado -> " + interfaceSpringDataUser.count());

	}

	@Test
	public void testeConsulta() throws Exception {

		Optional<Usuario> usuarioSpringData = interfaceSpringDataUser.findById(8L);

		if (usuarioSpringData.isPresent()) {
			System.out.println(usuarioSpringData.get().getIdade());
			System.out.println(usuarioSpringData.get().getEmail());
			System.out.println(usuarioSpringData.get().getIdade());
			System.out.println(usuarioSpringData.get().getLogin());
			System.out.println(usuarioSpringData.get().getNome());
			System.out.println(usuarioSpringData.get().getSenha());
			System.out.println(usuarioSpringData.get().getId());
		}else {
			throw new Exception();	
		}
		
		
		  for (Telefone telefone : usuarioSpringData.get().getTelefone()){
		  System.out.println(telefone.getNumero());
		  System.out.println(telefone.getTipo()); System.out.println(telefone.getId());
		  System.out.println(telefone.getUsuario().getNome());
		  System.out.println("-----------------------------------------"); }
		 
	}

	@Test
	public void testeConsulaTodos() {
		Iterable<Usuario> lista = interfaceSpringDataUser.findAll();

		for (Usuario usuarioSpringData : lista) {

			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("---------------------------------------------------");
		}
	}

	@Test
	public void testeUpdate() throws Exception {
		Optional<Usuario> usuarioSpringData = interfaceSpringDataUser.findById(13L);

		if (usuarioSpringData.isPresent()) {
			Usuario data = usuarioSpringData.get();
			data.setNome("Alex Egidio Update Spring Data");
			data.setIdade(25);
			interfaceSpringDataUser.save(data);
		}else {
			throw new Exception();	
		}

	}

	@Test
	public void testeDelete() {
		Optional<Usuario> usuarioSpringData = interfaceSpringDataUser.findById(21L);
		if (usuarioSpringData.isPresent()) {
			interfaceSpringDataUser.delete(usuarioSpringData.get());
		}
	}

	@Test
	public void testeConsultaNome() throws Exception {

		List<Usuario> list = interfaceSpringDataUser.buscaPorNome("Alex");
		if (list.size() > 0) {
			for (Usuario usuarioSpringData : list) {

				System.out.println(usuarioSpringData.getEmail());
				System.out.println(usuarioSpringData.getIdade());
				System.out.println(usuarioSpringData.getLogin());
				System.out.println(usuarioSpringData.getNome());
				System.out.println(usuarioSpringData.getSenha());
				System.out.println(usuarioSpringData.getId());
				System.out.println("---------------------------------------------------");
			}
		}else {
			throw new Exception();	
		}

	}

	@Test
	public void testeConsultaNomeParam() throws Exception {

		List<Usuario> usuarioSpringData = interfaceSpringDataUser.buscaPorNome("breno");
		
		if(usuarioSpringData.size() > 0) {
			usuarioSpringData.forEach(System.out::println);
		}else {
			throw new Exception();	
		}
	}

	@Test
	public void testeDeletePorNome() {
		interfaceSpringDataUser.deletePorNome("Egidio Alex");
	}
	
	
	  @Test 
	  public void testeUpdateEmailPorNome(){
	  
	  usuarioService.updateEmailPorNome(
	  "testeemailspringdata@gmail.com.br", "Alex Egidio Update Spring Data");
	  
	 }
	
	
	  @Test 
	  public void testeInsertTelefone(){
	  
	  Optional<Usuario> usuarioSpringData = interfaceSpringDataUser.findById(43L);
	  
	  Telefone telefone = new Telefone(); 
	  telefone.setTipo("Casa");
	  telefone.setNumero("857465454");
	  telefone.setUsuario(usuarioSpringData.get());
	  
	  interfaceTelefone.save(telefone); 
	  }

}
