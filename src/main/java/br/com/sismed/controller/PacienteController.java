package br.com.sismed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sismed.model.pessoa.Paciente;
import br.com.sismed.service.PacienteService;

@Controller
@RequestMapping(value = "/pacientes")
public class PacienteController {
	private PacienteService pacienteService;
	
	@Autowired(required=true)
	@Qualifier(value="pacienteService")
	public void setPacienteService(PacienteService ps){
		this.pacienteService = ps;
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listPacientes(Model model) {
		model.addAttribute("paciente", new Paciente());
		model.addAttribute("listPacientes", this.pacienteService.listPaciente());
		return "paciente";
	}
	
	// Pra add e atualizar
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addPaciente(@ModelAttribute("paciente") Paciente p){
		
		if(p.getId() == 0){
			// novo, add 
			this.pacienteService.addPaciente(p);
		}else{
			// existe, atualizar
			this.pacienteService.updatePaciente(p);
		}
		
		return "redirect:/pacientes/listar";
		
	}
	
	@RequestMapping("/remover/{id}")
    public String removePaciente(@PathVariable("id") int id){
		
        this.pacienteService.removePaciente(id);
        return "redirect:/pacientes/listar";
    }
	
	@RequestMapping("/editar/{id}")
    public String editPaciente(@PathVariable("id") int id, Model model){
        model.addAttribute("paciente", this.pacienteService.getPacienteById(id));
        model.addAttribute("listPacientes", this.pacienteService.listPaciente());
        return "paciente";
    }
	
	

}
