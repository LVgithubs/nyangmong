package spring.project.nyangmeong.web.api.dto.user;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class UserDto {
    private long id;
    private String email;
    private String phone;
    private String name;
    private String title;
    private String website;
    private String profileImgUrl;
}