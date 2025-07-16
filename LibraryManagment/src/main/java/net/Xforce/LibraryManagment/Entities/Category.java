package net.Xforce.LibraryManagment.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;



@Entity
@Table(name = "Categories")
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name",length = 100,nullable = false,unique = true)
	private String name;


	@ManyToMany(mappedBy = "categories",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private Set<Book> books=new HashSet<Book>();

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

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

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}
}
