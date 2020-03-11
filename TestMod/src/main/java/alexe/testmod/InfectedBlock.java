package alexe.testmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class InfectedBlock extends Block{

	public InfectedBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.getDefaultState().with(ModBlockStates.FULLYINFECTED, false));//.with(ModBlockStates.INFECTEDLEVEL, 0));
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	      builder.add(ModBlockStates.FULLYINFECTED);
	      //builder.add(ModBlockStates.INFECTEDLEVEL);
	}
	
	@Override
	public boolean ticksRandomly(BlockState state) {
		if(state.get(ModBlockStates.FULLYINFECTED) == true) {
			return false;
		}
		
		return true;
	}
	
	public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
		InfectionSpreader.SpreadInfection(worldIn, pos);
		
		boolean surrounded = true;
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                	BlockPos nPos = pos.add(x, y, z);
                    Block b = worldIn.getBlockState(nPos).getBlock();
                    
                    if(!(b instanceof InfectedBlock) && !(b instanceof AirBlock)) {
                    	surrounded = false;
                    }
                }
            }
        }
        
        if(surrounded == true) {
        	worldIn.setBlockState(pos, state.with(ModBlockStates.FULLYINFECTED, true));
        }
        else {
        	worldIn.setBlockState(pos, state.with(ModBlockStates.FULLYINFECTED, false));
        }
	}
	
	@Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity) {
//            LivingEntity entity = (LivingEntity) entityIn;
//
//            entity.addPotionEffect(new EffectInstance( Potion.getPotionById(19), 60, 1, false, true));
        }
    }
	
	@OnlyIn(Dist.CLIENT)
	public BlockRenderLayer getRenderLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
	
}
