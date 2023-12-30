package me.endercass.midpack.rocketrypatch;

import com.google.common.collect.ImmutableList;
import jdk.nashorn.internal.ir.annotations.Immutable;
import net.minecraftforge.common.ForgeVersion;
import zone.rong.mixinbooter.ILateMixinLoader;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@IFMLLoadingPlugin.Name("Rocketrypatch")
@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
public class MixinLateLoader implements ILateMixinLoader, IFMLLoadingPlugin {
    public List<String> getMixinConfigs() {
        return ImmutableList.of("rocketrypatch.mixins.json");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
