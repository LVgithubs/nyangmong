package spring.project.nyangmeong.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.project.nyangmeong.domain.user.User;
import spring.project.nyangmeong.domain.user.UserRepository;
import spring.project.nyangmeong.placelikes.PlaceLikesRepository;

@RequiredArgsConstructor
@Service
public class PlaceLikesService {

    private final PlaceLikesRepository placelikesRepository;
    private final UserRepository userRepository;

    @Transactional
    public void placelikes(long boardsId, String loginEmail) {
        User user = userRepository.findUserByEmail(loginEmail);
        placelikesRepository.placelikes(boardsId, user.getId());
    }

    @Transactional
    public void unplacelikes(long boardsId, String loginEmail) {
        User user = userRepository.findUserByEmail(loginEmail);
        placelikesRepository.unplacelikes(boardsId, user.getId());
    }
}