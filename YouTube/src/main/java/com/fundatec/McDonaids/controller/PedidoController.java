package com.fundatec.McDonaids.controller;



import com.fundatec.McDonaids.model.youTube;
import com.fundatec.McDonaids.repository.youTubeRepository;
import com.fundatec.McDonaids.service.YT_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private youTubeRepository repository;
    @Autowired
    private YT_service yt_service;


    public PedidoController(youTubeRepository youTubeRepository){
        this.repository = youTubeRepository;
    }

    @GetMapping("canalPorId/{id}")
    public youTube getProdutoById(@PathVariable("Id")Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping(value="/criarCanal")
    public ResponseEntity<youTube> createPedido(@RequestBody youTube youtube) {
        this.repository.save(youtube);
        return new ResponseEntity ("Criado com sucesso !",HttpStatus.CREATED);
    }

    @GetMapping("/canais")
    public List<youTube> getAllPedidos() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<youTube> deletarPedido(@PathVariable Integer id) {
        yt_service.deletarProduto(id);
        return new ResponseEntity("Deletado com sucesso !", HttpStatus.OK);
    }

    @RequestMapping(value = "/atualizar_seguidores/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<youTube> Put(@PathVariable(value = "seguidores") Integer seguidores,  @RequestBody youTube updateSeguidores)
    {
        Optional<youTube> seguidoresAntigos = repository.findById(seguidores);
        if(seguidoresAntigos.isPresent()){
            youTube canal = seguidoresAntigos.get();
           // canal.setSeguidores(newChannel.getTitle());
            repository.save(canal);
            return new ResponseEntity ("Atualizado com Sucesso !", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}



