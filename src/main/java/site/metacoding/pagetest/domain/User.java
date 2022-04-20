package site.metacoding.pagetest.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    @Column(nullable = false, length = 300)
    private String phone; // API 주소 라이브러리 사용할 예정

    @Column(nullable = true, length = 300)
    private String profileImg; // 이미지 파일 전송 받아서 서버에 두고, 그 경로를 디비에 저장

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;
}