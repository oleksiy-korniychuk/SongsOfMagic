package ldragon099.songsofmagic.capabilities;

import java.util.concurrent.Callable;

public class PlayerFluxFactory implements Callable<IFluxCapability>{

	@Override
	public IFluxCapability call() throws Exception {
		return new PlayerFluxCapability(100);
	}

}
