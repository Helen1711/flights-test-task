package ua.com.lena.flights.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Aircompany extends AbstractEntity {
    @Size(min = 3, max = 20)
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    @NotNull
    private AircompanyType type;
    @Column(name = "founded_at")
    private LocalDate foundedAt;

    public Aircompany() {
    }

    public Aircompany(@Size(min = 3, max = 20) String name, @NotNull AircompanyType type, LocalDate foundedAt) {
        this.name = name;
        this.type = type;
        this.foundedAt = foundedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AircompanyType getType() {
        return type;
    }

    public void setType(AircompanyType type) {
        this.type = type;
    }

    public LocalDate getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(LocalDate foundedAt) {
        this.foundedAt = foundedAt;
    }
}
