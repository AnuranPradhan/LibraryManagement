package net.Xforce.LibraryManagment.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Publisher")
public class Publisher {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
	@Column(name = "name",length = 100,nullable = false,unique = true)
		private String name;

	@ManyToMany(mappedBy = "publishers",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
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

	public Publisher() {
		super();
	}

	public Publisher(String name) {
		this.name = name;
	}
}
