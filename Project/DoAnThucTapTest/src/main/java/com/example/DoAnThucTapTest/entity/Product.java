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
    @Column(name = "ram")
    private String ram;
    @Column(name = "rom")
    private String rom;
    @Column(name = "price")
    private float price;

    @ManyToOne
    @JoinColumn(name = "id_cate")
    private Category id_cate;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand id_brand;

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

    public Brand getId_brand() {
        return id_brand;
    }

    public void setId_brand(Brand id_brand) {
        this.id_brand = id_brand;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public Product(String title, String image, String description, String content, String ram, String rom, float price, Category id_cate, Brand id_brand, int status) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.content = content;
        this.price = price;
        this.id_cate = id_cate;
        this.id_brand = id_brand;
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
                ", ram='" + ram + '\'' +
                ", rom='" + rom + '\'' +
                ", price=" + price +
                ", id_cate=" + id_cate +
                ", id_brand=" + id_brand +
                ", status=" + status +
                '}';
    }
}
