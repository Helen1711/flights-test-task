package ua.com.lena.flights.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.com.lena.flights.entities.Aircompany;
import ua.com.lena.flights.entities.AircompanyType;
import ua.com.lena.flights.exceptions.AircompanyDuplicateNameException;
import ua.com.lena.flights.exceptions.EntityNotFoundException;
import ua.com.lena.flights.repository.AircompanyRepository;
import ua.com.lena.flights.service.AircompanyService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AircompanyServiceImplTest {
    @Mock
    private AircompanyRepository mockRepository;
    private AircompanyService service;

    @BeforeEach
    void setUp() {
        service = new AircompanyServiceImpl(mockRepository);
    }

    @Test
    void shouldSaveAircompany() {
        var aircompany = new Aircompany(LocalDate.of(2020, 1, 1), "name", AircompanyType.LOW_COST);
        when(mockRepository.save(any())).thenReturn(aircompany);

        var existedAircompany = service.save(aircompany);

        assertThat(existedAircompany).isEqualTo(aircompany);
    }

    @Test
    void shouldReturnAllCompanies() {
        var aircompanies = List.of(new Aircompany(LocalDate.of(2020, 1, 1), "name", AircompanyType.LOW_COST));
        when(mockRepository.findAll()).thenReturn(aircompanies);

        var result = service.getAll();

        assertThat(aircompanies).hasSameElementsAs(result);
    }

    @Test
    void shouldReturnEmptyListForAbsentCompanies() {
        when(mockRepository.findAll()).thenReturn(List.of());

        var result = service.getAll();

        Assertions.assertThat(List.of()).isEqualTo(result);
    }

    @Test
    void shouldUpdateCompany() {
        var aircompany = new Aircompany(LocalDate.of(2020, 1, 1), "name", AircompanyType.LOW_COST);
        when(mockRepository.save(any())).thenReturn(aircompany);

        var result = service.update(15L, aircompany);

        assertThat(result).isEqualTo(aircompany);
    }

    @Test
    void shouldThrowAircompanyDuplicateNameExceptionIfCompanyIsPresent() {
        var aircompany = new Aircompany(LocalDate.of(2020, 1, 1), "name", AircompanyType.LOW_COST);
        when(mockRepository.findByName(any())).thenReturn(Optional.of(aircompany));

        assertThatThrownBy(() -> service.checkIfPresentByName(aircompany.getName()))
                .isInstanceOf(AircompanyDuplicateNameException.class)
                .hasMessage("Aircompany with name already exists " + aircompany.getName());
    }

    @Test
    void shouldReturnCompanyById() {
        var aircompany = Optional.of(new Aircompany(LocalDate.of(2020, 1, 1), "name", AircompanyType.LOW_COST));
        when(mockRepository.findById(any())).thenReturn(aircompany);

        var result = service.getById(1L);

        assertThat(result).isEqualTo(aircompany.get());

    }

    @Test
    void shouldThrowEntityNotFoundExceptionIfCompanyIsAbsent() {
        when(mockRepository.findById(any())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.getById(10L))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("Not found aircompany with id " + 10L);
    }
}