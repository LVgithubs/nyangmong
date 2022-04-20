package spring.project.nyangmeong.domain.fav;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.project.nyangmeong.domain.user.User;
import spring.project.nyangmeong.places.Places;

// 즐겨찾기
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
// @Table(uniqueConstraints = {
// @UniqueConstraint(name = "fav_uk", columnNames = { "userId", "placesId" })
// })
public class Fav {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    @JoinColumn(name = "placesId")
    @ManyToOne
    private Places places;

}