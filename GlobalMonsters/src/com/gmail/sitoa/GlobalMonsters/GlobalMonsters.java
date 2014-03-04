package com.gmail.sitoa.GlobalMonsters;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class GlobalMonsters extends JavaPlugin implements Listener{
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);
		this.saveDefaultConfig();
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("gm")){
			Player p = getServer().getPlayer(args[1]);
			String item ="";
			if(args[0].equalsIgnoreCase("クリーパー")){
				item = getConfig().getString("Creeper");
				
			}
			if(args[0].equalsIgnoreCase("エンダー")){

				 item = getConfig().getString("Ender");
			}
			if(args[0].equalsIgnoreCase("スケルトン")){

				item = getConfig().getString("Skeleton");
				
			}
			if(args[0].equalsIgnoreCase("スパイダー")){

				 item = getConfig().getString("Spider");
			}
			if(args[0].equalsIgnoreCase("ゾンビピックマン")){

				 item = getConfig().getString("Zombiepig");
			}
			if(args[0].equalsIgnoreCase("ゾンビ")){

				 item = getConfig().getString("Zombie");
			}
			String[] items = item.split(",");
			for(int i =0;i<items.length;i++){
				String[] iteminfo = items[i].split(":");
				int itemno = Integer.valueOf(iteminfo[0]);
				int itemlong = Integer.valueOf(iteminfo[1]);
				ItemStack additem = new ItemStack(Material.AIR);
				additem.setTypeId(itemno);
				additem.setAmount(itemlong);
				p.getInventory().addItem(additem);
			}
		}
		
		
		return false;
	}
	 @EventHandler
	  public void snowBallHitEvent(ProjectileHitEvent e) {
	    if(e.getEntity().getType() == EntityType.SNOWBALL) {
	      Location l = e.getEntity().getLocation();
	      l.getWorld().createExplosion(l.getX(),l.getY(),l.getZ() ,1.0f, false, false);
		  }
	  }
	
}
