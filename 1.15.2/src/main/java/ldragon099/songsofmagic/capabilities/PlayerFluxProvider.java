package ldragon099.songsofmagic.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerFluxProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT>{

	@CapabilityInject(IFluxCapability.class)
	public static Capability<IFluxCapability> CAPABILITY_FLUX = null;
	
	protected IFluxCapability player_Flux = null;
	
	public static void register() {
		CapabilityManager.INSTANCE.register(IFluxCapability.class, new PlayerFluxCapabilityStorage(), new PlayerFluxFactory());
	}
	
	public PlayerFluxProvider(int max_Flux) {
		player_Flux = new PlayerFluxCapability(max_Flux);
	}
	
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if (CAPABILITY_FLUX != null && cap == CAPABILITY_FLUX) {
			return (LazyOptional<T>)player_Flux;
		}
		return LazyOptional.empty();
	}

	@Override
	public CompoundNBT serializeNBT() {
		return player_Flux.saveNBTData();
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		player_Flux.loadNBTData((CompoundNBT) nbt);
	}

}
