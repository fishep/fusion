# dragoon

```text
基础配置如下：
玩家（Player） 可以是战士（Fighter）、法师（Mage）、龙骑（Dragoon）
怪物（Monster）可以是兽人（Orc）、精灵（Elf）、龙（Dragon），怪物有血量
武器（Weapon） 可以是剑（Sword）、法杖（Staff），武器有攻击力

玩家可以装备一个武器，武器攻击可以是 物理攻击，火，冰 等，武器类型决定伤害类型。
    剑（Sword）   物理攻击
    法杖（Staff） 火，冰

攻击规则如下：
    兽人对物理攻击伤害减半
    精灵对魔法攻击伤害减半
    龙对物理和魔法攻击免疫，除非玩家是龙骑，则伤害加倍

限制条件：
    战士只能装备剑
    法师只能装备法杖
    
    玩家都能装备匕首（dagger）
    //只有战士和法师可以装备匕首（dagger）

“可移动”的行为
    玩家可以Move和Jump
    怪物可以Move和Run
```


