package spring.project.nyangmeong.web.api.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.project.nyangmeong.domain.comment.Comment;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentResponseDto {
    private Comment comment;
    private boolean auth;
}