package com.example.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/monitores")
public class MonitorController {

    @Autowired
    private MonitorDao monitorDao;

    @GetMapping
    public List<Monitor> listarMonitores() {
        return monitorDao.findAll();
    }

    @GetMapping("/{id}")
    public Monitor obterMonitor(@PathVariable int id) {
        return monitorDao.findById(id).orElse(null);
    }

    @PostMapping
    public Monitor incluirMonitor(@RequestBody Monitor monitor) {
        return monitorDao.save(monitor);
    }

    @PutMapping("/{id}")
    public Monitor atualizarMonitor(@PathVariable int id, @RequestBody Monitor monitorAtualizado) {
        Monitor monitorExistente = monitorDao.findById(id).orElse(null);
        if (monitorExistente != null) {
            monitorExistente.setNome(monitorAtualizado.getNome());
            monitorExistente.setTipo(monitorAtualizado.getTipo());
            monitorExistente.setTamanho(monitorAtualizado.getTamanho());
            monitorExistente.setPreco(monitorAtualizado.getPreco());
            return monitorDao.save(monitorExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void excluirMonitor(@PathVariable int id) {
        monitorDao.deleteById(id);
    }
}
