package xicraft.xicraft.CustomItems;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

public class CustomObjects {
    public static ItemStack getCristal(int n){
        ItemStack item = new ItemStack(Material.END_CRYSTAL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("100$");
        meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> lore = new ArrayList<>();
        lore.add("Vaut 100$, à garder précieusement");
        meta.setLore(lore);
        item.setItemMeta(meta);
        item.setAmount(n);
        return item;
    }
    public static ItemStack getPearl(int n){
        ItemStack item = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta meta = item.getItemMeta();
        Objects.requireNonNull(meta).setDisplayName("1$");
        item.setItemMeta(meta);
        item.setAmount(n);
        return item;
    }
    public static ItemStack getBlock(int n){
        ItemStack item_block = new ItemStack(Material.TUBE_CORAL_BLOCK);
        ItemMeta meta_block = item_block.getItemMeta();
        Objects.requireNonNull(meta_block).setDisplayName("10$");
        item_block.setItemMeta(meta_block);
        item_block.setAmount(n);
        return item_block;
    }
    public static ItemStack getKnackie(int n){
        ItemStack epee = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = epee.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("Knackie Légendaire");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.KNOCKBACK, 100, true);
        meta.setDisplayName("Knackie");
        epee.setItemMeta(meta);
        epee.setAmount(n);
        return epee;
    }
    public static ItemStack getFWStick(int n, String[] args){
        ItemStack epee = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = epee.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        String effect = args[0];
        effect = effect.substring(0, 1).toUpperCase() + effect.substring(1).toLowerCase();
        lore.add(String.format("Feu d'artifice %s", effect));
        meta.setLore(lore);
        meta.setDisplayName("Firework Stick");
        meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        epee.setItemMeta(meta);
        epee.setAmount(n);
        return epee;
    }
    public static ItemStack getFBStick(int n){
        ItemStack epee = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = epee.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("BOULE DE FEUU");
        meta.setLore(lore);
        meta.setDisplayName("Fireball Stick");
        meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        epee.setItemMeta(meta);
        epee.setAmount(n);
        return epee;
    }
    public static ItemStack getBookHouse(int n, String[] args){
        ItemStack book = new ItemStack(Material.PAPER);
        ItemMeta meta = book.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(String.format("Permet l'achat de terrain %sx%s", args[0], args[0]));
        Objects.requireNonNull(meta).setLore(lore);
        meta.addEnchant(Enchantment.LOYALTY, Integer.parseInt(args[0]), true);
        meta.setDisplayName(String.format("Propriété %sx%s", args[0], args[0]));
        book.setItemMeta(meta);
        return book;
    }
}
