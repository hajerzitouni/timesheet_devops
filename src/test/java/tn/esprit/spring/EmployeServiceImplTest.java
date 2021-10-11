package tn.esprit.spring;

import java.util.Date;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.IEmployeService;

public class EmployeServiceImplTest {

	@Autowired
	IEmployeService employeS;
	
	@Autowired
	EmployeRepository empR;
	
	@Autowired
	ContratRepository contratRepository;
	
	private Employe employe;
	private Contrat contrat;

	@Before
	public void setUp() throws Exception {
		this.employe = new Employe();
		this.employe.setId(1);
		this.employe.setPrenom("Selim");
		this.employe.setNom("CHIKH ZAOUALI");
		this.employe.setEmail("selim.chikhzaouali@esprit.tn");
		this.employe.setActif(true);
		this.employe.setRole(Role.INGENIEUR);
		this.contrat = new Contrat();
		this.contrat.setReference(7);

	}

	@Test
	public void tests() {
		//ajouterEmployeTest();
		//ajouterContratTest();
		//affecterContratAEmployeTest();
        //deleteContratByIdTest();
       // deleteAllContratJPQLTest();
        
	}

	
	public void ajouterEmployeTest(){
		this.employe.setPrenom("Selim");
		this.employe.setNom("CHIKH ZAOUALI");
		this.employe.setEmail("selim.chikhzaouali@esprit.tn");
		this.employe.setActif(true);
		this.employe.setRole(Role.INGENIEUR);
		this.employe.setId(employeS.ajouterEmploye(employe));
		Assert.assertTrue(employe.getId()>0);
	}

	public void ajouterContratTest() {
		Date d = new Date();
		this.contrat.setEmploye(this.employe);

		this.contrat.setDateDebut(d);
		this.contrat.setSalaire(1500);
		this.contrat.setReference(employeS.ajouterContrat(this.contrat));

		Assert.assertTrue(contrat.getReference() > 0);

	}

	public void affecterContratAEmployeTest() {

		
		employeS.affecterContratAEmploye(10, 1);
		Assert.assertEquals(this.employe.getContrat().getReference(), this.contrat.getReference());

	}

	

	public void deleteContratByIdTest() {

		employeS.deleteContratById(7);
		Optional<Contrat> cont = contratRepository.findById(this.contrat.getReference());
		Assert.assertTrue(cont.isPresent());

	}
	

}