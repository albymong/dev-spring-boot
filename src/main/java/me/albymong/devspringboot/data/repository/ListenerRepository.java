package me.albymong.devspringboot.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.albymong.devspringboot.data.entity.ListenerEntity;

public interface ListenerRepository extends JpaRepository<ListenerEntity, Long> {

}
