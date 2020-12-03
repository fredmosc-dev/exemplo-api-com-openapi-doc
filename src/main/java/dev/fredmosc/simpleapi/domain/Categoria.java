package dev.fredmosc.simpleapi.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String code;

    private String name;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PrePersist
    private void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nome='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
