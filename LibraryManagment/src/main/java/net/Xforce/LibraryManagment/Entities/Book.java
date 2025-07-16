package net.Xforce.LibraryManagment.Entities;

import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name",length = 100,nullable = false)
	private String name;
	@Column(name = "descriptions",length = 250,nullable = false)
	private String description;
	@Column(name = "isbn",length = 50,nullable = false,unique = true)
	private String isbn;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "books_author",
	joinColumns = {@JoinColumn(name = "book_id")},
			inverseJoinColumns = {@JoinColumn(name = "author_id")})
	private Set<Author> authors = new HashSet<Author>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "books_category",
			joinColumns = {@JoinColumn(name = "book_id")},
			inverseJoinColumns = {@JoinColumn(name = "category_id")})
	private Set<Category> categories = new HashSet<Category>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "books_publisher",
			joinColumns = {@JoinColumn(name = "book_id")},
			inverseJoinColumns = {@JoinColumn(name = "publisher_id")})
	private Set<Publisher> publishers = new HashSet<Publisher>();

	public void addPublisher(Publisher publisher) {
		this.publishers.add(publisher);
		publisher.getBooks().add(this);
	}

	public void removePublisher(Publisher publisher) {
		this.publishers.remove(publisher);
		publisher.getBooks().remove(this);
	}
	public void addAuthor(Author author) {
		this.authors.add(author);
		author.getBooks().add(this);
	}

	public void removeAuthor(Author author) {
		this.authors.remove(author);
		author.getBooks().remove(this);
	}
	public void addCategory(Category category) {
		this.categories.add(category);
		category.getBooks().add(this);
	}

	public void removeCategory(Category category) {
		this.categories.remove(category);
		category.getBooks().remove(this);
	}
	public Set<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}

	public Book() {

	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Book( String name, String description, String isbn) {
		this.name = name;
		this.description = description;
		this.isbn = isbn;

	}
}
