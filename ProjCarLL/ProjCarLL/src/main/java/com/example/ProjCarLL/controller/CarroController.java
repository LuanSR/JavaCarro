package com.example.ProjCarLL.controller;

import com.example.ProjCarLL.model.CarroModel;
import com.example.ProjCarLL.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/apiCarro")
public class CarroController {

    @Autowired
    CarroRepository carRepo;

    @GetMapping (value = "/todos")
    public List<CarroModel> buscarTodos()
    {
        return carRepo.findAll();
    }

    @PostMapping (value = "/inserir")
    public void inserirCarro(@RequestBody CarroModel ca)
    {
        carRepo.save(ca);
    }

    @DeleteMapping (value = "/excluir")
    public void excluirCarro(@RequestBody CarroModel ca)
    {
        carRepo.delete(ca);
    }

    @PutMapping (value = "/atualizar")
    public void atualizarCarro(@RequestBody CarroModel ca)
    {
        carRepo.save(ca);
    }

    @GetMapping (value = "/CarroCod/{codigo}")
    public Optional<CarroModel> buscarPorCodigo (@PathVariable(value = "codigo") int codigo) {
        return carRepo.findById(codigo);
    }

    @GetMapping (value = "/CarroDesc/{descricao}")
    public List<CarroModel> ListarPorDesc (@PathVariable (value="descricao") String descricao){
        return carRepo.findByDescricao(descricao);
    }

    @GetMapping (value = "/CarroMarca/{marca}")
    public List<CarroModel> ListarPorMarca (@PathVariable (value="marca") String marca){
        return carRepo.findByMarca(marca);
    }

    @GetMapping (value = "/CarroPreco/{preco}")
    public List<CarroModel> ListarPorPreco (@PathVariable (value="preco") double preco){
        return carRepo.findByPreco(preco);
    }

    @GetMapping ("/CarroDescInicial/{descricao}")
    public List<CarroModel> ListarPorInicialDesc (@PathVariable (value="descricao") String descricao)
    {
        return carRepo.findByDInicial(descricao);
    }

    @GetMapping ("/CarroMarcaInicial/{marca}")
    public List<CarroModel> ListarPorInicialMarca (@PathVariable (value="marca") String marca)
    {
        return carRepo.findByMInicial(marca);
    }

    @GetMapping ("/CarroPrecoMaior/{preco}")
    public List<CarroModel> ListarPorPrecoMaior (@PathVariable (value = "preco") double preco)
    {
        return carRepo.findByPrecoMaior(preco);
    }

    @GetMapping ("/CarroPrecoMenor/{preco}")
    public List<CarroModel> ListarPorPrecoMenor (@PathVariable (value = "preco") double preco)
    {
        return carRepo.findByPrecoMenor(preco);
    }

    @GetMapping ("/DescMarca/{descricao}/{marca}")
    public List<CarroModel> ListarDescMarca (@PathVariable (value="descricao") String descricao, @PathVariable (value="marca") String marca)
    {
        return carRepo.findByDescMarca(descricao, marca);
    }

    @GetMapping ("/DescPreco/{descricao}/{preco}")
    public List<CarroModel> ListarDescPreco (@PathVariable (value="descricao") String descricao, @PathVariable (value="preco") double preco)
    {
        return carRepo.findByDescPreco(descricao, preco);
    }
}
