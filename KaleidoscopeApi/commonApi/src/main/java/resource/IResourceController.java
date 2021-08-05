package resource;

import com.base.entity.Result;
import resource.entity.ResourceEntity;

public interface IResourceController {
    Result add(ResourceEntity entity);
    Result query(String id);
    Result delete(String id);
    Result update(ResourceEntity entity);
}
