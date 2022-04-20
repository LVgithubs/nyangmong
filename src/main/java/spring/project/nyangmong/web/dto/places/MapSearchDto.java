package spring.project.nyangmong.web.dto.places;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MapSearchDto {

    private String keyword;
    private boolean cafe;
    private boolean hotel;
    private boolean activity;
    private boolean hospital;
    private boolean spot;
}
