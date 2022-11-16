package com.example.ProjCarLL.controller;

import com.example.ProjCarLL.model.ClienteModel;
import com.example.ProjCarLL.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/apiCliente")
public class ClienteController {

    @Autowired
    ClienteRepository cliRepo;

    @GetMapping(value = "/todos")
    public List<ClienteModel> buscarTodos() {
        return cliRepo.findAll();
    }

    @PostMapping (value = "/inserir")
    public void inserirCliente(@RequestBody ClienteModel cl) {
        cliRepo.save(cl);
    }

    @DeleteMapping (value = "/excluir")
    public void excluirCliente(@RequestBody ClienteModel cl)
    {
        cliRepo.delete(cl);
    }

    @PutMapping (value = "/atualizar")
    public void atualizarCliente(@RequestBody ClienteModel cl)
    {
        cliRepo.save(cl);
    }

    @GetMapping (value = "/ClienteCod/{codigo}")
    public Optional<ClienteModel> buscarPorCodigo (@PathVariable(value = "codigo") int codigo) {
        return cliRepo.findById(codigo);
    }

    @GetMapping (value = "/ClienteNome/{nome}")
    public List<ClienteModel> ListarPorNome (@PathVariable (value="nome") String nome){
        return cliRepo.findByNome(nome);
    }

    @GetMapping (value = "/ClienteEmail/{email}")
    public List<ClienteModel> ListarPorEmail (@PathVariable (value="email") String email){
        return cliRepo.findByEmail(email);
    }

    @GetMapping ("/ClienteNomeInicial/{nome}")
    public List<ClienteModel> ListarPorInicialNome (@PathVariable (value="nome") String nome)
    {
        return cliRepo.findByNInicial(nome);
    }

    @GetMapping ("/ClienteCodMaior/{codigo}")
    public List<ClienteModel> ListarPorCodMaior (@PathVariable (value = "codigo") int codigo)
    {
        return cliRepo.findByCodMaior(codigo);
    }

    @GetMapping ("/ClienteEmailInicial/{email}")
    public List<ClienteModel> ListarPorInicialEmail (@PathVariable (value="email") String email)
    {
        return cliRepo.findByEInicial(email);
    }

    @GetMapping ("/NomeEmail/{nome}/{email}")
    public List<ClienteModel> ListarNomeEmail (@PathVariable (value="nome") String nome, @PathVariable (value="email") String email)
    {
        return cliRepo.findByNomeEmail(nome, email);
    }


}
