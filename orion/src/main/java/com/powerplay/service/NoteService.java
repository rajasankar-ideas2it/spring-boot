package com.powerplay.service;

import java.util.List;

import javax.validation.Valid;

import com.powerplay.dto.NoteDTO;
import com.powerplay.entity.Note;

public interface NoteService {

	List<Note> getAllNotes();

	Note getNoteById(Long id) throws Exception;

	Note saveNote(NoteDTO note);

	Note updateNote(Long id, @Valid NoteDTO note) throws Exception;

	void deleteNote(Long id) throws Exception;

}
