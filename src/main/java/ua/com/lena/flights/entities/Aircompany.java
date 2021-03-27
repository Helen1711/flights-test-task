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

    public Aircompany() {
    }

    public Aircompany(LocalDate createdAt, @Size(min = 3, max = 20) String name, @NotNull AircompanyType type) {
        super(createdAt);
        this.name = name;
        this.type = type;
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
}
