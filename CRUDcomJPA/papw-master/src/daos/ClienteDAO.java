package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unipe.fujioka.java.web.entidades.Cliente;

public class ClienteDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
	EntityManager manager = factory.createEntityManager();
	
	public Cliente getById(final int matricula) {
        return manager.find(Cliente.class, matricula);
    }
	
	public void salvar(Cliente c) {
		manager.getTransaction().begin();
		manager.merge(c);
		manager.getTransaction().commit();
		factory.close();
	}
	
	public void alterar(Cliente c, String nome, String sobrenome, String matricula, boolean ativo) {
		manager.getTransaction().begin();
		c = manager.find(Cliente.class, c.getId());
		c.setNome(nome);
		c.setSobrenome(sobrenome);
		c.setMatricula(matricula);
		c.setAtivo(ativo);
		manager.getTransaction().commit();
		manager.refresh(c);
		factory.close();
		System.out.println(c);
	}
	
	public void excluir(Cliente c) {
		manager.getTransaction().begin();
		manager.remove(c);
		manager.getTransaction().commit();
		factory.close();
	}
	
	public void ativar(Cliente c) {
		manager.getTransaction().begin();
		c.setAtivo(true);
		manager.getTransaction().commit();
		factory.close();
		
	}
	
	public void desativar(Cliente c) {
		manager.getTransaction().begin();
		c.setAtivo(false);
		manager.getTransaction().commit();
		factory.close();
	}
	
	public List<Cliente> listartudo() {
		Query query = manager.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> lista =  query.getResultList();
		
		return lista;
	}
	
	public List<Cliente> listarPref() {
		Query query = manager.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> listaPref =  query.getResultList();

		return listaPref;
		
	}

}
