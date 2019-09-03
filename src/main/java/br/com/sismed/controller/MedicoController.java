package br.com.sismed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sismed.model.pessoa.Medico;
import br.com.sismed.service.MedicoService;

@Controller
@RequestMapping(value = "/medicos")
public class MedicoController {
	private MedicoService medicoService;
	

	@Autowired(required=true)
	@Qualifier(value="medicoService")
	public void setMedicoService(MedicoService ms){
		this.medicoService = ms;
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listMedicos(Model model) {
		model.addAttribute("medico", new Medico());
		model.addAttribute("listMedicos", this.medicoService.listMedico());
		return "medico";
	}
	
	// Pra add e atualizar
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addMedico(@ModelAttribute("medico") Medico m){
		
		if(m.getId() == 0){
			// novo medico, add 
			this.medicoService.addMedico(m);
		}else{
			//medico existe, atualizar
			this.medicoService.updateMedico(m);
		}
		
		return "redirect:/medicos/listar";
		
	}
	
	@RequestMapping("/remover/{id}")
    public String removeMedico(@PathVariable("id") int id){
		
        this.medicoService.removeMedico(id);
        return "redirect:/medicos/listar";
    }
	
	@RequestMapping("/editar/{id}")
    public String editMedico(@PathVariable("id") int id, Model model){
        model.addAttribute("medico", this.medicoService.getMedicoById(id));
        model.addAttribute("listMedicos", this.medicoService.listMedico());
        return "medico";
    }
	
	
	
	
	

}
