package spring.project.nyangmeong.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.project.nyangmeong.domain.boards.Boards;
import spring.project.nyangmeong.domain.user.User;
import spring.project.nyangmeong.service.BoardsService;
import spring.project.nyangmeong.service.PlaceLikesService;
import spring.project.nyangmeong.web.api.dto.ResponseDto;
import spring.project.nyangmeong.web.api.dto.boards.DetailResponseDto;
import spring.project.nyangmeong.web.api.dto.boards.WriteDto;

@RequiredArgsConstructor
@RestController
public class BoardsApiController {
    private final BoardsService boardsService;
    private final PlaceLikesService placelikesService;

    private final HttpSession session;

    @PutMapping("/s/api/boards/{id}/update")
    public ResponseDto<?> updateById(Boards boards, @PathVariable Integer id) {
        boardsService.글수정하기(boards, id);

        return new ResponseDto<>(1, "성공", null);
    }

    @DeleteMapping("/s/api/boards/{id}/delete")
    public ResponseDto<?> deleteById(@PathVariable Integer id) {
        boardsService.글삭제하기(id);

        return new ResponseDto<>(1, "성공", null);
    }

    @GetMapping("/boards/{id}")
    public ResponseDto<?> detail(@PathVariable Integer id) {

        Boards boardsEntity = boardsService.글상세보기(id);
        User principal = (User) session.getAttribute("principal");
        boolean auth = false;

        if (principal != null) {

            if (principal.getId() == boardsEntity.getId()) {
                auth = true;
            }
        }

        DetailResponseDto detailResponseDto = new DetailResponseDto(boardsEntity, auth); // comment null
        return new ResponseDto<>(1, "성공", detailResponseDto); // comment 생성됨 = MessageConverter
    }

    @GetMapping("/boards")
    public ResponseDto<?> list(Integer page) {
        Page<Boards> boards = boardsService.게시글목록(page);
        // 응답의 DTO를 만들어서 <- posts 를 옮김. (라이브러리 있음)
        return new ResponseDto<>(1, "성공", boards);
    }

    @PostMapping("/s/boards/write")
    public ResponseDto<?> write(@RequestBody WriteDto writeDto) {

        User principal = (User) session.getAttribute("principal");
        Boards boards = writeDto.toEntity(principal);
        // 원래는 그냥 dto바로 넘겼는데, 지금 dto를 넘기면 session값 두개 넘겨야 해서 하나로 합쳐서 넘김
        boardsService.글쓰기(boards);

        return new ResponseDto<>(1, "성공", null);
    }

    @PostMapping("/s/user/{id}/boardlike")
    public void likes(@PathVariable long boardsId, Authentication authentication) {
        placelikesService.placelikes(boardsId, authentication.getUsername());
    }

    @DeleteMapping("/s/user/{id}/unboardlike")
    public void unLikes(@PathVariable long boardsId, Authentication authentication) {
        placelikesService.unplacelikes(boardsId, authentication.getUsername());
    }
}