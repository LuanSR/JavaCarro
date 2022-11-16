package com.example.ProjCarLL.repository;

import com.example.ProjCarLL.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteModel,Integer> {

    public List<ClienteModel> findByNome (String nome);
    public List<ClienteModel> findByEmail (String email);
    @Query(value = "select c from ClienteModel c where c.nome like ?1%")
    public List<ClienteModel> findByNInicial (String nome);

    @Query (value = "select c from ClienteModel c where c.codigo > ?1")
    public List<ClienteModel> findByCodMaior (int codigo);

    @Query(value = "select c from ClienteModel c where c.email like ?1%")
    public List<ClienteModel> findByEInicial (String email);

    @Query (value = "select c from ClienteModel c where c.nome like %?1% and c.email like %?2%")
    public List<ClienteModel>findByNomeEmail (String nome, String email);
}
