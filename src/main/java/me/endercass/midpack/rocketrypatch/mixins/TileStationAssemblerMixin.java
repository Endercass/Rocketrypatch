package me.endercass.midpack.rocketrypatch.mixins;


import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zmaster587.advancedRocketry.tile.TileStationAssembler;

@Mixin(TileStationAssembler.class)
public class TileStationAssemblerMixin {
    @Redirect(method = "assembleRocket", remap = false, at = @At(value = "INVOKE", target = "Lzmaster587/advancedRocketry/item/ItemStationChip;setUUID(Lnet/minecraft/item/ItemStack;I)V"))
    private void setPlayerStationData(ItemStack param1, int param2) {
        System.out.println("onAssemble inject");
        System.out.println( param1 );
        System.out.println( param2 );

    }

}
