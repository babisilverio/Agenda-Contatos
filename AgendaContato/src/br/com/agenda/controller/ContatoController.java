package br.com.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.agenda.dados.Contato;
import br.com.agenda.dados.ContatoDAO;

@Controller
public class ContatoController {
	private ContatoDAO dao;
	
	@Autowired
	public ContatoController(ContatoDAO dao) {
		this.dao = dao;
	}
	
	// Ja exibe os contatos cadastrados no index
	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("lista", dao.getLista());
		return "index";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro(){
		return "cadastro";
	}
	
	@RequestMapping("/addContato")
	public String addContato(Contato contato){
		contato.setId(dao.getLista().size() + 1);
		dao.addContato(contato);
		return "redirect:index";
	}
	
	@RequestMapping("/alterar")
	public String alterar(Model model, int id){
		Contato contato = dao.pesquisaContato(id);		
		model.addAttribute("contato", contato);
		return "alterar";
	}
	
	@RequestMapping("/alterarContato")
	public String alterarContato(Contato contato){
		dao.alterarContato(contato);
		return "redirect:index";
	}
	
	@RequestMapping("/excluir")
	public String excluir(Model model, int id){
		Contato contato = dao.pesquisaContato(id);		
		model.addAttribute("contato", contato);
		return "excluir";
	}
	
	@RequestMapping("/excluirContato")
	public String excluirContato(Contato contato){
		dao.excluirContato(contato.getId());
		return "redirect:index";
	}
}// class
