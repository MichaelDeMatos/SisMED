package br.com.sismed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sismed.model.agendamento.AgendamentoConsulta;
import br.com.sismed.service.AgendamentoConsultaService;

@Controller
@RequestMapping(value = "/agendamentos")
public class AgendamentoConsultaController {
	private AgendamentoConsultaService agendamentoConsultaService;
	
	@Autowired(required=true)
	@Qualifier(value="agendamentoConsultaService")
	public void setAgendamentoConsultaService(AgendamentoConsultaService ac){
		this.agendamentoConsultaService = ac;
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listAgendamentoConsulta(Model model) {
		model.addAttribute("agendamentoConsulta", new AgendamentoConsulta());
		model.addAttribute("listAgendamentoConsulta", this.agendamentoConsultaService.listAgendamentoConsulta());
		return "agendamentoConsulta";
	}
	
	// Pra add e atualizar
		@RequestMapping(value= "/add", method = RequestMethod.POST)
		public String addAgendamentoConsulta(@ModelAttribute("agendamentoConsulta") AgendamentoConsulta ac){
			
			if(ac.getId() == 0){
				// novo, add 
				this.agendamentoConsultaService.addAgendamentoConsulta(ac);
			}else{
				// existe, atualizar
				this.agendamentoConsultaService.updateAgendamentoConsulta(ac);
			}
			
			return "redirect:/agendamentos/listar";
			
		}
		
		@RequestMapping("/remover/{id}")
	    public String removeAgendamentoConsulta(@PathVariable("id") int id){
			
			this.agendamentoConsultaService.removeAgendamentoConsulta(id);
	        return "redirect:/agendamentos/listar";
	    }
		
		@RequestMapping("/editar/{id}")
	    public String editAgendamentoConsulta(@PathVariable("id") int id, Model model){
	        model.addAttribute("agendamentoConsulta", this.agendamentoConsultaService.getAgendamentoConsultaById(id));
	        model.addAttribute("listAgendamentoConsulta", this.agendamentoConsultaService.listAgendamentoConsulta());
	        return "agendamentoConsulta";
	    }
		
		
		
		
		
	
	
	
	
	
}
