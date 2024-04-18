package com.example.AIBooks.bookAuthors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModifyAuthorReq {
    private Long id;
    private String authorName;
    private String bio;
}

