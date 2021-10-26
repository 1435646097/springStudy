package com.paigu.interview.entity;

import java.math.BigDecimal;

/**
 * 书
 *
 * @author LiaoXM
 * @date 2021/08/31
 */
public class Book {
	public Book(){
	}
   public  Book(String bookName){;
		this.bookName = bookName;
   }
	public Book(String bookName, BigDecimal bookPrice){
		this(bookName);
		this.bookPrice = bookPrice;
	}

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
}
