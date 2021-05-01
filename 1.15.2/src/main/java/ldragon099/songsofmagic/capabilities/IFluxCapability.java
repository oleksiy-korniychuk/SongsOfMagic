package ldragon099.songsofmagic.capabilities;

import net.minecraft.nbt.CompoundNBT;

public interface IFluxCapability {
	
	int getFlux();
	
	void setFlux(int flux);
	
	CompoundNBT saveNBTData();
	
	void loadNBTData(CompoundNBT compound);
	
}
