package com.example.AIBooks.bookAuthors;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookAuthors")
public class AuthorController {
    final private AuthorService authorService;

    @PutMapping(path="/update/{authorId}")
    public ResponseEntity<Author> updateAuthor(
            @PathVariable("authorId") Long authorId,
            @RequestBody ModifyAuthorReq request
    ) {
        Author updatedAuthor = authorService.updateAuthor(authorId, request.getAuthorName(), request.getBio());
        return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
    }

    @GetMapping(path="/get/{authorId}")
    public ResponseEntity<Author> getAuthor(
            @PathVariable("authorId") Long authorId
    ){
        Author author= authorService.getAuthor(authorId);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @GetMapping(path="/get-all")
    public ResponseEntity<List<Author>> getAllAuthor(){
        List<Author> authors= authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Author> createAuthor(
            @RequestBody NewAuthorReq request
    ) {
        Author newAuthor = authorService.createAuthor(
                request.getAuthorName(),
                request.getBio());
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }

    @DeleteMapping(path="/delete/{authorId}")
    public ResponseEntity<AuthGenRes> deleteStudent(
            @PathVariable("authorId") Long authorId
    ){
        authorService.deleteAuthor(authorId);

        AuthGenRes deleteResponse = new AuthGenRes();
        deleteResponse.setMessage("Author deleted successfully");
        deleteResponse.setStatusCode(200);

        return ResponseEntity.ok(deleteResponse);
    }

}