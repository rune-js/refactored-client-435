package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;

import java.awt.*;

public class RSCanvas extends Canvas {
    public static byte[][] aByteArrayArray47 = new byte[50][];
    public static CacheIndex_Sub1 aClass6_Sub1_48;
    public static String aClass1_51 = "shake:";
    public static LinkedList aLinkedList_53 = new LinkedList();
    public static int anInt54 = 0;
    public static int anInt57;
    public static Class68 aClass68_59;
    public static int anInt60 = 255;
    public static CacheIndex aCacheIndex_61;
    public static int[] anIntArray62;
    public static String aClass1_63 = "Prepared visibility map";
    public static Class68 aClass68_64;
    public static int anInt65 = 127;
    public static int[] anIntArray66;
    public static String aClass1_67 = "Your profile will be transferred in:";
    public static String aClass1_68 = "k";

    public Component aComponent49;

    public RSCanvas(Component arg0) {
        aComponent49 = arg0;
    }

    public static void method45(byte arg0) {
        RSString.aClass68_1665.method1046((byte) 90);
        if(arg0 > -12)
            method47();
    }

    public static void method46(int arg0) {
        Cache.method233(true);
        CacheIndex.method189(false);
        Widget.method640();
        Widget.method645();
        Class40_Sub5_Sub6.method586(64);
        Class8.method211();
        CacheIndex.method188();
        Class22_Sub2.method316(-11965);
        LinkedList.method907(-99);
        Class5.method167(1023);
        Class51.method941();
        Actor.method783();
        ((Class35) Rasterizer3D.anInterface3_2939).method422(arg0);
        Class17.aClass9_449.method235((byte) 96);
        FloorDecoration.aClass6_Sub1_605.method191(1120);
        Class40_Sub5_Sub17_Sub1.aClass6_Sub1_3000.method191(1120);
        Class65.aClass6_Sub1_1533.method191(arg0 + 1120);
        Actor.aClass6_Sub1_3157.method191(1120);
        Renderable.aClass6_Sub1_2857.method191(1120);
        Class55.aClass6_Sub1_1286.method191(1120);
        UnderlayDefinition.aClass6_Sub1_2571.method191(1120);
        ActorDefinition.aClass6_Sub1_2377.method191(arg0 ^ 0x460);
        SceneCluster.aClass6_Sub1_773.method191(1120);
        aClass6_Sub1_48.method191(arg0 + 1120);
        VertexNormal.aClass6_Sub1_1104.method191(1120);
        Class56.aClass6_Sub1_1323.method191(1120);
    }

    public static void method47() {
        aClass1_68 = null;
        aByteArrayArray47 = null;
        aClass6_Sub1_48 = null;
        aClass1_63 = null;
        anIntArray62 = null;
        aLinkedList_53 = null;
        aClass1_51 = null;
        aCacheIndex_61 = null;
        aClass68_64 = null;
        anIntArray66 = null;
        aClass1_67 = null;
        aClass68_59 = null;
    }

    public void paint(Graphics arg0) {
        aComponent49.paint(arg0);
    }

    public void update(Graphics arg0) {
        aComponent49.update(arg0);
    }
}