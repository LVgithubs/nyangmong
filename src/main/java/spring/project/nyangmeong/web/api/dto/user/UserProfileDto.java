package spring.project.nyangmeong.web.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.project.nyangmeong.domain.user.User;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class UserProfileDto {
    private long loginId;
    private String profileImgUrl;
    private boolean loginUser;
    private boolean follow;
    private User user;
    private int postCount;
    private int userFollowerCount;
    private int userFollowingCount;
}