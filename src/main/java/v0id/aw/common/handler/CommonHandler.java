package v0id.aw.common.handler;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.commons.lang3.tuple.Pair;
import teamroots.embers.register.BlockRegister;
import teamroots.embers.register.ItemRegister;
import v0id.aw.common.block.AWBlocks;
import v0id.aw.common.config.ConfigWorld;
import v0id.aw.common.world.gen.AWGenerator;
import v0id.aw.lib.AWConsts;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Stack;

/**
 * Created by V0idWa1k3r on 02-Jun-17.
 */
public class CommonHandler
{
    public static final int[][] KERNEL = {
            {-1, -1},
            {-1,  1},
            {1,  -1},
            {1,   1},
            {1,   0},
            {-1,  0},
            {0,  -1},
            {0,   1},
            {0,   0}
    };

    private static List<Pair<Integer, ChunkPos>> retrogenList = Lists.newArrayList();

    public static List<Pair<Integer, ChunkPos>> getRetrogenList()
    {
        return retrogenList;
    }

    @SubscribeEvent
    public void onChunkLoad(ChunkDataEvent.Load event)
    {
        if (ConfigWorld.ORE.enableRetrogen)
        {
            NBTTagCompound tag = event.getData();
            if (!tag.hasKey(AWConsts.MODID, Constants.NBT.TAG_COMPOUND) || !tag.getCompoundTag(AWConsts.MODID).hasKey("retrogenKey") || !tag.getCompoundTag(AWConsts.MODID).getString("retrogenKey").equalsIgnoreCase(ConfigWorld.ORE.retrogenKey))
            {
                retrogenList.add(Pair.of(event.getWorld().provider.getDimension(), event.getChunk().getPos()));
            }
        }
    }

    @SubscribeEvent
    public void onChunkUnload(ChunkDataEvent.Unload event)
    {
        Optional<Pair<Integer, ChunkPos>> pos = retrogenList.stream().filter(p -> p.getLeft() == event.getWorld().provider.getDimension() && p.getRight().equals(event.getChunk().getPos())).findFirst();
        pos.ifPresent(p -> retrogenList.remove(p));
    }

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event)
    {
        if (ConfigWorld.ORE.enableRetrogen && event.phase == TickEvent.Phase.START && event.side == Side.SERVER)
        {
            Stack<Pair<Integer, ChunkPos>> toRemove = new Stack<>();
            for (Pair<Integer, ChunkPos> data : retrogenList)
            {
                if (data.getLeft() == event.world.provider.getDimension())
                {
                    Chunk chunk = event.world.getChunkProvider().getLoadedChunk(data.getRight().x, data.getRight().z);
                    if (chunk != null)
                    {
                        toRemove.push(data);
                        long worldSeed = event.world.getSeed();
                        Random random = new Random(worldSeed);
                        random.setSeed(event.world.getSeed());
                        long k = random.nextLong() / 2L * 2L + 1L;
                        long l = random.nextLong() / 2L * 2L + 1L;
                        random.setSeed((long)data.getRight().x * k + (long)data.getRight().z * l ^ event.world.getSeed());
                        IChunkProvider provider = event.world.getChunkProvider();
                        if (provider instanceof ChunkProviderServer)
                        {
                            IChunkGenerator generator = ((ChunkProviderServer) provider).chunkGenerator;
                            AWGenerator.INSTANCE.generate(random, data.getRight().x, data.getRight().z, event.world, generator, provider);
                        }
                    }
                }
            }

            while (!toRemove.empty())
            {
                retrogenList.remove(toRemove.pop());
            }
        }
    }

    @SubscribeEvent
    public void onChunkSave(ChunkDataEvent.Save event)
    {
        if (ConfigWorld.ORE.enableRetrogen)
        {
            NBTTagCompound tag = event.getData();
            if (!tag.hasKey(AWConsts.MODID, Constants.NBT.TAG_COMPOUND))
            {
                tag.setTag(AWConsts.MODID, new NBTTagCompound());
            }

            tag.getCompoundTag(AWConsts.MODID).setString("retrogenKey", ConfigWorld.ORE.retrogenKey);
        }
    }

    @SubscribeEvent
    public void onPlayerClickedBlock(PlayerInteractEvent.RightClickBlock event)
    {
        if (event.getEntityPlayer() != null)
        {
            ItemStack stack = event.getItemStack();
            if (ItemRegister.TINKER_HAMMER.equals(stack.getItem()))
            {
                World w = event.getWorld();
                BlockPos pos = event.getPos();
                Block dawnstoneBlkRef = BlockRegister.BLOCK_DAWNSTONE;
                for (int[] ints : KERNEL)
                {
                    BlockPos offset = pos.add(ints[0], 0, ints[1]);
                    if (w.getBlockState(offset).getBlock() != dawnstoneBlkRef)
                    {
                        return;
                    }
                }

                for (int[] ints : KERNEL)
                {
                    BlockPos offset = pos.add(ints[0], 0, ints[1]);
                    w.setBlockState(offset, AWBlocks.FORGE_STRUCTURE.getDefaultState(), 0b10);
                    w.playSound(event.getEntityPlayer(), pos, SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 0.1F, 0.1F);
                    event.getEntityPlayer().swingArm(event.getHand());
                    stack.damageItem(1, event.getEntityPlayer());
                    event.setCanceled(true);
                }
            }
        }
    }
}
