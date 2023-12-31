package me.endercass.midpack.rocketrypatch;

import com.mojang.authlib.GameProfile;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public class StationCommand implements ICommand {

    private final List<String> aliases;
    
    public StationCommand() {
        aliases = new ArrayList<>();
        aliases.add("stations");
    }

    @Override
    @Nonnull
    public String getName() {
        return "stations";
    }

    @Override
    @Nonnull
    public String getUsage(ICommandSender sender) {
        return "stations list <Username | UUID> | stations assign <Username | UUID> <Station ID>";
    }

    @Override
    @Nonnull
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        UUID id;

        if (args.length == 2 || args.length == 3) {
            if (args[1].matches("[a-f0-9]{8}-[a-f0-9]{4}-4[0-9]{3}-[89ab][a-f0-9]{3}-[0-9a-f]{12}")) {
                // Argument is uuid
                id = UUID.fromString(args[1]);
            } else {
                // Argument is player name
                PlayerProfileCache cache = server.getPlayerProfileCache();
                GameProfile profile = cache.getGameProfileForUsername(args[1]);
                assert profile != null; // we hope
                id = profile.getId();
            }

            switch (args[0]) {
                case "list":
                    if (PlayerStationData.getModHashMap().containsKey(id)) {
                        Integer[] stations = PlayerStationData.getModHashMap().get(id);
                        sender.sendMessage(new TextComponentString("Stations belonging to player " + id.toString() + ":"));
                        for (Integer stationid : stations) {
                            sender.sendMessage(new TextComponentString("Station " + stationid));
                        }
                    } else {
                        sender.sendMessage(new TextComponentString("Player " + id.toString() + " does not have any stations."));
                    }
                    break;
                case "assign":
                    int stationid = Integer.parseInt(args[2]);
                    PlayerStationData.addStationForPlayer(id, stationid);
                    break;
                default:
                    sender.sendMessage(new TextComponentString("Usage " + getUsage(sender)));
            }
        } else {
            sender.sendMessage(new TextComponentString("Usage " + getUsage(sender)));
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        // This is a debug command. This should only be used by developers for testing.
        // This may also be used by server operators that need to access stations.
        return sender.canUseCommand(server.getOpPermissionLevel(), getName());
    }

    @Override
    @Nonnull
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return new ArrayList<>();
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return index == 1;
    }

    @Override
    public int compareTo(ICommand cmd) {
        return this.getName().compareTo(cmd.getName());
    }
}
