package ua.com.lena.flights.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Aircompany extends AbstractEntity {
    @Size(min = 3, max = 40)
    @Column(unique = true)
    @NotNull
    private String name;
    @Enumerated(EnumType.STRING)
    @NotNull
    private AircompanyType type;

    public Aircompany() {
    }

    public Aircompany(LocalDate createdAt, @Size(min = 3, max = 40) @NotNull String name, @NotNull AircompanyType type) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Aircompany that = (Aircompany) o;
        return Objects.equals(name, that.name) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, type);
    }
}
