package alexe.testmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import alexe.testmod.lists.BlockList;
import alexe.testmod.lists.itemList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("testmod")
public class TestMod 
{
	public static TestMod instance;
	public static final String modid = "testmod";
	private static final Logger logger =LogManager.getLogger(modid);
	
	public TestMod() 
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		logger.info("Setup method registered");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("Client method registered");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll(
					itemList.test_item = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("test_item")),
					itemList.iron_cap = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("iron_cap")),
					itemList.iron_cap_wand = new WandItem(new Item.Properties().group(ItemGroup.MISC), 0.0F).setRegistryName(location("iron_cap_wand")),
					
					//block items
					itemList.blighted_vines = new BlockItem(BlockList.blighted_vines, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.blighted_vines.getRegistryName())
			);
			
			
			logger.info("Items registered");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll(
					BlockList.blighted_vines = new InfectedBlock(Block.Properties.create(Material.PLANTS).lightValue(3).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName(location("blighted_vines"))
			);
			
			
			logger.info("Blocks registered");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}


























