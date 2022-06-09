package anft.demo.api;

import anft.demo.DataVo.UserInfoVo;
import anft.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user")
public class UserController {

    private final UserService userService;

    // 유저 전체 목록 조회
    public List<UserInfoVo> userList() {
        return userService.findAll();
    }

    // 유저 id로 조회
    public UserInfoVo findByUserId(String userId) {

        return userService.findByUserId(userId);
    }

    // 새로운 유저 정보 DB에 저장
    @Transactional
    public void addUser(String userId, String nickname) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMMdd");
        String registerDate = today.format(dateTimeFormatter);

        userService.addUser(userId, nickname, registerDate);
    }
}
