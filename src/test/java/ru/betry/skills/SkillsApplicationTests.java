package ru.betry.skills;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.betry.skills.entity.Language;
import ru.betry.skills.entity.Skill;
import ru.betry.skills.repository.SkillRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SkillsApplicationTests {

	@MockBean
	private SkillRepository skillRepository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testReturn() throws Exception {
		given(skillRepository.findById(any()))
				.willReturn(Optional.of(new Skill(1L, "Java", "Test Description")));

		mockMvc.perform(get("/skills/1"))
				.andExpect(status().isOk())
				.andExpect(content()
					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	@Test
	void testRepository() {
		given(skillRepository.findById(any()))
				.willReturn(Optional.of(new Skill(1L, "Java", "Test Description")));

		System.out.println(skillRepository.findById(2L).get().getTitle());

		assertEquals(skillRepository.findById(2L).get().getTitle(), "Java");
	}

	@Test
	void equals() {
		assertEquals(42, 42);
	}

	@Test
	void bool() {
		assertTrue(true);
		assertFalse(false);
	}

	@Test
	void language() {
		Language language = new Language(1L, "Java", "Test description", null);
//		assertNull(language);
		assertNotNull(language);
		assertEquals(language.getId(), 1L);
	}

}
