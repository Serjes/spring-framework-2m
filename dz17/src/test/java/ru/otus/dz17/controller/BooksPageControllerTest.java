package ru.otus.dz17.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(BooksPageController.class)
public class BooksPageControllerTest {

//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private LibraryService libraryService;
//
//    @Configuration
//    @ComponentScan(basePackageClasses = {BookController.class})
//    public static class TestConf {
//    }
//
//
//    @Test
//    public void booksPage() throws Exception {
//        mvc.perform(get("/books"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("books"));
//    }

}