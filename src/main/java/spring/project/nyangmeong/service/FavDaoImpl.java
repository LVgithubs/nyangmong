// package spring.project.nyangmeong.service;

// import javax.inject.Inject;

// import org.apache.ibatis.session.SqlSession;
// import org.springframework.stereotype.Repository;

// import spring.project.nyangmeong.web.api.dto.fav.FavDto;

// @Repository
// public class FavDaoImpl implements FavDao {

// @Inject
// private SqlSession sqlSession;

// private final String NS = "kr.co.cart";

// @Override
// public boolean findFavGoods(FavDto favDto) {
// String result = sqlSession.selectOne(NS + ".findFavGoods", favDto);
// return Boolean.parseBoolean(result);
// }

// @Override
// public void addGoodsInFav(FavDto favDto) {
// sqlSession.insert(NS + ".addGoodsInFav", favDto);
// }
// }