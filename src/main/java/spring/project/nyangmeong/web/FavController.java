// package spring.project.nyangmeong.web;

// import javax.servlet.http.HttpSession;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

// import lombok.RequiredArgsConstructor;
// import spring.project.nyangmeong.web.api.dto.fav.FavDto;

// @RequiredArgsConstructor
// @Controller
// public class FavController {
// @RequestMapping(value = "/s/user/{id}/favlist")
// public @ResponseBody String FavCart(@PathVariable("productId") String
// productId, HttpSession session) {

// private final FavService favService;

// FavDto dto = (FavDto) session.getAttribute("login");
// String userid = dto.getUserid();
// /* 로그인 되어있는 정보를 이용해서 userid를 가져온다 */
// FavDto favDto = new FavDto();
// /* 객체를 생성하고 */
// favDto.setUserid(userid);
// favDto.setProductId(productId);
// /* 객체 안에 userid와 productId를 set해준다 */

// boolean istAlreadyExisted = favService.findFavGoods(favDto);
// /* 이미 해당 상품이 카트에 존재하는지 여부를 판별해주는 메서드 */
// System.out.println("istAlreadyExisted : " + istAlreadyExisted);

// if (istAlreadyExisted) {
// return "already_existed";
// /* 만약 이미 저장되어있다면, already_existed를 리턴 */
// } else {
// favService.addGoodsInFav(favDto);
// return "add_success";
// /* 없으면 저장 후, add_success를 리턴 */
// }
// }
// }