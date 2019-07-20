package com.ivzh.neo4j.example.tree.repositories;

import static org.junit.Assert.*;

import java.util.Set;

import com.ivzh.neo4j.example.tree.domain.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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

		Document c = new Document("c");

		c.setParent(p);

		p.addChild(c);

		Document save = documentRepository.save(p);

		id = save.getId();
	}

	@Test
	public void testTree() {

		Document byId = documentRepository.findById(id).get();

		assertNotNull(byId);

		Set<Document> p = byId.getChildren();

		assertNotNull(p);
		assertEquals(1, p.size());

		for (Document pp : p) {
			assertEquals(id, pp.getParent().getId());
		}
	}
}