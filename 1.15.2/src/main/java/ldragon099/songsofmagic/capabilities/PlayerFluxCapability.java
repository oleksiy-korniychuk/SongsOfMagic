package ldragon099.songsofmagic.capabilities;

import net.minecraft.nbt.CompoundNBT;

public class PlayerFluxCapability implements IFluxCapability {
	
	//Players current level of endoflux (internal flux)
	protected int cur_Flux;
	//Players max level of endoflux
	protected int max_Flux;
	
	//Constructor
	public PlayerFluxCapability(int maxFlux) {
		this.cur_Flux = 0;
		this.max_Flux = maxFlux;
	}
	
	@Override
	public int getFlux() {
		return this.cur_Flux;
	}

	@Override
	public void setFlux(int flux) {
		//Set players current flux level to the minimum of the max and passed in flux
		//This is so that we never exceed the max flux
		this.cur_Flux = Math.min(flux, this.max_Flux);
	}
	
	//These function use NBT which allows us to save the players flux level and retrieve it
	@Override
	public CompoundNBT saveNBTData() {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("flux", cur_Flux);
		return nbt;
	}

	@Override
	public void loadNBTData(CompoundNBT compound) {
		cur_Flux = compound.getInt("flux");
	}

}
