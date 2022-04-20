package spring.project.nyangmeong.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 2, max = 12, message = "아이디는 2자 이상 12자 이하로 입력해주세요.")
    @Column(unique = true, nullable = false, length = 12)
    private String username;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 2, max = 12, message = "비밀번호는 2자 이상 12자 이하로 입력해주세요.")
    @Column(nullable = false, length = 12)
    private String password;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Column(nullable = false, length = 300)
    private String email; // API 주소 라이브러리 사용할 예정

    // private String boardsList;

    @Builder
    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;
}