package com.example.CPMO;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

enum petStatus{
    available,
    pending,
    sold
}

/*
NoArgsConstructor might not make sense when there are required properties (id, photoUrls)?
*/

@Entity // JPA -> Automatically links it with database of same name
@Data // Lombok -> Implements all GETs, SETs and common methods. Could use generate code option
@AllArgsConstructor // Lombok -> All Arguments Constructor
@NoArgsConstructor //  Lombok -> No Arguments Constructor
public class Pet {

    @Id // next variable will be used as Identifier for class
    @GeneratedValue(strategy = GenerationType.AUTO) // automatically generate Identifier when creating new Pet
    private Long id; // int64
    private String name;
    @ManyToOne // multiple pets can have the same category
    private Category category;
    @ElementCollection // JPA method for Lists
    private List<String> photoUrls; // XML only string?
    @ElementCollection
    private List<Tag> tags; // XML only also?
    private petStatus status; // String enum?

    public void photoUrlsAdd(String url){
        photoUrls.add(url);
    }
}
