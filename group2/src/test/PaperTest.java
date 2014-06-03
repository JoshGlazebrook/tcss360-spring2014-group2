package test;
import static org.junit.Assert.*;
import group2.Author;
import group2.Paper;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Josh
 *
 */
public class PaperTest {

	Author author;
	String paper_data;
	Paper paper;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		author = new Author("name", "password");
		paper_data = "some paper data";
		paper = new Paper("name", author, paper_data);
	}

	/**
	 * Test method for {@link group2.Paper#getAuthor()}.
	 */
	@Test
	public void testGetAuthor() {
		assertEquals(author, paper.getAuthor());
	}

	/**
	 * Test method for {@link group2.Paper#getData()}.
	 */
	@Test
	public void testGetData() {
		assertEquals(paper_data, paper.getData());
	}

	/**
	 * Test method for {@link group2.Paper#getReviewed()}.
	 */
	@Test
	public void testGetReviewed() {
		assertFalse(paper.getReviewed());
	}

	/**
	 * Test method for {@link group2.Paper#setReviewedState(boolean)}.
	 */
	@Test
	public void testSetReviewedState() {
		paper.setReviewedState(true);
		assertTrue(paper.getReviewed());
	}

	/**
	 * Test method for {@link group2.Paper#getID()}.
	 */
	@Test
	public void testGetID() {
		assertEquals(paper_data.hashCode() ,paper.getID());
	}

}
