package com.powerplay.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powerplay.dto.NoteDTO;
import com.powerplay.entity.Note;
import com.powerplay.exception.EntityNotFoundException;
import com.powerplay.exception.ErrorResponse;
import com.powerplay.repository.NoteRepository;
import com.powerplay.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepository noteRepository;

	@Override
	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}

	@Override
	public Note getNoteById(Long id) throws Exception {
		return noteRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(new ErrorResponse(404, "Note Id not found")));
	}

	@Override
	public Note saveNote(NoteDTO noteDTO) {
		Note note = new Note();
		note.setDescription(noteDTO.getDescription());
		note.setTitle(noteDTO.getTitle());
		return noteRepository.save(note);
	}

	@Override
	public Note updateNote(Long id, @Valid NoteDTO note) throws Exception {
		Note oldNote = noteRepository.findById(id).orElseThrow(() -> new Exception("Note Id not Found"));
		oldNote.setDescription(note.getDescription());
		oldNote.setTitle(note.getTitle());
		return noteRepository.save(oldNote);
	}

	@Override
	public void deleteNote(Long id) throws Exception {
		Note note = noteRepository.findById(id).orElseThrow(() -> new Exception("Note Id not Found"));
		noteRepository.delete(note);
	}

}
