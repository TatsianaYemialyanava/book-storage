package com.dematic.testtask.bookstorage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="book_name")
	private String name;

	@Column(name="author")
	private String author;

	@Column(name="barcode")
	private Long barcode;

	@Column(name="quantity")
	private Integer quantity;

	@Column(name="price")
	private Double price;

	@Column(name="year")
	private Integer year;

	@Column(name="sc_index")  
	private Integer scIndex;

	public Book(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getBarcode() {
		return barcode;
	}

	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getScIndex() {
		return scIndex;
	}

	public void setScIndex(Integer scIndex) {
		this.scIndex = scIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}	
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (barcode == null) {
			if (other.barcode != null) {
				return false;
			}
		} else if (!barcode.equals(other.barcode)) {
			return false;
		}	
		if (id == null) {
			if (other.id != null) {
				return false;
			}	
		} else if (!id.equals(other.id)) {
			return false;
		}	
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}	
		return true;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", barcode=" + barcode + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
}

