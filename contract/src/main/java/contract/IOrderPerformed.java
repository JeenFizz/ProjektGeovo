package contract;

import java.io.IOException;

public interface IOrderPerformed {

	void orderPerform(UserOrder userOrder) throws IOException;

}