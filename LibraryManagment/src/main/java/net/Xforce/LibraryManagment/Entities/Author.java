package net.Xforce.LibraryManagment.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name = "authors")
public class Author {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

@Column(name = "name",length = 100,nullable = false,unique = true)
	private String name;
@Column(name = "descriptions",length = 250,nullable = false)
	private String description;


@ManyToMany(mappedBy = "authors",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private Set<Book> books=new HashSet<Book>();



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Author() {
	super();
}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Author(String description, String name) {
		this.description = description;

		this.name = name;

	}
}
