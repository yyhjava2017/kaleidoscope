package role;

import com.base.entity.Result;
import role.entity.RoleEntity;
import user.entity.UserEntity;

public interface IRoleController {
    Result add(RoleEntity roleEntity);
    Result query(RoleEntity roleEntity);
    Result delete(String id);
    Result update(RoleEntity roleEntity);
}
