package library.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.web.dao.LibraryDAO;
import library.web.entity.Books;
import library.web.entity.Members;

@Service
public class LibraryServiceIMPL implements LibraryService {

	@Autowired
	private LibraryDAO libraryDAO;

	@Override
	@Transactional
	public List<Members> getMembers() {
		List<Members> members = libraryDAO.getMembers();
		List<Members> members1 = members.stream().distinct().collect(Collectors.toList());
		return members1;
	}

	@Override
	@Transactional
	public void deleteMember(int id) {
		libraryDAO.deleteMember(id);
	}

	@Override
	@Transactional
	public void saveMember(Members member) {
		libraryDAO.saveMember(member);
	}

	@Override
	@Transactional
	public Members getMember(int id) {
		Members member = libraryDAO.getMember(id);
		return member;
	}

	@Override
	@Transactional
	public void returnBook(int id) {
		libraryDAO.returnBook(id);
		
	}

	@Override
	@Transactional
	public Books getBook(int id) {
		Books book = libraryDAO.getBook(id);
		return book;
	}

	@Override
	@Transactional
	public List<Books> getBooks() {
		List<Books> books = libraryDAO.getBooks();
		return books;
	}

	@Override
	@Transactional
	public void saveBook(Books book) {
		libraryDAO.saveBook(book);
		
	}

	@Override
	@Transactional
	public void deleteBook(int id) {
		libraryDAO.deleteBook(id);
		
	}

	@Override
	@Transactional
	public List<Books> getBooksNoMembers() {
		List<Books> books = libraryDAO.getBooksNoMembers();
		return books;
	}

	@Override
	@Transactional
	public void loanBook(int id, int id2) {
		libraryDAO.loanBook(id, id2);
		
	}


}
