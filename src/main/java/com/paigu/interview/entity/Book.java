package com.paigu.interview.entity;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 书
 *
 * @author LiaoXM
 * @date 2021/08/31
 */
public class Book {
	public Book(){
	}

	public Book(String bookName){
		this.bookName = bookName;
	}

	public Book(String bookName, BigDecimal bookPrice){
		this(bookName);
		this.bookPrice = bookPrice;
	}

	@NotBlank(message = "书名不能为空")
	private String bookName;
	private BigDecimal bookPrice;

	public String getBookName(){
		return bookName;
	}

	public void setBookName(String bookName){
		this.bookName = bookName;
	}

	public BigDecimal getBookPrice(){
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice){
		this.bookPrice = bookPrice;
	}

	@Override
	public boolean equals(Object o){
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Book book = (Book) o;
		return Objects.equals(bookName, book.bookName) && Objects.equals(bookPrice, book.bookPrice);
	}

	@Override
	public int hashCode(){
		return Objects.hash(bookName, bookPrice);
	}

	public void price(int price){
		System.out.println("int ---" + price);
	}

	public void price(Integer price){
		System.out.println("Integer ---" + price);
	}
}
