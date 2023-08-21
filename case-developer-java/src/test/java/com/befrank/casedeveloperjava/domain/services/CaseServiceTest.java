package com.befrank.casedeveloperjava.domain.services;

import com.befrank.casedeveloperjava.DeelnemerMother;
import com.befrank.casedeveloperjava.domain.adapters.deelnemer.DeelnemerRepository;
import com.befrank.casedeveloperjava.domain.model.Deelnemer;
import com.befrank.casedeveloperjava.repositories.mock.MockPensioenRekeningRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class )
class CaseServiceTest {

    @Mock
    private DeelnemerRepository deelnemerRepository;
    @InjectMocks
    private CaseService caseService;
    private Deelnemer janeDoe;

    @BeforeEach
    void before() {
        caseService = new CaseService( new MockPensioenRekeningRepository(), deelnemerRepository);

        janeDoe = DeelnemerMother.janeDoe();
        janeDoe.setId( 15L );

        when(deelnemerRepository.findById( 15L )).thenReturn( Optional.of(janeDoe));
    }

    @Test
    void should_calculate_case() throws CaseService.DeelnemerNotFound
    {
        var totalPensioen = caseService.calculate( janeDoe.getId() );

        assertThat(totalPensioen).isEqualTo( BigDecimal.valueOf( 3320.91 ).setScale( 2, RoundingMode.HALF_UP ) );
    }


}
