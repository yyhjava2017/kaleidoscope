package role.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = com.base.constant.TableName.YINY_ROLE)
@Data
public class RoleEntity {
    private String id;
    private String rolename;
    private String roleno;
    private String mark;
}
