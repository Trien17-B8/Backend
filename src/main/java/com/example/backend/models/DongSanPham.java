package com.example.backend.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "dong_sp")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DongSanPham {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "ma", unique = true, nullable = false, length = 20)
    private String ma;

    @Column(name = "ten", nullable = false, length = 30)
    @Nationalized
    private String ten;

}
