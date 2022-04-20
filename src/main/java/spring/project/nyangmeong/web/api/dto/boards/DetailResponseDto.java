package spring.project.nyangmeong.web.api.dto.boards;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.project.nyangmeong.domain.boards.Boards;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailResponseDto {
    private Boards post;
    private boolean auth;
}