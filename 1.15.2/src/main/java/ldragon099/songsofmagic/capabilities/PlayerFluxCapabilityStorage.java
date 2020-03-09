package ldragon099.songsofmagic.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayerFluxCapabilityStorage implements IStorage<IFluxCapability> {

	@Override
	public INBT writeNBT(Capability<IFluxCapability> capability, IFluxCapability instance, Direction side) {
		return instance.saveNBTData();
	}

	@Override
	public void readNBT(Capability<IFluxCapability> capability, IFluxCapability instance, Direction side,
			INBT nbt) {
		instance.loadNBTData((CompoundNBT) nbt); 		
	}

}
