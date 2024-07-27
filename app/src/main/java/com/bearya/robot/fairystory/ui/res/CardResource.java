package com.bearya.robot.fairystory.ui.res;

import androidx.annotation.DrawableRes;

import com.bearya.robot.R;
import com.bearya.robot.base.card.BoatPropCard;
import com.bearya.robot.base.card.BulletPropCard;
import com.bearya.robot.base.card.FlutePropCard;
import com.bearya.robot.base.card.MagicWandPropCard;
import com.bearya.robot.base.card.NeedlesPropCard;
import com.bearya.robot.base.card.PropCard;
import com.bearya.robot.base.card.SoldierPropCard;
import com.bearya.robot.base.card.StickPropCard;
import com.bearya.robot.base.card.WaterPropCard;

/**
 * 卡片的数据资源
 */
public class CardResource {

    /**
     * 道具卡片
     */
    @DrawableRes
    public static int childImage(int cardType) {

        switch (cardType) {
            case CardType.ACTION_BOAT: return R.drawable.ic_boat;
            case CardType.ACTION_MAGIC: return R.drawable.ic_magic;
            case CardType.ACTION_SOLDIER: return R.drawable.ic_soldie;
            case CardType.ACTION_NEEDLES: return R.drawable.ic_needles;
            case CardType.ACTION_WATER: return R.drawable.ic_water;
            case CardType.ACTION_FLUTE: return R.drawable.ic_flute;
            case CardType.ACTION_BULLET: return R.drawable.ic_bullet;
            case CardType.ACTION_STICK: return R.drawable.ic_stick;
            default: return R.mipmap.ic_add_no_focus_2;
        }
    }

    /**
     * 指令卡片的配音文件
     */
    public static String cardVoice(int cardType) {
        switch (cardType) {
            case CardType.ACTION_FORWARD: return "card/p_forward.mp3";
            case CardType.ACTION_BACKWARD: return "card/p_turn_back.mp3";
            case CardType.ACTION_LEFT: return "card/p_turn_left.mp3";
            case CardType.ACTION_RIGHT: return "card/p_turn_right.mp3";
            case CardType.ACTION_PARALLEL: return "card/p_Juxtaposition.mp3";
            case CardType.ACTION_BOAT: return "card/p_boat.mp3";
            case CardType.ACTION_MAGIC: return "card/p_wand.mp3";
            case CardType.ACTION_SOLDIER: return "card/p_sunflower.mp3";
            case CardType.ACTION_NEEDLES: return "card/p_needles.mp3";
            case CardType.ACTION_WATER: return "card/p_water.mp3";
            case CardType.ACTION_FLUTE: return "card/p_flute.mp3";
            case CardType.ACTION_BULLET: return "card/p_bomb.mp3";
            case CardType.ACTION_STICK: return "card/p_sticks.mp3";
            case CardType.ACTION_LOOP: return "card/p_loop.mp3";
            case CardType.ACTION_CLOSURE: return "card/p_closure.mp3";
            case CardType.ACTION_INSERT_LEFT:
            case CardType.ACTION_INSERT_RIGHT: return "card/p_insert.mp3";
            default: return "";
        }
    }


    /**
     * 主指令卡片图片
     */
    @DrawableRes
    public static int parentImage(int cardType) {
        switch (cardType) {
            case CardType.ACTION_FORWARD: return R.drawable.ic_forward;
            case CardType.ACTION_BACKWARD: return R.drawable.ic_backward;
            case CardType.ACTION_LEFT: return R.drawable.ic_left;
            case CardType.ACTION_RIGHT: return R.drawable.ic_right;
            case CardType.ACTION_LOOP: return R.drawable.ic_loop;
            case CardType.ACTION_CLOSURE: return R.drawable.ic_closure;
            default: return R.mipmap.ic_add_no_focus_2;
        }
    }

    /**
     * 创建前进方向的并行道具卡
     */
    public static PropCard createChildAction(CardChildAction cardChildAction) {
        if (cardChildAction != null) {
            switch (cardChildAction.childActionId) {
                case CardType.ACTION_MAGIC: return new MagicWandPropCard(); // 魔法棒
                case CardType.ACTION_BOAT: return new BoatPropCard(); // 小船
                case CardType.ACTION_FLUTE: return new FlutePropCard(); // 跳舞笛
                case CardType.ACTION_BULLET: return new BulletPropCard(); // 粘粘弹
                case CardType.ACTION_WATER: return new WaterPropCard(); // 变身水
                case CardType.ACTION_NEEDLES: return new NeedlesPropCard(); // 毛衣针
                case CardType.ACTION_SOLDIER: return new SoldierPropCard(); // 战士
                case CardType.ACTION_STICK: return new StickPropCard(); // 逗猫棒
                default: return null;
            }
        }
        return null;
    }
}
