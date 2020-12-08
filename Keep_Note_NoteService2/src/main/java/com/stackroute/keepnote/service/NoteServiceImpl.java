package com.stackroute.keepnote.service;

import java.util.*;

import com.stackroute.keepnote.exception.NoteNotFoundExeption;
import com.stackroute.keepnote.model.Note;
import com.stackroute.keepnote.model.NoteUser;
import com.stackroute.keepnote.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */

@Service
public class NoteServiceImpl implements NoteService{

	/*
	 * Autowiring should be implemented for the NoteRepository and MongoOperation.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */
	private NoteRepository noteRepository;
	private NoteUser noteUser = null;
	private List<Note> notes = null;

	@Autowired
	public NoteServiceImpl(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	/*
	 * This method should be used to save a new note.
	 */
	public boolean createNote(final Note note) {
		boolean saved = false;
		noteUser = new NoteUser();
		notes = new ArrayList<>();
		note.setNoteCreationDate(new Date());
		NoteUser findByUserId = noteRepository.findByUserId(note.getNoteCreatedBy());
		if (findByUserId != null) {
			if(findByUserId.getNotes() !=null && !findByUserId.getNotes().isEmpty()) {
				notes = findByUserId.getNotes();
				int lastNoteId = notes.get(findByUserId.getNotes().size() - 1).getNoteId();
				note.setNoteId(lastNoteId + 1);
				findByUserId.getNotes().add(note);
			}else{
				note.setNoteId(1);
				findByUserId.getNotes().add(note);
			}
			if (noteRepository.save(findByUserId) != null) {
				saved = true;
			}
		} else {
			findByUserId = new NoteUser();
			findByUserId.setUserId(note.getNoteCreatedBy());
			note.setNoteId(1);
			if(findByUserId.getNotes() == null){
				findByUserId.setNotes(new ArrayList<>());
			}
			findByUserId.getNotes().add(note);
			if (noteRepository.insert(findByUserId) != null) {
				saved = true;
			}
		}
		return saved;
	}

	/* This method should be used to delete an existing note. */

	public boolean deleteNote(final String userId, final int noteId) {
		boolean deleted = false;
		noteUser = new NoteUser();
		notes = noteRepository.findById(userId).get().getNotes();
		if(!notes.isEmpty()) {
			if(notes.stream().anyMatch(note -> note.getNoteId() == noteId)) {
				notes.removeIf(note -> note.getNoteId() == noteId);
				noteUser.setUserId(userId);
				noteUser.setNotes(notes);
				noteRepository.save(noteUser);
				deleted = true;
			}
		}
		return deleted;
	}

	/* This method should be used to delete all notes with specific userId. */


	public boolean deleteAllNotes(final String userId) throws NoteNotFoundExeption {
		boolean deleted = false;
		noteUser = new NoteUser();
		try {
			notes = noteRepository.findById(userId).get().getNotes();
			if (notes != null) {
				notes.removeAll(notes);
				noteUser.setUserId(userId);
				noteUser.setNotes(notes);
				noteRepository.save(noteUser);
				deleted = true;
			}
		}catch (NoSuchElementException e){
			throw new NoteNotFoundExeption("Note not found");
		}
		return deleted;
	}

	/*
	 * This method should be used to update a existing note.
	 */
	public Note updateNote(final Note note, final int id, final String userId) throws NoteNotFoundExeption {

		Note updateNote = null;
		noteUser = new NoteUser();
		try {
			notes = noteRepository.findById(userId).get().getNotes();
			if (!notes.isEmpty()) {
				Optional<Note> foundNote = notes.stream().filter(note1 -> note1.getNoteId() == id).findAny();
				if (foundNote.isPresent()) {
					updateNote = foundNote.get();
					updateNote.setNoteTitle(note.getNoteTitle());
					updateNote.setNoteContent(note.getNoteContent());
					updateNote.setNoteStatus(note.getNoteStatus());
					updateNote.setNoteCreationDate(new Date());
					updateNote.setNoteCreatedBy(userId);
					updateNote.setCategory(note.getCategory());
					updateNote.setReminders(note.getReminders());

					noteUser.setUserId(userId);
					noteUser.setNotes(notes);
					noteRepository.save(noteUser);
				} else {
					throw new NoteNotFoundExeption("Note not found");
				}
			}
		}catch(NoSuchElementException e){
			throw new NoteNotFoundExeption("Note not found");
		}
		return updateNote;
	}

	/*
	 * This method should be used to get a note by noteId created by specific user
	 */
	public Note getNoteByNoteId(final String userId, final int noteId) throws NoteNotFoundExeption {

		Note foundNote = null;
		try {
			notes = noteRepository.findById(userId).get().getNotes();
			if (notes != null) {
				Optional<Note> optionalNote = notes.stream().filter(note -> note.getNoteId() == noteId).findAny();
				if (optionalNote.isPresent()) {
					foundNote = optionalNote.get();
				} else {
					throw new NoteNotFoundExeption("Note not found");
				}
			}
		}catch (NoSuchElementException e){
			throw new NoteNotFoundExeption("Note not found");
		}
		return foundNote;
	}

	/*
	 * This method should be used to get all notes with specific userId.
	 */
	public List<Note> getAllNoteByUserId(final String userId) {

		return noteRepository.findById(userId).get().getNotes();
	}
}
