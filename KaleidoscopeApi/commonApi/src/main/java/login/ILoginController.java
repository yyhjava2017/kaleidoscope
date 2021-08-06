package login;

import com.base.entity.Result;
import login.entity.LoginBO;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface ILoginController {
     Result login(HttpServletResponse response, @RequestBody LoginBO bo) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException ;
}
