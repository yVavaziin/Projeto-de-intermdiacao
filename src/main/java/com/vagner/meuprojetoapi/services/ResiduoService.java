package com.vagner.meuprojetoapi.services;

import com.vagner.meuprojetoapi.models.Residuo;
import com.vagner.meuprojetoapi.repositories.ResiduoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResiduoService {

    @Autowired
    private ResiduoRepository residuoRepository;

    public Residuo salvar(Residuo residuo) {
        // Regra de negócio: sempre registra o horário exato da coleta
        residuo.setDataColeta(LocalDateTime.now());
        return residuoRepository.save(residuo);
    }

    public List<Residuo> buscarTodos() {
        return residuoRepository.findAll();
    }

}