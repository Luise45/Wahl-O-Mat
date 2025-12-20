package htw.gruppe.backend.record;

import htw.gruppe.backend.entity.KandidatenAntwort;
import jakarta.validation.constraints.NotNull;
// fur post enpoint
/**
 * Request Dto
 * <p>
 * Für den Post Kandidaten Antworten Endpunkt.
 * </p>
 */
public record KandidatenAntwortenRequestDto (
   @NotNull Long aussage_id,
    int answerValue
)
{}
