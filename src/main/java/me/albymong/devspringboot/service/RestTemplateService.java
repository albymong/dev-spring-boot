package me.albymong.devspringboot.service;

import org.springframework.http.ResponseEntity;
import me.albymong.devspringboot.data.dto.MemberDTO;


public interface RestTemplateService {

    public String getAroundHub();

    public String getName();

    public String getName2();

    public ResponseEntity<MemberDTO> postDto();

    public ResponseEntity<MemberDTO> addHeader();

}
