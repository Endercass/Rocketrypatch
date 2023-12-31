package me.endercass.midpack.rocketrypatch.mixins;


import org.spongepowered.asm.mixin.Mixin;
import zmaster587.advancedRocketry.tile.satellite.TileSatelliteBuilder;

@Mixin(TileSatelliteBuilder.class)
public class TileSatelliteBuilderMixin {
//    @Redirect(method = "assembleRocket", remap = false, at = @At(value = "INVOKE", target = "Lzmaster587/advancedRocketry/item/ItemStationChip;setUUID(Lnet/minecraft/item/ItemStack;I)V"))
//    private void setPlayerStationData(ItemStack param1, int param2) {
//        System.out.println("onAssemble inject");
//        System.out.println( param1 );
//        System.out.println( param2 );
//
//
//    }
}
