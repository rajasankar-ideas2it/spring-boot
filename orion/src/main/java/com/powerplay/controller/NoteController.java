package com.powerplay.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.powerplay.dto.NoteDTO;
import com.powerplay.entity.Note;
import com.powerplay.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@GetMapping()
	public List<Note> getAllNotes() {
		return noteService.getAllNotes();
	}

	@GetMapping("/{id}")
	public Note getNote(@PathVariable(value = "id") Long id) throws Exception {
		return noteService.getNoteById(id);
	}

	@PostMapping()
	public Note saveNote(@Valid @RequestBody NoteDTO note) {
		return noteService.saveNote(note);
	}

	@PutMapping("/{id}")
	public Note updateNote(@PathVariable(value = "id") Long id, @Valid @RequestBody NoteDTO note) throws Exception {
		return noteService.updateNote(id, note);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long id) throws Exception {
		noteService.deleteNote(id);
		return ResponseEntity.ok().build();
	}
}
