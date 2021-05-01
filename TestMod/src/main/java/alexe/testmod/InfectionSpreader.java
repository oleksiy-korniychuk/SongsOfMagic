package alexe.testmod;

import alexe.testmod.lists.BlockList;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
//import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.lang.Math;

public class InfectionSpreader {
	public static void SpreadInfection(World worldIn, BlockPos pos) {
		System.out.printf("SpreadInfection\n");
		//Increases taint spread by one block for every 10 levels, might need to be upped to a higher threshold, gets laggy fast
        int int1 = -1;
        int int2 = 1;
        //Block myBlock = worldIn.getBlockState(pos).getBlock();
        boolean spread = false;
        for (int x = int1; x <= int2; x++) {
            for (int y = int1; y <= int2; y++) {
                for (int z = int1; z <= int2; z++) {
                    BlockPos nPos = pos.add(x, y, z);
                    Block b = worldIn.getBlockState(nPos).getBlock();
                    if(b instanceof AirBlock) {
                    	
                    	boolean valid = false;
                    	for (int x_1 = -1; x_1 <= 1; x_1++) {
                    		for (int y_1 = -1; y_1 <= 1; y_1++) {
                    			for (int z_1 = -1; z_1 <= 1; z_1++) {
                    				if((Math.abs(x_1) + Math.abs(y_1) + Math.abs(z_1)) == 1) {
	                            		BlockPos nPos_1 = nPos.add(x_1, y_1, z_1);
	                            		Block next = worldIn.getBlockState(nPos_1).getBlock();
	                            		if(!(next instanceof AirBlock) && !next.equals(BlockList.blighted_vines)) {
	                            			System.out.printf("Pos_1 : %d, %d, %d\n", x_1, y_1, z_1);
	                            			valid = true;
	                            			break;
	                            		}
                    				}
                            	}
                    			if(valid) {break;}
                        	}
                    		if(valid) {break;}
                    	}
                    	
                    	if(valid) {
                    		System.out.printf("Pos : %d, %d, %d\n", x, y, z);
                    		worldIn.setBlockState(nPos, BlockList.blighted_vines.getDefaultState());
                    		spread = true;
                    		break;
                    	}
                    }
                }
                if(spread) {break;}
            }
            if(spread) {break;}
        }
        
//        for (int x = int1; x < int2; x++) {
//            for (int y = int1; y < int2; y++) {
//                for (int z = int1; z < int2; z++) {
//                    BlockPos nPos = pos.add(x, y, z);
//                    Block b = worldIn.getBlockState(nPos).getBlock();
//                    if(b instanceof AirBlock || b instanceof InfectedBlock) {
//                    	continue;
//                    }
//                    else {
//                    	worldIn.setBlockState(nPos, BlockList.blighted_vines.getDefaultState());
//                    }
//                }
//            }
//        }
	}
}
