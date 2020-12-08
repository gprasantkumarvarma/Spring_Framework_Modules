package com.stackroute.keepnote.controller;

import com.stackroute.keepnote.exception.NoteNotFoundExeption;
import com.stackroute.keepnote.model.Note;
import com.stackroute.keepnote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/*
 * As in this assignment, we are working with creating RESTful web service, hence annotate
 * the class with @RestController annotation.A class annotated with @Controller annotation
 * has handler methods which returns a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized 
 * format. Starting from Spring 4 and above, we can use @RestController annotation which 
 * is equivalent to using @Controller and @ResposeBody annotation
 */

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class NoteController {

	/*
	 * Autowiring should be implemented for the NoteService. (Use Constructor-based
	 * autowiring) Please note that we should not create any object using the new
	 * keyword
	 */
	private NoteService noteService;

	@Autowired
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}

	/*
	 * Define a handler method which will create a specific note by reading the
	 * Serialized object from request body and save the note details in the
	 * database.This handler method should return any one of the status messages
	 * basis on different situations:
	 * 1. 201(CREATED) - If the note created successfully.
	 * 2. 409(CONFLICT) - If the noteId conflicts with any existing user.
	 *
	 * This handler method should map to the URL "/api/v1/note" using HTTP POST method
	 */
	@PostMapping("/api/v1/note")
	public ResponseEntity<?> createNote(@RequestBody Note note){
		try {
			note.setNoteCreationDate(new Date());
			if (noteService.createNote(note)) {
				return new ResponseEntity<Note>(note, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<String>("Conflict", HttpStatus.CONFLICT);
			}
		}catch (Exception exception){
			exception.printStackTrace();
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
		}
	}

	/*
	 * Define a handler method which will delete a note from a database.
	 * This handler method should return any one of the status messages basis
	 * on different situations:
	 * 1. 200(OK) - If the note deleted successfully from database.
	 * 2. 404(NOT FOUND) - If the note with specified noteId is not found.
	 *
	 * This handler method should map to the URL "/api/v1/note/{id}" using HTTP Delete
	 * method" where "id" should be replaced by a valid noteId without {}
	 */
	@DeleteMapping("/api/v1/note/{userId}/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable String userId, @PathVariable() int id) {
		boolean deleted = noteService.deleteNote(userId, id);
		if (deleted) {
			Map<String,Boolean> deletedMap = new HashMap<>();
			deletedMap.put("deleted", deleted);
			return new ResponseEntity<Map<String, Boolean>>(deletedMap, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Note not found", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/api/v1/note/{userId}")
	public ResponseEntity<String> deleteAllNotes(@PathVariable() String userId) {
		try {
			noteService.deleteAllNotes(userId);
			return new ResponseEntity<String>("All notes deleted Successfully", HttpStatus.OK);
		} catch (NoteNotFoundExeption exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * Define a handler method which will update a specific note by reading the
	 * Serialized object from request body and save the updated note details in a
	 * database.
	 * This handler method should return any one of the status messages
	 * basis on different situations:
	 * 1. 200(OK) - If the note updated successfully.
	 * 2. 404(NOT FOUND) - If the note with specified noteId is not found.
	 *
	 * This handler method should map to the URL "/api/v1/note/{id}" using HTTP PUT method.
	 */
	@PutMapping("/api/v1/note/{userId}/{id}")
	public ResponseEntity<?> updateNote(@PathVariable() String userId, @PathVariable() int id, @RequestBody Note note) {
		try {
			Note updatedNote = noteService.updateNote(note, id, userId);
			return new ResponseEntity<Note>(updatedNote, HttpStatus.OK);
		} catch (NoteNotFoundExeption exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * Define a handler method which will get us the all notes by a userId.
	 * This handler method should return any one of the status messages basis on
	 * different situations:
	 * 1. 200(OK) - If the note found successfully.
	 *
	 * This handler method should map to the URL "/api/v1/note" using HTTP GET method
	 */
	@GetMapping("/api/v1/note/{userId}")
	public ResponseEntity<?> getAllNoteByUserId(@PathVariable() String userId) {
		try {
			List<Note> userNotes = noteService.getAllNoteByUserId(userId);
			if (userNotes != null) {
				return new ResponseEntity<List<Note>>(userNotes, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Notes not found", HttpStatus.OK);
			}
		}catch (NoSuchElementException exception){
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * Define a handler method which will show details of a specific note created by specific
	 * user. This handler method should return any one of the status messages basis on
	 * different situations:
	 * 1. 200(OK) - If the note found successfully.
	 * 2. 404(NOT FOUND) - If the note with specified noteId is not found.
	 * This handler method should map to the URL "/api/v1/note/{userId}/{noteId}" using HTTP GET method
	 * where "id" should be replaced by a valid reminderId without {}
	 *
	 */
	@GetMapping("/api/v1/note/{userId}/{noteId}")
	public ResponseEntity<?> getNoteById(@PathVariable() String userId, @PathVariable() int noteId) {
		try {
			Note note = noteService.getNoteByNoteId(userId, noteId);
			return new ResponseEntity<Note>(note, HttpStatus.OK);
		} catch (NoteNotFoundExeption exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
