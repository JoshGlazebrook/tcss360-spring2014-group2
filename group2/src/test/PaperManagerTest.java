package test;

import static org.junit.Assert.*;
import group2.Author;
import group2.Paper;
import group2.PaperManager;

import org.junit.Before;
import org.junit.Test;

public class PaperManagerTest {

	PaperManager manager;
	Paper paper;
	Author author;
	String paper_data;
	
	@Before
	public void setUp() throws Exception {
		paper_data = "some paper data";
		author = new Author("username", "password");
		paper = new Paper("paper1", author, paper_data);
		manager = new PaperManager("name");
	}

	@Test
	public void testAddPaper() {
		manager.addPaper(paper);
		assertEquals(paper, manager.getPaper(paper));
	}

	@Test
	public void testRemovePaperInt() {
		manager.addPaper(paper);
		manager.removePaper(paper);
		System.out.println(paper.getID());
		assertFalse(manager.hasPaper(paper));
	}

	@Test
	public void testRemovePaperPaper() {
		manager.addPaper(paper);
		manager.removePaper(paper);
		assertFalse(manager.hasPaper(paper));
	}

	@Test
	public void testHasPaperPaper() {
		manager.addPaper(paper);
		assertTrue(manager.hasPaper(paper));;
	}

	@Test
	public void testHasPaperInt() {
		manager.addPaper(paper);
		assertTrue(manager.hasPaper(paper));
	}

	@Test
	public void testGetPapers() {
		manager.addPaper(paper);
		Paper[] res = manager.getPapers();
		assertTrue(res != null);
	}

	@Test
	public void testGetPapersString() {
		manager.addPaper(paper);
		Paper[] res = manager.getPapers(author.getUserName());
		assertTrue(res != null);
	}

	@Test
	public void testGetPapersAuthor() {
		manager.addPaper(paper);
		Paper[] res = manager.getPapers(author);
		assertTrue(res != null);
	}

	@Test
	public void testGetPaper() {
		manager.addPaper(paper);
		assertEquals(paper, manager.getPaper(paper));
	}

}
