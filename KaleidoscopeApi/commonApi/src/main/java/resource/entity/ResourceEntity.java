package resource.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(com.base.constant.TableName.YINY_RESOURCE)
public class ResourceEntity {
    private String id;
    private String name;
    private String code;
    private String url;
    private String pid;
    private String roleid;
}
