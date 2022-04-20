package spring.project.nyangmeong.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import spring.project.nyangmeong.domain.user.User;
import spring.project.nyangmeong.domain.user.UserRepository;
import spring.project.nyangmeong.web.api.dto.user.JoinDto;
import spring.project.nyangmeong.web.api.dto.user.LoginDto;
import spring.project.nyangmeong.web.api.dto.user.UserProfileDto;

@RequiredArgsConstructor
@Service // 컴포넌트 스캔시에 IoC 컨테이너에 등록됨 // 트랜잭션 관리하는 오브젝트임. 기능 모임
public class UserService {
    private final UserRepository userRepository;

    /**
     * Spring Security 필수 메소드
     * 
     * param email 입력받은 사용자 이메일 정보
     * return eamil로 찾은 user정보
     * throws UsernameNotFoundException
     */
    // @Override
    // public User loadUserByUsername(String email) throws UsernameNotFoundException
    // {
    // User user = userRepository.findUserByEmail(email);

    // if (user == null)
    // return null;
    // return user;
    // }

    @Transactional
    public void 회원가입(JoinDto joinDto) {
        // save하면 db에 insert하고 insert된 결과를 다시 return 해준다.
        userRepository.save(joinDto.toEntity());
    }

    public User 로그인(LoginDto loginDto) {
        // 로그인 처리 쿼리를 JPA에서 제공해주지 않는다.
        // SELECT * FROM user WHERE username=:username AND password = :password
        User userEntity = userRepository.mLogin(loginDto.getUsername(), loginDto.getPassword());
        return userEntity;
    }

    public boolean checkusernameDuplicate(String username) {
        return userRepository.existsByusername(username);
    }

    /**
     * UserDto 정보 반환
     * param email 사용자의 email 정보
     * return 로그인한 사용자의 UserDto
     */
    // @Transactional
    // public UserDto getUserDtoByEmail(String email) {
    // User user = userRepository.findUserByEmail(email);

    // return UserDto.builder()
    // .id(user.getId())
    // .email(email)
    // .name(user.getUsername())
    // .build();
    // }

    /**
     * user의 id 정보 반환
     * param email 로그인한 사용자의 email
     * return 로그인한 사용자의 id
     */
    @Transactional
    public long getUserDtoByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return user.getId();
    }

    /**
     * UserProfileDto 정보 반환
     * 
     * param currentId 현재 접속한 profile 페이지의 사용자
     * param loginEmail 로그인한 사용자의 email
     * return currentId에 해당하는 user profile정보 반환
     */
    // @Transactional
    // public UserProfileDto getProfile(long currentId, String loginEmail) {
    // UserProfileDto userProfileDto = new UserProfileDto();

    // User user = userRepository.getById(currentId);
    // userProfileDto.setUser(user);
    // userProfileDto.setBoardsCount(user.getBoardsList().size());

    // // loginEmail 활용하여 currentId가 로그인된 사용자 인지 확인
    // User loginUser = userRepository.findUserByEmail(loginEmail);
    // userProfileDto.setLoginUser(loginUser.getId() == user.getId());
    // userProfileDto.setLoginId(loginUser.getId());
    // userProfileDto.setProfileImgUrl(loginUser.getProfileImgUrl());

    // // currentId를 가진 user가 loginEmail을 가진 user를 구독 했는지 확인
    // userProfileDto.setFollow(followRepository.findFollowByFromUserAndToUser(loginUser,
    // user) != null);

    // // currentId를 가진 user의 팔로워, 팔로잉 수를 확인한다.
    // userProfileDto.setUserFollowerCount(followRepository.findFollowerCountById(currentId));
    // userProfileDto.setUserFollowingCount(followRepository.findFollowingCountById(currentId));

    // user.getPostList().forEach(post -> {
    // post.setLikesCount(post.getLikeList().size());
    // });

    // return userProfileDto;
    // }
}