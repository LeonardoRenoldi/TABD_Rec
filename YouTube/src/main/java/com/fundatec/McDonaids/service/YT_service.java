package com.fundatec.McDonaids.service;

import com.fundatec.McDonaids.model.youTube;
import com.fundatec.McDonaids.repository.youTubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class YT_service {

    private  youTubeRepository youTubeRepository;

    public void deletarProduto(Integer id) {
        youTubeRepository.deleteById(id);
    }

}
