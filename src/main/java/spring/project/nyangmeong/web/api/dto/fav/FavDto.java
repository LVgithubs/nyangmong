package spring.project.nyangmeong.web.api.dto.fav;

import java.io.Serializable;
import java.util.Date;

public class FavDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userid; // 회원 id
    private String productId; // 상품 id
    private Date regDate; // 생성일자

    public FavDto() {
    }

    public FavDto(String userid, String productId, Date regDate) {
        super();
        this.userid = userid;
        this.productId = productId;
        this.regDate = regDate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "FavDto [userid=" + userid + ", productId=" + productId + ", regDate=" + regDate + "]";
    }
}