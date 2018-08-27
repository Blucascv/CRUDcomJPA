package br.unipe.fujioka.java.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.fujioka.java.web.entidades.Cliente;

public class Main {
	
public static void main(String[] args) {
		
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
	EntityManager manager = factory.createEntityManager();
	Cliente cliente = new Cliente();
	cliente.setNome("Brian");
	cliente.setSobrenome("Lucas");
	cliente.setMatricula("1610013318");
	cliente.setAtivo(true);
	
	}

}
