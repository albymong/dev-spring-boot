package me.albymong.devspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import me.albymong.devspringboot.data.entity.ListenerEntity;
import me.albymong.devspringboot.service.ListenerService;

@RestController
@RequestMapping("/listener")
public class ListenerController {

    private ListenerService listenerService;

    @Autowired
    public ListenerController(ListenerService listenerService){
        this.listenerService = listenerService;
    }

    @GetMapping
    public String getListener(Long id){
        listenerService.getEntity(id);

        return "OK";
    }

    @PostMapping
    public void saveListener(String name){
        ListenerEntity listener = new ListenerEntity();
        listener.setName(name);

        listenerService.saveEntity(listener);
    }

    @PutMapping
    public void updateListener(Long id, String name){
        ListenerEntity listener = new ListenerEntity();
        listener.setId(id);
        listener.setName(name);

        listenerService.updateEntity(listener);
    }

    @DeleteMapping
    public void deleteListener(Long id){
        ListenerEntity listener = listenerService.getEntity(id);

        listenerService.removeEntity(listener);
    }

}
