package com.jagex.runescape.net;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;

public class IncomingPackets {

    private static final int

            UPDATE_SPECIFIC_WIDGET_ITEMS = 214,
            UPDATE_ALL_WIDGET_ITEMS = 12,
            UPDATE_WIDGET_TEXT = 110,
            SET_WIDGET_PLAYER_HEAD = 210,
            SET_WIDGET_NPC_HEAD = 160,
            PLAY_WIDGET_ANIMATION = 24,
            SET_TAB_WIDGET = 140,

            SHOW_CHATBOX_WIDGET = 208,
            CLOSE_ALL_WIDGETS = 180,

            UPDATE_SKILL = 34,

            SET_MAP_CHUNK = 166,

            UPDATE_PLAYERS = 92,
            UPDATE_NPCS = 128;

    public static boolean parseIncomingPackets(boolean arg0) {
        if(Class40_Sub6.aClass64_2098 == null)
            return false;
        try {
            int i = Class40_Sub6.aClass64_2098.method1014(-122);
            if((i ^ 0xffffffff) == -1)
                return false;
            if(Class57.incomingPacket == -1) {
                Class40_Sub6.aClass64_2098.method1008(0, 1, -127, Cache.outgoingbuffer.buffer);
                Cache.outgoingbuffer.currentPosition = 0;
                i--;
                Class57.incomingPacket = Cache.outgoingbuffer.getPacket((byte) 49);
                Widget.packetsize = Class24.INCOMINGPACKETSIZES[Class57.incomingPacket];
            }
             System.out.println("packet received: " + Class57.incomingPacket);
            if((Widget.packetsize ^ 0xffffffff) == 0) {
                if((i ^ 0xffffffff) < -1) {
                    Class40_Sub6.aClass64_2098.method1008(0, 1, -127, Cache.outgoingbuffer.buffer);
                    Widget.packetsize = (Cache.outgoingbuffer.buffer[0] & 0xff);
                    i--;
                } else
                    return false;
            }
            if(Widget.packetsize == -2) {
                if(i <= 1)
                    return false;
                i -= 2;
                Class40_Sub6.aClass64_2098.method1008(0, 2, -127, Cache.outgoingbuffer.buffer);
                Cache.outgoingbuffer.currentPosition = 0;
                Widget.packetsize = Cache.outgoingbuffer.getUnsignedShortBE();
            }
            if((Widget.packetsize > i))
                return false;
            Cache.outgoingbuffer.currentPosition = 0;
            Class40_Sub6.aClass64_2098.method1008(0, Widget.packetsize, -128, Cache.outgoingbuffer.buffer);
            Class49.anInt1151 = Cache.anInt324;
            Class35.anInt1728 = 0;
            Cache.anInt324 = RSString.anInt1690;
            RSString.anInt1690 = Class57.incomingPacket;
            if(Class57.incomingPacket == 71) {
                long l = Cache.outgoingbuffer.getLongBE();
                RSString class1 = Class54.method956(82, Cache.outgoingbuffer).method53(-16315);
                Class44.method895(70, 6, class1, Class60.method991(-42, l).method85(-4305));
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 156) {
                long l = Cache.outgoingbuffer.getLongBE();
                int i_1_ = Cache.outgoingbuffer.getUnsignedShortBE();
                RSString string = Class60.method991(-64, l).method85(-4305);
                for(int i_2_ = 0; i_2_ < Class40_Sub5_Sub17_Sub3.anInt3060; i_2_++) {
                    if(l == Class59.aLongArray1397[i_2_]) {
                        if(i_1_ != Class40_Sub7.anIntArray2131[i_2_]) {
                            Class40_Sub7.anIntArray2131[i_2_] = i_1_;
                            ISAAC.redrawTabArea = true;
                            if((i_1_ ^ 0xffffffff) < -1)
                                Class44.method895(127, 5, (Class40_Sub5_Sub17_Sub6.method832(124, (new RSString[]{string, (Class42.aClass1_988)}))), Class66.blank_string);
                            if((i_1_ ^ 0xffffffff) == -1)
                                Class44.method895(101, 5, (Class40_Sub5_Sub17_Sub6.method832(85, (new RSString[]{string, Class38_Sub1.aClass1_1905}))), Class66.blank_string);
                        }
                        string = null;
                        break;
                    }
                }
                boolean bool = false;
                if(string != null && (Class40_Sub5_Sub17_Sub3.anInt3060 ^ 0xffffffff) > -201) {
                    Class59.aLongArray1397[(Class40_Sub5_Sub17_Sub3.anInt3060)] = l;
                    Class40_Sub11.aClass1Array2147[(Class40_Sub5_Sub17_Sub3.anInt3060)] = string;
                    Class40_Sub7.anIntArray2131[(Class40_Sub5_Sub17_Sub3.anInt3060)] = i_1_;
                    Class40_Sub5_Sub17_Sub3.anInt3060++;
                    ISAAC.redrawTabArea = true;
                }
                while(!bool) {
                    bool = true;
                    for(int i_3_ = 0; Class40_Sub5_Sub17_Sub3.anInt3060 - 1 > i_3_; i_3_++) {
                        if((((Class40_Sub7.anIntArray2131[i_3_] ^ 0xffffffff) != (Class13.worldid ^ 0xffffffff)) && ((Class13.worldid ^ 0xffffffff) == (Class40_Sub7.anIntArray2131[1 + i_3_] ^ 0xffffffff))) || ((Class40_Sub7.anIntArray2131[i_3_] ^ 0xffffffff) == -1 && (Class40_Sub7.anIntArray2131[i_3_ + 1] ^ 0xffffffff) != -1)) {
                            bool = false;
                            int i_4_ = Class40_Sub7.anIntArray2131[i_3_];
                            Class40_Sub7.anIntArray2131[i_3_] = Class40_Sub7.anIntArray2131[i_3_ + 1];
                            Class40_Sub7.anIntArray2131[1 + i_3_] = i_4_;
                            RSString class1_5_ = Class40_Sub11.aClass1Array2147[i_3_];
                            Class40_Sub11.aClass1Array2147[i_3_] = Class40_Sub11.aClass1Array2147[1 + i_3_];
                            Class40_Sub11.aClass1Array2147[1 + i_3_] = class1_5_;
                            long l_6_ = Class59.aLongArray1397[i_3_];
                            Class59.aLongArray1397[i_3_] = Class59.aLongArray1397[i_3_ + 1];
                            Class59.aLongArray1397[1 + i_3_] = l_6_;
                            ISAAC.redrawTabArea = true;
                        }
                    }
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -234) {
                Class57.incomingPacket = -1;
                Class40_Sub5_Sub4.anInt2366 = 0;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -8) {
                Class39.aBoolean906 = false;
                for(int i_7_ = 0; i_7_ < 5; i_7_++)
                    Class40_Sub5_Sub17_Sub1.aBooleanArray2975[i_7_] = false;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 23) {
                FloorDecoration.method343(true, 5688);
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -223) {
                int i_8_ = Cache.outgoingbuffer.getOffsetInvertedByte();
                int i_9_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                Buffer.anIntArray1984[i_9_] = i_8_;
                if((i_8_ ^ 0xffffffff) != (Class58.varbitmasks[i_9_] ^ 0xffffffff)) {
                    Class58.varbitmasks[i_9_] = i_8_;
                    Class22.method309(-1, i_9_);
                    ISAAC.redrawTabArea = true;
                    if((Class48.anInt1138 ^ 0xffffffff) != 0)
                        Class52.redrawChatbox = true;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -116) { // set widget hidden state
                boolean bool = ((Cache.outgoingbuffer.getUnsignedByte() ^ 0xffffffff) == -2);
                int i_10_ = Cache.outgoingbuffer.getIntME1();
                Widget widget = Widget.forId(i_10_);
                widget.isHidden = bool;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_ALL_WIDGET_ITEMS) {
                ISAAC.redrawTabArea = true;
                int widgetData = Cache.outgoingbuffer.getIntBE();
                Widget widget = Widget.forId(widgetData);
                if(!widget.isIf3) {
                    for(int containerIndex = 0; widget.items.length > containerIndex; containerIndex++) {
                        widget.items[containerIndex] = 0;
                        widget.itemAmounts[containerIndex] = 0;
                    }
                } else {
                    Widget[] widgets = (Widget.interfaces[widgetData >> -1887808688]);
                    for(int childIndex = 0; childIndex < widgets.length; childIndex++) {
                        Widget child = widgets[childIndex];
                        if(((0xffff & child.parentId ^ 0xffffffff) == (0xffff & widget.id ^ 0xffffffff)) && (child.anInt2736 ^ 0xffffffff) < -1) {
                            child.anInt2734 = 0;
                            child.anInt2718 = -1;
                        }
                    }
                }
                int containerSize = Cache.outgoingbuffer.getUnsignedShortBE();
                for(int containerIndex = 0; (containerSize > containerIndex); containerIndex++) {
                    int itemAmount = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                    if((itemAmount ^ 0xffffffff) == -256)
                        itemAmount = Cache.outgoingbuffer.getIntBE();
                    int itemId = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                    if(!widget.isIf3) {
                        if(widget.items.length > containerIndex) {
                            widget.items[containerIndex] = itemId;
                            widget.itemAmounts[containerIndex] = itemAmount;
                        }
                    } else {
                        Widget[] widgets = (Widget.interfaces[widgetData >> -424241648]);
                        for(int childIndex = 0; ((childIndex < widgets.length)); childIndex++) {
                            Widget child = widgets[childIndex];
                            if(((widget.id & 0xffff) == (child.parentId & 0xffff)) && ((child.anInt2736 ^ 0xffffffff) == (1 + containerIndex ^ 0xffffffff))) {
                                child.anInt2734 = itemAmount;
                                child.anInt2718 = -1 + itemId;
                            }
                        }
                    }
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -251) { // widget model type 1
                int modelId = Cache.outgoingbuffer.getUnsignedShortLE();
                int widgetData = Cache.outgoingbuffer.getIntME1();
                Widget widget = Widget.forId(widgetData);
                widget.modelId = modelId;
                widget.modelType = 1;
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -256) {
                int i_23_ = Cache.outgoingbuffer.getUnsignedByte();
                int i_24_ = Cache.outgoingbuffer.getUnsignedByte();
                int i_25_ = Cache.outgoingbuffer.getUnsignedByte();
                int i_26_ = Cache.outgoingbuffer.getUnsignedByte();
                Class40_Sub5_Sub17_Sub1.aBooleanArray2975[i_23_] = true;
                Class8.anIntArray297[i_23_] = i_24_;
                RSApplet.anIntArray2[i_23_] = i_25_;
                Class58.anIntArray1358[i_23_] = i_26_;
                Class22_Sub1.anIntArray1846[i_23_] = 0;
                Class57.incomingPacket = -1;
                return true;
            }
            if(arg0 != false)
                CollisionMap.anInt172 = -96;
            if(Class57.incomingPacket == 235) {
                Class27.anInt658 = Cache.outgoingbuffer.getUnsignedByte();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 48) {
                Class40_Sub6.anInt2118 = Cache.outgoingbuffer.getUnsignedByte();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 82) {
                RSString class1 = Cache.outgoingbuffer.getRSString();
                if(!class1.method87(103, AnimationSequence.aClass1_2472)) {
                    if(!class1.method87(104, Class40_Sub5_Sub6.aClass1_2434)) {
                        if(!class1.method87(81, Node.aClass1_948))
                            Class44.method895(72, 0, class1, Class66.blank_string);
                        else {
                            RSString class1_27_ = (class1.substring(0, class1.contains(Class43.aClass1_1027)));
                            long l = class1_27_.method58((byte) 121);
                            boolean bool = false;
                            for(int i_28_ = 0; i_28_ < Class42.anInt1008; i_28_++) {
                                if(l == Class53.aLongArray1267[i_28_]) {
                                    bool = true;
                                    break;
                                }
                            }
                            if(!bool && (Class4.anInt182 ^ 0xffffffff) == -1) {
                                RSString class1_29_ = (class1.substring((1 + class1.contains((Class43.aClass1_1027))), -9 + class1.length()));
                                Class44.method895(122, 8, class1_29_, class1_27_);
                            }
                        }
                    } else {
                        RSString class1_30_ = (class1.substring(0, class1.contains(Class43.aClass1_1027)));
                        long l = class1_30_.method58((byte) 120);
                        boolean bool = false;
                        for(int i_31_ = 0; ((Class42.anInt1008 > i_31_)); i_31_++) {
                            if((Class53.aLongArray1267[i_31_] ^ 0xffffffffffffffffL) == (l ^ 0xffffffffffffffffL)) {
                                bool = true;
                                break;
                            }
                        }
                        if(!bool && (Class4.anInt182 ^ 0xffffffff) == -1)
                            Class44.method895(120, 8, Class61.aClass1_1428, class1_30_);
                    }
                } else {
                    RSString class1_32_ = class1.substring(0, class1.contains((Class43.aClass1_1027)));
                    long l = class1_32_.method58((byte) 98);
                    boolean bool = false;
                    for(int i_33_ = 0; i_33_ < Class42.anInt1008; i_33_++) {
                        if((Class53.aLongArray1267[i_33_] ^ 0xffffffffffffffffL) == (l ^ 0xffffffffffffffffL)) {
                            bool = true;
                            break;
                        }
                    }
                    if(!bool && (Class4.anInt182 ^ 0xffffffff) == -1)
                        Class44.method895(94, 4, Class4.aClass1_180, class1_32_);
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 182) { // set widget scroll position
                int i_34_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_35_ = Cache.outgoingbuffer.getIntLE();
                Widget widget = Widget.forId(i_35_);
                Class57.incomingPacket = -1;
                if(widget != null && (widget.type ^ 0xffffffff) == -1) {
                    if((i_34_ ^ 0xffffffff) > -1)
                        i_34_ = 0;
                    if((-widget.originalHeight + widget.scrollHeight) < i_34_)
                        i_34_ = (-widget.originalHeight + widget.scrollHeight);
                    widget.scrollPosition = i_34_;
                }
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -175) { // clear widget item container?
                int i_36_ = Cache.outgoingbuffer.getIntME1();
                Widget widget = Widget.forId(i_36_);
                if(widget.isIf3) {
                    Widget[] widgets = (Widget.interfaces[i_36_ >> -1339248816]);
                    for(int i_37_ = 0; i_37_ < widgets.length; i_37_++) {
                        Widget widget_38_ = widgets[i_37_];
                        if(((widget_38_.parentId & 0xffff ^ 0xffffffff) == (0xffff & widget.id ^ 0xffffffff)) && widget_38_.anInt2736 > 0) {
                            widget_38_.anInt2718 = -1;
                            widget_38_.anInt2734 = 0;
                        }
                    }
                } else {
                    for(int i_39_ = 0; widget.items.length > i_39_; i_39_++) {
                        widget.items[i_39_] = -1;
                        widget.items[i_39_] = 0;
                    }
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -131) {
                Class34.anInt854 = Cache.outgoingbuffer.getUnsignedShortLE();
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -130) {
                int i_40_ = Cache.outgoingbuffer.getUnsignedInvertedByte();
                int i_41_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                int i_42_ = Cache.outgoingbuffer.getUnsignedInvertedByte();
                Player.anInt3267 = i_40_ >> 2097688801;
                Player.localPlayer.method787(i_42_, -7717, (i_40_ & 0x1) == 1, i_41_);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 181) {
                Class48.method928(-7225);
                Class57.incomingPacket = -1;
                return false;
            }
            if(Class57.incomingPacket == PLAY_WIDGET_ANIMATION) {
                int animationId = Cache.outgoingbuffer.getShortBE();
                int widgetData = Cache.outgoingbuffer.getIntBE();
                Widget widget = Widget.forId(widgetData);
                if(((widget.animation ^ 0xffffffff) != (animationId ^ 0xffffffff)) || (animationId ^ 0xffffffff) == 0) {
                    widget.anInt2660 = 0;
                    widget.anInt2654 = 0;
                    widget.animation = animationId;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -57) {
                int i_45_ = Cache.outgoingbuffer.getNegativeOffsetShortBE();
                if((i_45_ ^ 0xffffffff) <= -1)
                    Class42.method883((byte) -121, i_45_);
                if((Class58.anInt1376 ^ 0xffffffff) != (i_45_ ^ 0xffffffff)) {
                    Class55.method958(Class58.anInt1376, -14222);
                    Class58.anInt1376 = i_45_;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -118) {
                int i_46_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_47_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortLE();
                int i_48_ = Cache.outgoingbuffer.getIntLE();
                Widget widget = Widget.forId(i_48_);
                Class57.incomingPacket = -1;
                widget.anInt2722 = i_47_ + (i_46_ << -1109526864);
                return true;
            }
            if(Class57.incomingPacket == 84) {
                int i_49_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_50_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortLE();
                if(Class43.openChatboxWidgetId != -1) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class52.redrawChatbox = true;
                    Class43.openChatboxWidgetId = -1;
                }
                if(ActorDefinition.anInt2433 != -1) {
                    Class55.method958(ActorDefinition.anInt2433, -14222);
                    ActorDefinition.anInt2433 = -1;
                    OverlayDefinition.method559(30, 91);
                }
                if(UnderlayDefinition.anInt2562 != -1) {
                    Class55.method958(UnderlayDefinition.anInt2562, -14222);
                    UnderlayDefinition.anInt2562 = -1;
                }
                if(Class66.openScreenWidgetId != i_50_) {
                    Class55.method958(Class66.openScreenWidgetId, -14222);
                    Class66.openScreenWidgetId = i_50_;
                }
                if((i_49_ ^ 0xffffffff) != (Class29.tabAreaOverlayWidgetId ^ 0xffffffff)) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId, -14222);
                    Class29.tabAreaOverlayWidgetId = i_49_;
                }
                CacheIndex_Sub1.anInt1819 = -1;
                if(Class40_Sub5_Sub15.inputType != 0) {
                    Class52.redrawChatbox = true;
                    Class40_Sub5_Sub15.inputType = 0;
                }
                ISAAC.redrawTabArea = true;
                IdentityKit.aBoolean2597 = true;
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -65) {
                OverlayDefinition.anInt2318 = Cache.outgoingbuffer.getUnsignedByte();
                Class40_Sub6.anInt2119 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                for(int i_51_ = Class40_Sub6.anInt2119; ((i_51_ < 8 + Class40_Sub6.anInt2119)); i_51_++) {
                    for(int i_52_ = OverlayDefinition.anInt2318; ((8 + OverlayDefinition.anInt2318 > i_52_)); i_52_++) {
                        if((Class10.aClass45ArrayArrayArray357[Player.anInt3267][i_51_][i_52_]) != null) {
                            Class10.aClass45ArrayArrayArray357[Player.anInt3267][i_51_][i_52_] = null;
                            Class40_Sub13.method880((byte) -80, i_52_, i_51_);
                        }
                    }
                }
                for(Class40_Sub3 class40_sub3 = ((Class40_Sub3) Class45.aClass45_1064.method902((byte) -90)); class40_sub3 != null; class40_sub3 = (Class40_Sub3) Class45.aClass45_1064.method909(-4)) {
                    if(class40_sub3.anInt2039 >= Class40_Sub6.anInt2119 && (Class40_Sub6.anInt2119 + 8 > class40_sub3.anInt2039) && (class40_sub3.anInt2038 >= OverlayDefinition.anInt2318) && (OverlayDefinition.anInt2318 + 8 > class40_sub3.anInt2038) && (Player.anInt3267 == class40_sub3.anInt2018))
                        class40_sub3.anInt2031 = 0;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -224) {
                RSString class1 = Cache.outgoingbuffer.getRSString();
                int i_53_ = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
                int i_54_ = Cache.outgoingbuffer.getUnsignedByte();
                if(i_54_ >= 1 && (i_54_ ^ 0xffffffff) >= -6) {
                    if(class1.equalsIgnoreCase(RSApplet.aClass1_34, !arg0))
                        class1 = null;
                    Main.aClass1Array1778[i_54_ + -1] = class1;
                    Class13.aBooleanArray414[i_54_ + -1] = (i_53_ ^ 0xffffffff) == -1;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 118) {
                int i_55_ = Cache.outgoingbuffer.getUnsignedShortBE();
                Class42.method883((byte) -127, i_55_);
                if(Class29.tabAreaOverlayWidgetId != -1) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId, -14222);
                    IdentityKit.aBoolean2597 = true;
                    Class29.tabAreaOverlayWidgetId = -1;
                    ISAAC.redrawTabArea = true;
                }
                if((Class43.openChatboxWidgetId ^ 0xffffffff) != 0) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class52.redrawChatbox = true;
                    Class43.openChatboxWidgetId = -1;
                }
                if((ActorDefinition.anInt2433 ^ 0xffffffff) != 0) {
                    Class55.method958(ActorDefinition.anInt2433, -14222);
                    ActorDefinition.anInt2433 = -1;
                    OverlayDefinition.method559(30, -117);
                }
                if((UnderlayDefinition.anInt2562 ^ 0xffffffff) != 0) {
                    Class55.method958(UnderlayDefinition.anInt2562, -14222);
                    UnderlayDefinition.anInt2562 = -1;
                }
                if(i_55_ != Class66.openScreenWidgetId) {
                    Class55.method958(Class66.openScreenWidgetId, -14222);
                    Class66.openScreenWidgetId = i_55_;
                }
                CacheIndex_Sub1.anInt1819 = -1;
                if(Class40_Sub5_Sub15.inputType != 0) {
                    Class52.redrawChatbox = true;
                    Class40_Sub5_Sub15.inputType = 0;
                }
                Class64.method1012(Class66.openScreenWidgetId, 2);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 18) {
                if((Class5.currentTabId ^ 0xffffffff) == -13)
                    ISAAC.redrawTabArea = true;
                Class40_Sub11.anInt2158 = Cache.outgoingbuffer.getUnsignedByte();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 253) {
                Class39.aBoolean906 = true;
                Class22.anInt545 = Cache.outgoingbuffer.getUnsignedByte();
                Class32.anInt767 = Cache.outgoingbuffer.getUnsignedByte();
                Class5.anInt194 = Cache.outgoingbuffer.getUnsignedShortBE();
                Class4.anInt188 = Cache.outgoingbuffer.getUnsignedByte();
                Class59.anInt1386 = Cache.outgoingbuffer.getUnsignedByte();
                if((Class59.anInt1386 ^ 0xffffffff) <= -101) {
                    Class40_Sub5_Sub6.cameraY = 64 + Class32.anInt767 * 128;
                    Class12.cameraX = Class22.anInt545 * 128 + 64;
                    Class32.cameraZ = (Class37.method430((byte) -125, (Player.anInt3267), Class12.cameraX, Class40_Sub5_Sub6.cameraY) - Class5.anInt194);
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 185) {
                int i_56_ = Cache.outgoingbuffer.getNegativeOffsetShortBE();
                if(Class48.anInt1138 != i_56_) {
                    Class55.method958(Class48.anInt1138, -14222);
                    Class48.anInt1138 = i_56_;
                }
                Class57.incomingPacket = -1;
                Class52.redrawChatbox = true;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -196) {
                int i_57_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                int i_58_ = Cache.outgoingbuffer.getUnsignedShortBE();
                Class42.method883((byte) -120, i_58_);
                if(i_57_ != -1)
                    Class42.method883((byte) -124, i_57_);
                if(Class66.openScreenWidgetId != -1) {
                    Class55.method958(Class66.openScreenWidgetId, -14222);
                    Class66.openScreenWidgetId = -1;
                }
                if((Class29.tabAreaOverlayWidgetId ^ 0xffffffff) != 0) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId, -14222);
                    Class29.tabAreaOverlayWidgetId = -1;
                }
                if(Class43.openChatboxWidgetId != -1) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class43.openChatboxWidgetId = -1;
                }
                if((ActorDefinition.anInt2433 ^ 0xffffffff) != (i_58_ ^ 0xffffffff)) {
                    Class55.method958(ActorDefinition.anInt2433, -14222);
                    ActorDefinition.anInt2433 = i_58_;
                    OverlayDefinition.method559(35, -57);
                }
                if(i_58_ != UnderlayDefinition.anInt2562) {
                    Class55.method958(UnderlayDefinition.anInt2562, -14222);
                    UnderlayDefinition.anInt2562 = i_57_;
                }
                CacheIndex_Sub1.anInt1819 = -1;
                Class40_Sub5_Sub15.inputType = 0;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == CLOSE_ALL_WIDGETS) {
                if(Class29.tabAreaOverlayWidgetId != -1) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId, -14222);
                    ISAAC.redrawTabArea = true;
                    IdentityKit.aBoolean2597 = true;
                    Class29.tabAreaOverlayWidgetId = -1;
                }
                if((Class43.openChatboxWidgetId ^ 0xffffffff) != 0) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class52.redrawChatbox = true;
                    Class43.openChatboxWidgetId = -1;
                }
                if((ActorDefinition.anInt2433 ^ 0xffffffff) != 0) {
                    Class55.method958(ActorDefinition.anInt2433, -14222);
                    ActorDefinition.anInt2433 = -1;
                    OverlayDefinition.method559(30, -84);
                }
                if(UnderlayDefinition.anInt2562 != -1) {
                    Class55.method958(UnderlayDefinition.anInt2562, -14222);
                    UnderlayDefinition.anInt2562 = -1;
                }
                if(Class66.openScreenWidgetId != -1) {
                    Class55.method958(Class66.openScreenWidgetId, -14222);
                    Class66.openScreenWidgetId = -1;
                }
                Class57.incomingPacket = -1;
                CacheIndex_Sub1.anInt1819 = -1;
                if(Class40_Sub5_Sub15.inputType != 0) {
                    Class52.redrawChatbox = true;
                    Class40_Sub5_Sub15.inputType = 0;
                }
                return true;
            }
            if(Class57.incomingPacket == SHOW_CHATBOX_WIDGET) {
                int widgetId = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                Class42.method883((byte) -119, widgetId);
                if((Class29.tabAreaOverlayWidgetId ^ 0xffffffff) != 0) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId, -14222);
                    IdentityKit.aBoolean2597 = true;
                    Class29.tabAreaOverlayWidgetId = -1;
                    ISAAC.redrawTabArea = true;
                }
                if(ActorDefinition.anInt2433 != -1) {
                    Class55.method958(ActorDefinition.anInt2433, -14222);
                    ActorDefinition.anInt2433 = -1;
                    OverlayDefinition.method559(30, -53);
                }
                if((UnderlayDefinition.anInt2562 ^ 0xffffffff) != 0) {
                    Class55.method958(UnderlayDefinition.anInt2562, -14222);
                    UnderlayDefinition.anInt2562 = -1;
                }
                if(Class66.openScreenWidgetId != -1) {
                    Class55.method958(Class66.openScreenWidgetId, -14222);
                    Class66.openScreenWidgetId = -1;
                }
                if(Class43.openChatboxWidgetId != widgetId) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class43.openChatboxWidgetId = widgetId;
                }
                Class52.redrawChatbox = true;
                Class57.incomingPacket = -1;
                CacheIndex_Sub1.anInt1819 = -1;
                return true;
            }
            if(Class57.incomingPacket == 217) {
                int i_60_ = Cache.outgoingbuffer.getUnsignedShortLE();
                if(i_60_ == 65535)
                    i_60_ = -1;
                Class51.method942(257, i_60_);
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -41) {
                int i_61_ = Cache.outgoingbuffer.getMediumBE();
                int i_62_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                if(i_62_ == 65535)
                    i_62_ = -1;
                Class57.method975(i_61_, (byte) 110, i_62_);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 254) {
                OverlayDefinition.anInt2318 = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
                Class40_Sub6.anInt2119 = Cache.outgoingbuffer.getUnsignedInvertedByte();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 88) {
                Class51.anInt1205 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                if(Class5.currentTabId == Class51.anInt1205) {
                    if(Class51.anInt1205 != 3)
                        Class5.currentTabId = 3;
                    else
                        Class5.currentTabId = 1;
                    ISAAC.redrawTabArea = true;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -64) {
                Class40_Sub6.anInt2119 = Cache.outgoingbuffer.getUnsignedInvertedByte();
                OverlayDefinition.anInt2318 = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
                while(Cache.outgoingbuffer.currentPosition < Widget.packetsize) {
                    Class57.incomingPacket = Cache.outgoingbuffer.getUnsignedByte();
                    Class53.method949((byte) -125);
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -197) {
                Class35.publicChatMode = Cache.outgoingbuffer.getUnsignedByte();
                Class4.anInt185 = Cache.outgoingbuffer.getUnsignedByte();
                ItemDefinition.anInt2797 = Cache.outgoingbuffer.getUnsignedByte();
                Class52.redrawChatbox = true;
                Cache.aBoolean330 = true;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 116) {
                Class40_Sub5_Sub15.anInt2782 = (Cache.outgoingbuffer.getUnsignedShortLE() * 30);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_PLAYERS) {
                parsePlayerUpdatePacket((byte) 57);
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -3) {
                int i_63_ = Cache.outgoingbuffer.getIntME1();
                int i_64_ = Cache.outgoingbuffer.getUnsignedShortBE();
                Buffer.anIntArray1984[i_64_] = i_63_;
                if(i_63_ != Class58.varbitmasks[i_64_]) {
                    Class58.varbitmasks[i_64_] = i_63_;
                    Class22.method309(-1, i_64_);
                    if((Class48.anInt1138 ^ 0xffffffff) != 0)
                        Class52.redrawChatbox = true;
                    ISAAC.redrawTabArea = true;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_NPCS) {
                parseNpcUpdatePacket(89);
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -132) {
                int i_65_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_66_ = Cache.outgoingbuffer.getUnsignedByte();
                int i_67_ = Cache.outgoingbuffer.getUnsignedShortBE();
                Class53.method950(i_65_, (byte) 118, i_66_, i_67_);
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -238) {
                int i_68_ = Cache.outgoingbuffer.getUnsignedShortBE();
                Class42.method883((byte) 107, i_68_);
                if(Class43.openChatboxWidgetId != -1) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class43.openChatboxWidgetId = -1;
                    Class52.redrawChatbox = true;
                }
                if((ActorDefinition.anInt2433 ^ 0xffffffff) != 0) {
                    Class55.method958(ActorDefinition.anInt2433, -14222);
                    ActorDefinition.anInt2433 = -1;
                    OverlayDefinition.method559(30, 81);
                }
                if((UnderlayDefinition.anInt2562 ^ 0xffffffff) != 0) {
                    Class55.method958(UnderlayDefinition.anInt2562, -14222);
                    UnderlayDefinition.anInt2562 = -1;
                }
                if((Class66.openScreenWidgetId ^ 0xffffffff) != 0) {
                    Class55.method958(Class66.openScreenWidgetId, -14222);
                    Class66.openScreenWidgetId = -1;
                }
                if((i_68_ ^ 0xffffffff) != (Class29.tabAreaOverlayWidgetId ^ 0xffffffff)) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId, -14222);
                    Class29.tabAreaOverlayWidgetId = i_68_;
                }
                IdentityKit.aBoolean2597 = true;
                if(Class40_Sub5_Sub15.inputType != 0) {
                    Class52.redrawChatbox = true;
                    Class40_Sub5_Sub15.inputType = 0;
                }
                CacheIndex_Sub1.anInt1819 = -1;
                Class57.incomingPacket = -1;
                ISAAC.redrawTabArea = true;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -235) {
                Class39.aBoolean906 = true;
                HashTable.anInt564 = Cache.outgoingbuffer.getUnsignedByte();
                UnderlayDefinition.anInt2576 = Cache.outgoingbuffer.getUnsignedByte();
                Class38.anInt892 = Cache.outgoingbuffer.getUnsignedShortBE();
                Class60.anInt1413 = Cache.outgoingbuffer.getUnsignedByte();
                Class22_Sub1.anInt1856 = Cache.outgoingbuffer.getUnsignedByte();
                if((Class22_Sub1.anInt1856 ^ 0xffffffff) <= -101) {
                    int i_69_ = 128 * HashTable.anInt564 + 64;
                    int i_70_ = 128 * UnderlayDefinition.anInt2576 + 64;
                    int i_71_ = (Class37.method430((byte) -120, (Player.anInt3267), i_69_, i_70_) - Class38.anInt892);
                    int i_72_ = i_69_ + -Class12.cameraX;
                    int i_73_ = i_70_ + -Class40_Sub5_Sub6.cameraY;
                    int i_74_ = -Class32.cameraZ + i_71_;
                    int i_75_ = (int) Math.sqrt((double) (i_73_ * i_73_ + i_72_ * i_72_));
                    Class26.anInt627 = ((int) (325.949 * Math.atan2((double) i_74_, (double) i_75_)) & 0x7ff);
                    Class68_Sub1.anInt2210 = (int) (Math.atan2((double) i_72_, (double) i_73_) * -325.949) & 0x7ff;
                    if((Class26.anInt627 ^ 0xffffffff) > -129)
                        Class26.anInt627 = 128;
                    if((Class26.anInt627 ^ 0xffffffff) < -384)
                        Class26.anInt627 = 383;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -143) {
                int i_76_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_77_ = Cache.outgoingbuffer.getUnsignedShortLE();
                int i_78_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_79_ = Cache.outgoingbuffer.getIntLE();
                Widget widget = Widget.forId(i_79_);
                Class57.incomingPacket = -1;
                widget.rotationZ = i_76_;
                widget.modelZoom = i_77_;
                widget.rotationX = i_78_;
                return true;
            }
            if(Class57.incomingPacket == 6) {
                Class5.currentTabId = Cache.outgoingbuffer.getUnsignedByte();
                IdentityKit.aBoolean2597 = true;
                ISAAC.redrawTabArea = true;
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -172) {
                if(Class5.currentTabId == 12)
                    ISAAC.redrawTabArea = true;
                Class52.anInt1222 = Cache.outgoingbuffer.getShortBE();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 9 || Class57.incomingPacket == 99 || Class57.incomingPacket == 229 || Class57.incomingPacket == 19 || (Class57.incomingPacket ^ 0xffffffff) == -203 || (Class57.incomingPacket ^ 0xffffffff) == -2 || Class57.incomingPacket == 74 || Class57.incomingPacket == 175 || Class57.incomingPacket == 49 || (Class57.incomingPacket ^ 0xffffffff) == -144 || Class57.incomingPacket == 241) {
                Class53.method949((byte) -112);
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -15) {
                for(int i_80_ = 0; Class59.anInt1383 > i_80_; i_80_++) {
                    Class40_Sub5_Sub11 class40_sub5_sub11 = Npc.method795((byte) -114, i_80_);
                    if(class40_sub5_sub11 != null && class40_sub5_sub11.anInt2633 == 0) {
                        Buffer.anIntArray1984[i_80_] = 0;
                        Class58.varbitmasks[i_80_] = 0;
                    }
                }
                if(Class48.anInt1138 != -1)
                    Class52.redrawChatbox = true;
                ISAAC.redrawTabArea = true;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == SET_WIDGET_NPC_HEAD) {
                int npcId = Cache.outgoingbuffer.getUnsignedShortLE();
                int widgetData = Cache.outgoingbuffer.getIntLE();
                Widget widget = Widget.forId(widgetData);
                widget.modelType = 2;
                Class57.incomingPacket = -1;
                widget.modelId = npcId;
                return true;
            }
            if(Class57.incomingPacket == 132) {
                if((Class43.openChatboxWidgetId ^ 0xffffffff) != 0) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class43.openChatboxWidgetId = -1;
                }
                Class57.incomingPacket = -1;
                Class66.inputInputMessage = Class66.blank_string;
                Class40_Sub5_Sub15.inputType = 1;
                Class52.redrawChatbox = true;
                Class19.aBoolean490 = false;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -187) {
                Player.anInt3288 = Cache.outgoingbuffer.getUnsignedByte();
                if(Player.anInt3288 == 1)
                    Class66.anInt1545 = Cache.outgoingbuffer.getUnsignedShortBE();
                if(((Player.anInt3288 ^ 0xffffffff) <= -3) && (Player.anInt3288 ^ 0xffffffff) >= -7) {
                    if(Player.anInt3288 == 2) {
                        Class35.anInt1730 = 64;
                        Landscape.anInt1170 = 64;
                    }
                    if(Player.anInt3288 == 3) {
                        Class35.anInt1730 = 64;
                        Landscape.anInt1170 = 0;
                    }
                    if((Player.anInt3288 ^ 0xffffffff) == -5) {
                        Class35.anInt1730 = 64;
                        Landscape.anInt1170 = 128;
                    }
                    if(Player.anInt3288 == 5) {
                        Landscape.anInt1170 = 64;
                        Class35.anInt1730 = 0;
                    }
                    if((Player.anInt3288 ^ 0xffffffff) == -7) {
                        Landscape.anInt1170 = 64;
                        Class35.anInt1730 = 128;
                    }
                    Player.anInt3288 = 2;
                    Class68.anInt1637 = Cache.outgoingbuffer.getUnsignedShortBE();
                    Class4.anInt175 = Cache.outgoingbuffer.getUnsignedShortBE();
                    ActorDefinition.anInt2404 = Cache.outgoingbuffer.getUnsignedByte();
                }
                if((Player.anInt3288 ^ 0xffffffff) == -11)
                    Class68.anInt1623 = Cache.outgoingbuffer.getUnsignedShortBE();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == SET_WIDGET_PLAYER_HEAD) {
                int widgetData = Cache.outgoingbuffer.getIntLE();
                Widget widget = Widget.forId(widgetData);
                widget.modelType = 3;
                widget.modelId = Player.localPlayer.aClass30_3282.method374(-20874);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_WIDGET_TEXT) {
                int widgetData = Cache.outgoingbuffer.getIntLE();
                RSString class1 = Cache.outgoingbuffer.getRSString();
                Widget widget = Widget.forId(widgetData);
                widget.text = class1;
                if(Class40_Sub5_Sub11.tabWidgetIds[Class5.currentTabId] == widgetData >> 16)
                    ISAAC.redrawTabArea = true;
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -71) {
                Class12.anInt380 = Cache.outgoingbuffer.getUnsignedByte();
                ISAAC.redrawTabArea = true;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 120) { // item model on interface
                int i_85_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int itemId = Cache.outgoingbuffer.getUnsignedShortLE();
                int i_87_ = Cache.outgoingbuffer.getIntLE();
                if((itemId ^ 0xffffffff) == -65536)
                    itemId = -1;
                Widget widget = Widget.forId(i_87_);
                if(!widget.isIf3) {
                    if(itemId == -1) {
                        Class57.incomingPacket = -1;
                        widget.modelType = 0;
                        return true;
                    }
                    ItemDefinition itemDefinition = ItemDefinition.forId(itemId, 10);
                    widget.rotationX = itemDefinition.xan2d;
                    widget.modelId = itemId;
                    widget.modelType = 4;
                    widget.modelZoom = 100 * itemDefinition.zoom2d / i_85_;
                    widget.rotationZ = itemDefinition.yan2d;
                } else {
                    widget.anInt2734 = 1;
                    widget.anInt2718 = itemId;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 51) {
                long l = Cache.outgoingbuffer.getLongBE();
                long l_88_ = (long) Cache.outgoingbuffer.getUnsignedShortBE();
                long l_89_ = (long) Cache.outgoingbuffer.getMediumBE();
                int i_90_ = Cache.outgoingbuffer.getUnsignedByte();
                boolean bool = false;
                long l_91_ = (l_88_ << 2124835616) + l_89_;
                for(int i_92_ = 0; i_92_ < 100; i_92_++) {
                    if(l_91_ == Class40_Sub5_Sub13.aLongArray2757[i_92_]) {
                        bool = true;
                        break;
                    }
                }
                if(i_90_ <= 1) {
                    for(int i_93_ = 0; ((i_93_ < Class42.anInt1008)); i_93_++) {
                        if(l == Class53.aLongArray1267[i_93_]) {
                            bool = true;
                            break;
                        }
                    }
                }
                if(!bool && (Class4.anInt182 ^ 0xffffffff) == -1) {
                    Class40_Sub5_Sub13.aLongArray2757[(Class40_Sub3.anInt2021)] = l_91_;
                    Class40_Sub3.anInt2021 = (1 + Class40_Sub3.anInt2021) % 100;
                    RSString class1 = Class54.method956(67, Cache.outgoingbuffer).method53(-16315);
                    if((i_90_ ^ 0xffffffff) == -3 || (i_90_ ^ 0xffffffff) == -4)
                        Class44.method895(99, 7, class1, (Class40_Sub5_Sub17_Sub6.method832(88, (new RSString[]{(Widget.goldCrown), Class60.method991(-73, l).method85(-4305)}))));
                    else if(i_90_ == 1)
                        Class44.method895(97, 7, class1, (Class40_Sub5_Sub17_Sub6.method832(126, (new RSString[]{Class51.whiteCrown, Class60.method991(-46, l).method85(-4305)}))));
                    else
                        Class44.method895(72, 3, class1, Class60.method991(-55, l).method85(-4305));
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -28) {
                for(int i_94_ = 0; (i_94_ < (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156).length); i_94_++) {
                    if((Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_94_]) != null)
                        Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_94_].playingAnimation = -1;
                }
                for(int i_95_ = 0; (((CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813).length > i_95_)); i_95_++) {
                    if((CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_95_]) != null)
                        CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_95_].playingAnimation = -1;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == SET_TAB_WIDGET) {
                int i_96_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_97_ = Cache.outgoingbuffer.getUnsignedByte();
                if(i_96_ == 65535)
                    i_96_ = -1;
                if(i_96_ != Class40_Sub5_Sub11.tabWidgetIds[i_97_]) {
                    Class55.method958((Class40_Sub5_Sub11.tabWidgetIds[i_97_]), -14222);
                    Class40_Sub5_Sub11.tabWidgetIds[i_97_] = i_96_;
                }
                IdentityKit.aBoolean2597 = true;
                Class57.incomingPacket = -1;
                ISAAC.redrawTabArea = true;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_SKILL) {
                ISAAC.redrawTabArea = true;
                int i_98_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                int i_99_ = Cache.outgoingbuffer.getUnsignedByte();
                int i_100_ = Cache.outgoingbuffer.getIntME1();
                Class40_Sub5_Sub17_Sub3.anIntArray3051[i_99_] = i_100_;
                Class13.anIntArray403[i_99_] = i_98_;
                Class10.anIntArray354[i_99_] = 1;
                for(int i_101_ = 0; i_101_ < 98; i_101_++) {
                    if((Class38_Sub1.anIntArray1909[i_101_] <= i_100_))
                        Class10.anIntArray354[i_99_] = i_101_ + 2;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -4) { // move widget position
                int i_102_ = Cache.outgoingbuffer.getIntBE();
                int i_103_ = Cache.outgoingbuffer.getNegativeOffsetShortLE();
                int i_104_ = Cache.outgoingbuffer.getNegativeOffsetShortLE();
                Widget widget = Widget.forId(i_102_);
                widget.currentX = widget.originalX + i_104_;
                Class57.incomingPacket = -1;
                widget.currentY = widget.originalY + i_103_;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -73) {
                for(int i_105_ = 0; ((i_105_ < Class58.varbitmasks.length)); i_105_++) {
                    if(Buffer.anIntArray1984[i_105_] != Class58.varbitmasks[i_105_]) {
                        Class58.varbitmasks[i_105_] = Buffer.anIntArray1984[i_105_];
                        Class22.method309(-1, i_105_);
                        ISAAC.redrawTabArea = true;
                    }
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -241) {
                ActorDefinition.method580(ISAAC.aClass31_521, (byte) -98, Cache.outgoingbuffer, Widget.packetsize);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 58) {
                int i_106_ = Cache.outgoingbuffer.getIntME2();
                Class12.aClass15_394 = ISAAC.aClass31_521.method393(11545, i_106_);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_SPECIFIC_WIDGET_ITEMS) {
                ISAAC.redrawTabArea = true;
                int widgetData = Cache.outgoingbuffer.getIntBE();
                Widget widget = Widget.forId(widgetData);
                while(Widget.packetsize > Cache.outgoingbuffer.currentPosition) {
                    int itemSlot = Cache.outgoingbuffer.getSmart();
                    int i_109_ = Cache.outgoingbuffer.getUnsignedShortBE();
                    int i_110_ = 0;
                    if((i_109_ ^ 0xffffffff) != -1) {
                        i_110_ = Cache.outgoingbuffer.getUnsignedByte();
                        if((i_110_ ^ 0xffffffff) == -256)
                            i_110_ = Cache.outgoingbuffer.getIntBE();
                    }
                    if(!widget.isIf3) {
                        if((itemSlot ^ 0xffffffff) <= -1 && (widget.items.length > itemSlot)) {
                            widget.items[itemSlot] = i_109_;
                            widget.itemAmounts[itemSlot] = i_110_;
                        }
                    } else {
                        Widget[] widgets = (Widget.interfaces[widgetData >> 886089392]);
                        for(int i_111_ = 0; ((i_111_ < widgets.length)); i_111_++) {
                            Widget widget_112_ = widgets[i_111_];
                            if((((widget_112_.parentId & 0xffff) ^ 0xffffffff) == (widget.id & 0xffff ^ 0xffffffff)) && 1 + itemSlot == (widget_112_.anInt2736)) {
                                widget_112_.anInt2734 = i_110_;
                                widget_112_.anInt2718 = i_109_ + -1;
                            }
                        }
                    }
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == SET_MAP_CHUNK) {
                FloorDecoration.method343(false, 5688);
                Class57.incomingPacket = -1;
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -232) { // update widget text color
                int i_113_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                int i_114_ = Cache.outgoingbuffer.getIntLE();
                int i_115_ = i_113_ >> -1304618998 & 0x1f;
                int i_116_ = 0x1f & i_113_ >> -1608786267;
                Widget widget = Widget.forId(i_114_);
                Class57.incomingPacket = -1;
                int i_117_ = i_113_ & 0x1f;
                widget.textColor = ((i_116_ << -1232932181) + (i_115_ << -1927757997) + (i_117_ << 770125059));
                return true;
            }
            if((Class57.incomingPacket ^ 0xffffffff) == -212) {
                Class42.anInt1008 = Widget.packetsize / 8;
                for(int i_118_ = 0; ((Class42.anInt1008 > i_118_)); i_118_++)
                    Class53.aLongArray1267[i_118_] = Cache.outgoingbuffer.getLongBE();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 124) {
                if(Class43.openChatboxWidgetId != -1) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class43.openChatboxWidgetId = -1;
                }
                Class52.redrawChatbox = true;
                Class66.inputInputMessage = Class66.blank_string;
                Class40_Sub5_Sub15.inputType = 2;
                Class57.incomingPacket = -1;
                Class19.aBoolean490 = false;
                return true;
            }
            CacheIndex.method169(("T1 - " + Class57.incomingPacket + "," + Cache.anInt324 + "," + Class49.anInt1151 + " - " + Widget.packetsize), (byte) -121, null);
            Class48.method928(-7225);
        } catch(java.io.IOException ioexception) {
            Class59.dropClient(2578);
        } catch(Exception exception) {
            String string = ("T2 - " + Class57.incomingPacket + "," + Cache.anInt324 + "," + Class49.anInt1151 + " - " + Widget.packetsize + "," + (SpotAnimDefinition.anInt2307 + (Player.localPlayer.anIntArray3088[0])) + "," + ((Player.localPlayer.anIntArray3135[0]) + Class26.anInt635) + " - ");
            for(int i = 0; (((Widget.packetsize > i)) && (i ^ 0xffffffff) > -51); i++)
                string += (Cache.outgoingbuffer.buffer[i] + ",");
            CacheIndex.method169(string, (byte) -120, exception);
            Class48.method928(-7225);
        }
        return true;

    }

    public static void parseNpcUpdatePacket(int arg0) {
        Class17.anInt460 = 0;
        Actor.anInt3153 = 0;
        Class40_Sub5_Sub17_Sub1.method759(false);
        Class42.method889(48);
        Npc.parseNpcUpdateMasks();
        if(arg0 > 75) {
            for(int i = 0; i < Class17.anInt460; i++) {
                int i_0_ = CacheIndex.anIntArray225[i];
                if(Node.pulseCycle != (CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_0_].anInt3134)) {
                    CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_0_].aClass40_Sub5_Sub5_3300 = null;
                    CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_0_] = null;
                }
            }
            if((Widget.packetsize ^ 0xffffffff) != (Cache.outgoingbuffer.currentPosition ^ 0xffffffff))
                throw new RuntimeException("gnp1 pos:" + (Cache.outgoingbuffer.currentPosition) + " psize:" + Widget.packetsize);
            for(int i = 0; GameObjectDefinition.anInt2558 > i; i++) {
                if((CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[Class40_Sub3.anIntArray2016[i]]) == null)
                    throw new RuntimeException("gnp2 pos:" + i + " size:" + (GameObjectDefinition.anInt2558));
            }
        }
    }

    public static void parsePlayerUpdatePacket(byte arg0) {
        Actor.anInt3153 = 0;
        Class17.anInt460 = 0;
        Actor.method786(true);
        Class29.method373((byte) -5);
        Class34.method419((byte) 108);
        Player.parseTrackedPlayerUpdateMasks();
        for(int i = 0; Class17.anInt460 > i; i++) {
            int i_8_ = CacheIndex.anIntArray225[i];
            if(((Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_8_].anInt3134) ^ 0xffffffff) != (Node.pulseCycle ^ 0xffffffff))
                Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_8_] = null;
        }
        if((Cache.outgoingbuffer.currentPosition ^ 0xffffffff) != (Widget.packetsize ^ 0xffffffff))
            throw new RuntimeException("gpp1 pos:" + (Cache.outgoingbuffer.currentPosition) + " psize:" + Widget.packetsize);
        int i = 0;
        if(arg0 < 50)
            Class27.aCacheIndex_654 = null;
        for(/**/; Class60.anInt1407 > i; i++) {
            if((Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class57.anIntArray1334[i]]) == null)
                throw new RuntimeException("gpp2 pos:" + i + " size:" + Class60.anInt1407);
        }
    }
}