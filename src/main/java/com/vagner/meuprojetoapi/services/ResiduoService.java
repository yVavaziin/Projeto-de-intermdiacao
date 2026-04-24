package com.vagner.meuprojetoapi.services;

import com.vagner.meuprojetoapi.models.Residuo;
import com.vagner.meuprojetoapi.repositories.ResiduoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ResiduoService {

    @Autowired
    private ResiduoRepository residuoRepository;

    public Residuo salvar(Residuo residuo) {
        // Se a data de coleta não for enviada pelo front-end,
        // nós definimos a data e hora atual do sistema aqui.
        if (residuo.getDataColeta() == null) {
            residuo.setDataColeta(LocalDateTime.now());
        }
        return residuoRepository.save(residuo);
    }
}