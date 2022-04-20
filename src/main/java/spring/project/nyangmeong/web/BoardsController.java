package spring.project.nyangmeong.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import spring.project.nyangmeong.domain.boards.Boards;
import spring.project.nyangmeong.domain.comment.Comment;
import spring.project.nyangmeong.domain.user.User;
import spring.project.nyangmeong.service.BoardsService;
import spring.project.nyangmeong.web.api.dto.ResponseDto;
import spring.project.nyangmeong.web.api.dto.comment.CommentResponseDto;

@RequiredArgsConstructor
@Controller
public class BoardsController {
    private final BoardsService boardsService;
    private final HttpSession session;

    @GetMapping("/boards/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Boards boardsEntity = boardsService.글상세보기(id);
        User principal = (User) session.getAttribute("principal");

        List<CommentResponseDto> comments = new ArrayList<>();

        for (Comment comment : boardsEntity.getComments()) {
            CommentResponseDto dto = new CommentResponseDto();
            dto.setComment(comment);

            if (principal != null) {
                if (principal.getId() == comment.getId()) {
                    dto.setAuth(true); // or false
                } else {
                    dto.setAuth(false); // or false
                }
            } else {
                dto.setAuth(false); // or false
            }

            comments.add(dto);
        }

        model.addAttribute("comments", comments);
        model.addAttribute("boardsId", id);
        return "pages/post/jarangDetail";
    }

    // UPDATE 글수정 /post/{id} - 글상세보기 페이지가기 - 인증 O
    @PutMapping("/s/api/boards/{id}/update")
    public @ResponseBody ResponseDto<String> update(@PathVariable Integer id, @RequestBody Boards boards) {

        // 인증
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return new ResponseDto<String>(-1, "로그인 되지 않았습니다.", null);
        }

        // 권한
        Boards boardsEntity = boardsService.글상세보기(id);

        if (boardsEntity.getUser().getId() != principal.getId()) {
            return new ResponseDto<String>(-1, "해당 게시글을 수정할 권한이 없습니다.", null);
        }

        boardsService.글수정하기(boards, id);

        return new ResponseDto<String>(1, "수정 성공", null);
    }

    // 페이지 주기
    // /s 붙었으니까 자동으로 인터셉터가 인증 체크함. (완료)
    @GetMapping("/s/boards/write")
    public String writeForm() {
        return "pages/post/jarangWriteForm";
    }

    @GetMapping({ "/", "/boards" })
    public String home() {
        return "pages/post/jarangList";
    }
}