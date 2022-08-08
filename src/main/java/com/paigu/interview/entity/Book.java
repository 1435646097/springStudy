package com.paigu.interview.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.paigu.interview.aop.hide.HideAnnotation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Objects;


/**
 * 书
 *
 * @author LiaoXM
 * @date 2021/08/31
 */
@Data
@TableName("book")
public class Book {
    public Book() {
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, BigDecimal bookPrice) {
        this(bookName);
        this.bookPrice = bookPrice;
    }

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    @HideAnnotation(start = 2, end = 8)
    @NotBlank(message = "书名不能为空")
    private String bookName;
    private BigDecimal bookPrice;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public boolean equals(Object o) {
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
    public int hashCode() {
        return Objects.hash(bookName, bookPrice);
    }

    public void price(int price) {
        System.out.println("int ---" + price);
    }

    public void price(Integer price) {
        System.out.println("Integer ---" + price);
    }
}
