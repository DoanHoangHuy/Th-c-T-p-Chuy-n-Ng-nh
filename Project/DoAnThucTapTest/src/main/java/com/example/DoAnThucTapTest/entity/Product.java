package com.example.DoAnThucTapTest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private String description;
    @Column(name = "content")
    private String content;
    @Column(name = "price")
    private float price;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}) // hoac Cascade.ALL
    @JoinColumn(name = "id_cate")
    private Category id_cate;

    @Column(name = "status")
    private int status;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getId_cate() {
        return id_cate;
    }

    public void setId_cate(Category id_cate) {
        this.id_cate = id_cate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Product( String title, String image, String description, String content, float price, Category id_cate, int status) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.content = content;
        this.price = price;
        this.id_cate = id_cate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", id_cate=" + id_cate +
                ", status=" + status +
                '}';
    }
}
