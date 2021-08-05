package role;

import com.base.entity.Result;
import role.entity.RoleEntity;

public interface IRoleController {
    Result add(RoleEntity roleEntity);
    Result query(String id);
    Result delete(String id);
    Result update(RoleEntity roleEntity);
}
