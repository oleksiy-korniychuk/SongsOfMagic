package alexe.testmod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;

public class WandItem  extends Item{

	protected final float mana;
	
	public WandItem(Properties properties, float manaIn) {
		super(properties);
		this.mana = manaIn;
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		
		return ActionResultType.SUCCESS;
	}

}
