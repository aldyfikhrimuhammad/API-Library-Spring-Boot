package net.javaSpring.springBoot.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "Books")
@Entity
@Data
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(length = 100, nullable = false)
  private String title;

  @Column(length = 100)
  private String author;

  private boolean isDeleted = false;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  // Default constructor
  public Book() {
  }

  // Constructor
  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  // Getter
  public long getId() {
    return id;
  }
  public String getTitle() {
    return title;
  }
  public String getAuthor() {
    return author;
  }
  public boolean isDeleted() {
    return isDeleted;
  }

  // Setter
  public void setId(long id) {
    this.id = id;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public void setDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }
}