package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.util.Signlink;

import java.awt.*;
import java.awt.event.*;

public class GameFrame implements MouseListener, MouseMotionListener, FocusListener, MouseWheelListener {
    public static int anInt1450;
    public static Cache aClass9_1455;
    public static int anInt1457 = -1;
    public static RSString aClass1_1463;
    public static RSString aClass1_1464;
    public static RSString aClass1_1465;
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array1466;
    public static int anInt1468;
    public static Canvas aCanvas1469;
    public static int clickType;
    public static RSString aClass1_1471;
    public static int chatboxScrollMax;
    public static byte[][][] aByteArrayArrayArray1473;
    public static RSString aClass1_1474;
    public static int cameraZoom = 600;
    public boolean mouseWheelDown;
    public int mouseWheelX;
    public int mouseWheelY;

    static {
        anInt1450 = -1;
        aClass9_1455 = new Cache(50);
        aClass1_1464 = RSString.CreateString(" is already on your friend list");
        aClass1_1465 = aClass1_1464;
        aClass40_Sub5_Sub14_Sub4Array1466 = new ImageRGB[1000];
        aClass1_1463 = RSString.CreateString("wave2:");
        clickType = 0;
        chatboxScrollMax = 78;
        aClass1_1471 = RSString.CreateString("Lade Titelbild )2 ");
        aClass1_1474 = aClass1_1463;
    }

    public static void method1001(boolean arg0) {

        aClass1_1471 = null;
        aClass40_Sub5_Sub14_Sub4Array1466 = null;
        aClass1_1465 = null;
        if(arg0 != true)
            method1003(null, null, 31);
        aClass1_1463 = null;
        aClass9_1455 = null;
        aCanvas1469 = null;
        aClass1_1464 = null;
        aClass1_1474 = null;
        aByteArrayArrayArray1473 = null;

    }

    public static void method1002(int arg0) {
        if((SceneTile.activeInterfaceType ^ 0xffffffff) == -1) {
            if(arg0 > -60)
                clickType = -90;
            int i = clickType;
            if((Main.anInt1773 ^ 0xffffffff) == -2 && (Class57.anInt1338 ^ 0xffffffff) <= -517 && (RSString.anInt1668 ^ 0xffffffff) <= -161 && (Class57.anInt1338 ^ 0xffffffff) >= -766 && RSString.anInt1668 <= 205)
                i = 0;
            if(!Class4.menuOpen) {
                if(i == 1 && (ActorDefinition.anInt2394 ^ 0xffffffff) < -1) {
                    int i_0_ = (Class38.anIntArray884[ActorDefinition.anInt2394 - 1]);
                    if((i_0_ ^ 0xffffffff) == -54 || i_0_ == 25 || i_0_ == 55 || (i_0_ ^ 0xffffffff) == -49 || (i_0_ ^ 0xffffffff) == -25 || (i_0_ ^ 0xffffffff) == -53 || (i_0_ ^ 0xffffffff) == -7 || i_0_ == 31 || (i_0_ ^ 0xffffffff) == -44 || i_0_ == 11 || i_0_ == 19 || i_0_ == 1006) {
                        int i_1_ = (Class19.anIntArray483[ActorDefinition.anInt2394 - 1]);
                        int i_2_ = (Class59.anIntArray1393[-1 + ActorDefinition.anInt2394]);
                        Widget widget = Class68.method1045(i_2_, (byte) -58);
                        if(widget.itemSwapable || widget.itemDeletesDraged) {
                            Renderable.anInt2869 = Class57.anInt1338;
                            Class40_Sub5_Sub15.aBoolean2784 = false;
                            SceneTile.activeInterfaceType = 2;
                            Class48.anInt1127 = i_2_;
                            ItemDefinition.anInt2798 = RSString.anInt1668;
                            Class58.anInt1352 = i_1_;
                            if((Class66.anInt1560 ^ 0xffffffff) == (i_2_ >> 799918864 ^ 0xffffffff))
                                SceneTile.activeInterfaceType = 1;
                            if((i_2_ >> 1441108912 ^ 0xffffffff) == (Class43.openChatboxWidgetId ^ 0xffffffff))
                                SceneTile.activeInterfaceType = 3;
                            Buffer.anInt1978 = 0;
                            return;
                        }
                    }
                }
                if((i ^ 0xffffffff) == -2 && ((Class68.anInt1630 ^ 0xffffffff) == -2 || Class33.method409((byte) 46, -1 + ActorDefinition.anInt2394)) && (ActorDefinition.anInt2394 ^ 0xffffffff) < -3)
                    i = 2;
                if(i == 1 && ActorDefinition.anInt2394 > 0)
                    Class27.method358(59, ActorDefinition.anInt2394 + -1);
                if(i == 2 && ActorDefinition.anInt2394 > 0)
                    Class60.method990(11451);
            } else {
                if((i ^ 0xffffffff) != -2) {
                    int i_3_ = Class13.mouseX;
                    int i_4_ = Landscape.mouseY;
                    if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 0) {
                        i_3_ -= 4;
                        i_4_ -= 4;
                    }
                    if((Class40_Sub5_Sub17_Sub1.menuScreenArea ^ 0xffffffff) == -2) {
                        i_4_ -= 205;
                        i_3_ -= 553;
                    }
                    if((Class40_Sub5_Sub17_Sub1.menuScreenArea ^ 0xffffffff) == -3) {
                        i_4_ -= 357;
                        i_3_ -= 17;
                    }
                    if((-10 + Class19.anInt475 > i_3_) || 10 + VertexNormal.anInt1086 + Class19.anInt475 < i_3_ || (i_4_ < Main.anInt1758 + -10) || ((i_4_ > Main.anInt1758 + CollisionMap.anInt168 + 10))) {
                        if((Class40_Sub5_Sub17_Sub1.menuScreenArea ^ 0xffffffff) == -2)
                            ISAAC.redrawTabArea = true;
                        Class4.menuOpen = false;
                        if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 2)
                            Class52.redrawChatbox = true;
                    }
                }
                if((i ^ 0xffffffff) == -2) {
                    int i_5_ = Class19.anInt475;
                    int i_6_ = Main.anInt1758;
                    int i_7_ = VertexNormal.anInt1086;
                    int i_8_ = Class57.anInt1338;
                    int i_9_ = -1;
                    int i_10_ = RSString.anInt1668;
                    if((Class40_Sub5_Sub17_Sub1.menuScreenArea ^ 0xffffffff) == -1) {
                        i_8_ -= 4;
                        i_10_ -= 4;
                    }
                    if((Class40_Sub5_Sub17_Sub1.menuScreenArea ^ 0xffffffff) == -2) {
                        i_8_ -= 553;
                        i_10_ -= 205;
                    }
                    if((Class40_Sub5_Sub17_Sub1.menuScreenArea ^ 0xffffffff) == -3) {
                        i_8_ -= 17;
                        i_10_ -= 357;
                    }
                    for(int i_11_ = 0; ((i_11_ < ActorDefinition.anInt2394)); i_11_++) {
                        int i_12_ = 31 + i_6_ + 15 * (ActorDefinition.anInt2394 + -1 - i_11_);
                        if(i_8_ > i_5_ && i_8_ < i_7_ + i_5_ && i_10_ > -13 + i_12_ && i_10_ < 3 + i_12_)
                            i_9_ = i_11_;
                    }
                    if((i_9_ ^ 0xffffffff) != 0)
                        Class27.method358(109, i_9_);
                    if((Class40_Sub5_Sub17_Sub1.menuScreenArea ^ 0xffffffff) == -2)
                        ISAAC.redrawTabArea = true;
                    Class4.menuOpen = false;
                    if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 2)
                        Class52.redrawChatbox = true;
                }
            }
        }
    }

    public static Class40_Sub9_Sub1 method1003(Signlink arg0, Component arg1, int arg2) {

        if(arg2 != 29914)
            aByteArrayArrayArray1473 = null;
        Class68.method1040(arg1, 0, arg0);
        Class40_Sub9_Sub1 class40_sub9_sub1 = new Class40_Sub9_Sub1();
        Class8.method218(class40_sub9_sub1, -125);
        return class40_sub9_sub1;

    }

    public synchronized void mouseEntered(MouseEvent arg0) {
        if(GameObject.frame != null) {
            Class45.anInt1073 = 0;
            Class12.anInt389 = arg0.getX();
            Cache.anInt322 = arg0.getY();
        }
    }

    public synchronized void mouseExited(MouseEvent arg0) {
        if(GameObject.frame != null) {
            Class45.anInt1073 = 0;
            Class12.anInt389 = -1;
            Cache.anInt322 = -1;
        }
    }

    public synchronized void focusLost(FocusEvent arg0) {
        if(GameObject.frame != null)
            Cache.mouseButtonPressed = 0;
    }

    public synchronized void mouseDragged(MouseEvent mouseEvent) {
        int mouseX = mouseEvent.getX();
        int mouseY = mouseEvent.getY();
        if(GameObject.frame != null) {
            Class45.anInt1073 = 0;
        }
        if(mouseWheelDown) {
            mouseY = mouseWheelX - mouseEvent.getX();
            int k = mouseWheelY - mouseEvent.getY();
            mouseWheelDragged(mouseY, -k);
            mouseWheelX = mouseEvent.getX();
            mouseWheelY = mouseEvent.getY();
            return;
        }
        Class12.anInt389 = mouseX;
        Cache.anInt322 = mouseY;
    }

    private void mouseWheelDragged(int i, int j) {
        if(!mouseWheelDown)
            return;
        Class10.cameraVelocityHorizontal += i * 3;
        Class60.cameraVelocityVertical += (j << 1);
    }

    public void focusGained(FocusEvent arg0) {
    }

    public synchronized void mousePressed(MouseEvent event) {
        if(GameObject.frame != null) {

            int mouseX = event.getX();
            int mouseY = event.getY();
            Class45.anInt1073 = 0;
            Class55.eventClickX = event.getX();
            Class40_Sub5_Sub11.eventClickY = event.getY();
            Floor.lastClick = System.currentTimeMillis();
            if(event.getButton() == MouseEvent.BUTTON2) {
                mouseWheelDown = true;
                mouseWheelX = mouseX;
                mouseWheelY = mouseY;
                return;
            }
            if(event.isMetaDown() || event.getButton() == MouseEvent.BUTTON3) {
                Actor.eventMouseButtonPressed = 2;
                Cache.mouseButtonPressed = 2;
            } else {
                Actor.eventMouseButtonPressed = 1;
                Cache.mouseButtonPressed = 1;
            }
        }
        if(event.isPopupTrigger())
            event.consume();
    }

    public void mouseWheelMoved(MouseWheelEvent event) {
        System.out.println(cameraZoom);
        int rotation = event.getWheelRotation();
        //            if (!handleInterfaceScrolling(event, (Game) this)) {
        if((cameraZoom <= 300 && rotation <= 0) || (cameraZoom >= 1200 && rotation >= 0)) {
            return;
        }
        int diff = rotation * 8;
        cameraZoom = cameraZoom + diff;
    }

    public void mouseClicked(MouseEvent arg0) {
        if(arg0.isPopupTrigger())
            arg0.consume();
    }

    public synchronized void mouseMoved(MouseEvent arg0) {
        if(GameObject.frame != null) {
            Class45.anInt1073 = 0;
            Class12.anInt389 = arg0.getX();
            Cache.anInt322 = arg0.getY();
        }
    }

    public synchronized void mouseReleased(MouseEvent arg0) {
        if(GameObject.frame != null) {
            Class45.anInt1073 = 0;
            Cache.mouseButtonPressed = 0;
            mouseWheelDown = false;
        }
        if(arg0.isPopupTrigger())
            arg0.consume();
    }
}