package com.ivzh.neo4j.example.tree.repositories;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ivzh.neo4j.example.tree.domain.Document;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class DocumentRepositoryTest {

	@Autowired
	private DocumentRepository documentRepository;

	private Long id;

	@Before
	public void setUp() {
		Document p = new Document("p");		

		Document save = documentRepository.save(p);

		id = save.getId();
	}

	@Test
	public void testTree() {

		// get saved doc
		Document byId = documentRepository.findById(id).get();
		
		assertNotNull(byId);
		
		// store child 
		Document c = new Document("c"); 
		c.setParent(byId);
		byId.addChild(c);		
		documentRepository.save(byId);
		
		
		// test parent-child
		Document test = documentRepository.findById(id).get();			

		Set<Document> children = test.getChildren();

		assertNotNull(children);
		assertEquals(1, children.size());

		for (Document doc : children) {
			assertEquals(id, doc.getParent().getId());
		}
	}
}