package com.jellybean.api.controller;

import com.jellybean.api.entity.LecturesEntity;
import com.jellybean.api.repository.LecturesRepository;
import com.jellybean.api.service.LecturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures")
public class LecturesControll {
    private final LecturesService lecturesService;

    /*
    @GetMapping("/main")
    public String lectures(){
        return "KDT 소개";
    }*/

    @GetMapping("/{lecName}")    //과정별 조회
    public ResponseEntity<Optional<LecturesEntity>>
    getLecturesByName(@PathVariable("lecName") String lecName) throws IllegalAccessException {
        Optional<LecturesEntity> lectures = lecturesService.getLecturesByName(lecName);
        return ResponseEntity.ok().body(lectures);
    }

}
