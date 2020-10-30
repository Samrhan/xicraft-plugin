package xicraft.xicraft.Event.Mobs;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class wither_donjon_1 {
    public wither_donjon_1(Entity boss) {
        LivingEntity entity = (LivingEntity) boss;
        AttributeInstance attribute = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        assert attribute != null;
        attribute.addModifier(new AttributeModifier("",5,AttributeModifier.Operation.MULTIPLY_SCALAR_1));
        entity.setHealth(attribute.getValue());
    }
}
