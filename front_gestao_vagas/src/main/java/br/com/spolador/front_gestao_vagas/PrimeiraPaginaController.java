package br.com.spolador.front_gestao_vagas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PrimeiraPaginaController {

    @GetMapping("/home")
    public String primeiraPaginaHtml(Model model){
        model.addAttribute("mensagemDaController", "Primeira msg da controller");
        return "primeiraPagina";
    }

    @GetMapping("/login")
    public String loginCandidate(){
        return "candidate/login";
    }

    @PostMapping("/create")
    public String cadastroCandidate(String nome_do_candidato){
        System.out.println("Nome do candidato: " + nome_do_candidato);
        return "/candidate/login";
    }
}
