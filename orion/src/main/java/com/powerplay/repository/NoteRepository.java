package com.powerplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerplay.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
