package quintamc.sessions;

import java.io.Serializable;

public interface SessionSBSLLocal {

	public boolean insertar(Class<? extends Serializable> entidad, Object o);

}
