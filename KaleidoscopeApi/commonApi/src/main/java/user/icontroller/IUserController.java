package user.icontroller;


import com.base.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import user.entity.UserEntity;

/**
 * @zz yyh
 * @time 2020-07
 */
@RequestMapping("/user")
public interface IUserController {

    @RequestMapping(value = "/test")
    String test() throws InterruptedException;

    @RequestMapping(value = "/testsleep")
    String testsleep() throws InterruptedException;
}
