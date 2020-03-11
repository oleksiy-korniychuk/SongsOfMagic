package ldragon099.songsofmagic;

import org.apache.logging.log4j.LogManager; //Imported Libraries
import org.apache.logging.log4j.Logger;

import ldragon099.songsofmagic.capabilities.PlayerFluxProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("songsofmagic")
public class SongsOfMagic {
	
	public static SongsOfMagic instance;
	//Use this variable so that refactoring is easier later on
	public static final String modid = "songsofmagic";
	private static final Logger Logger = LogManager.getLogger(modid);
	
	public SongsOfMagic() {
		instance = this;
		//Tell Forge/Minecraft to listen for our functions to register stuff
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	//Server stuff that needs to be rendered for everyone
	private void setup(final FMLCommonSetupEvent event) {
		PlayerFluxProvider.register();
		
		Logger.info("Setup method registered.");
	}
	
	//Client stuff that needs to be rendered for each person individually
	private void clientRegistries(final FMLClientSetupEvent event) {
		Logger.info("Client method registered.");
	}
	
	
}
