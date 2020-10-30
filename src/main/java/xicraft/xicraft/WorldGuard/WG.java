package xicraft.xicraft.WorldGuard;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WG {
    public static ProtectedRegion get_rg(Location location){
        com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(location);
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = container.createQuery();
        ApplicableRegionSet set = query.getApplicableRegions(loc);
        int priority = 0;
        ProtectedRegion rg = null;
        for (ProtectedRegion protectedRegion : set) {
            if (protectedRegion.getPriority() >= priority) {
                rg = protectedRegion;
                priority = protectedRegion.getPriority();
            }
        }
        return rg;
    }

    public static boolean hisOwn(Location location, Player player){
        ProtectedRegion rg = get_rg(location);
        LocalPlayer wg_player = WorldGuardPlugin.inst().wrapPlayer(player);
        return !(rg != null && rg.getOwners().size() != 0 && (!rg.getOwners().contains(wg_player) && !rg.getMembers().contains(wg_player)));
    }

}
