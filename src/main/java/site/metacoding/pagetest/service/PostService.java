package site.metacoding.pagetest.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.pagetest.domain.post.Post;
import site.metacoding.pagetest.domain.post.PostRepository;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void 글삭제하기(Integer id) {
        postRepository.deleteById(id);
    }

    public Post 글상세보기(Integer id) {
        Optional<Post> postOp = postRepository.findById(id);

        if (postOp.isPresent()) {
            return postOp.get();
        } else {
            throw new RuntimeException("해당 게시글을 찾을 수 없습니다");
        }
    }

    public Page<Post> 게시글목록(Integer page) {
        PageRequest pq = PageRequest.of(page, 3, Sort.by(Direction.DESC, "id"));
        return postRepository.findAll(pq);
    }

    @Transactional
    public void 글쓰기(Post post) {
        postRepository.save(post);
    }
}