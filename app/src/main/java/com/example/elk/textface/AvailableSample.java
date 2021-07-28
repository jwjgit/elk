package com.example.elk.textface;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import su.levenetc.android.textsurface.Text;
import su.levenetc.android.textsurface.TextBuilder;
import su.levenetc.android.textsurface.TextSurface;
import su.levenetc.android.textsurface.animations.Alpha;
import su.levenetc.android.textsurface.animations.Delay;
import su.levenetc.android.textsurface.animations.Parallel;
import su.levenetc.android.textsurface.animations.Sequential;
import su.levenetc.android.textsurface.animations.ShapeReveal;
import su.levenetc.android.textsurface.animations.SideCut;
import su.levenetc.android.textsurface.animations.Slide;
import su.levenetc.android.textsurface.animations.TransSurface;
import su.levenetc.android.textsurface.contants.Align;
import su.levenetc.android.textsurface.contants.Pivot;
import su.levenetc.android.textsurface.contants.Side;

public class AvailableSample {

    public static void play(TextSurface textSurface, AssetManager assetManager) {

        //final Typeface robotoBlack = Typeface.createFromAsset(assetManager, "fonts/.ttf");
        Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/Raleway-Light.ttf");
        Typeface typeface2 = Typeface.createFromAsset(assetManager, "fonts/Reckoner_Bold.ttf");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTypeface(typeface);

        Text textDaai = TextBuilder
                .create("万重山")
                .setPaint(paint)
                .setSize(64)
                .setAlpha(0)
                .setColor(Color.WHITE)

                .setPosition(Align.SURFACE_CENTER).build();

        Text textBraAnies = TextBuilder
                .create("千条河")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF, textDaai).build();

        Text textFokkenGamBra = TextBuilder
                .create(" 有缘辛苦来相会")
                .setPaint(paint)
                .setSize(24)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF, textBraAnies).build();

        Text textHaai = TextBuilder
                .create("万日月")
                .setPaint(paint)
                .setSize(74)
                .setAlpha(0)
                .setColor(Color.MAGENTA)
                .setPosition(Align.BOTTOM_OF, textFokkenGamBra).build();

        Text textDaaiAnies = TextBuilder
                .create("千春秋")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.WHITE)
                .setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textHaai).build();

        Text texThyLamInnie = TextBuilder
                .create(" 满头青丝变白头")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.BLUE)
                .setPosition(Align.RIGHT_OF, textDaaiAnies).build();

        Text textThrowDamn = TextBuilder
                .create("跨过重重星域，不可抑制地奔向金星")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF | Align.CENTER_OF, texThyLamInnie).build();

        Text textDevilishGang = TextBuilder
                .create("我们是洪荒里相互寻找的星星")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textThrowDamn).build();

        Text textSignsInTheAir = TextBuilder
                .create("相爱已万年")
                .setPaint(paint)
                .setSize(44)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textDevilishGang).build();
        Text text1 = TextBuilder
                .create("爱你")
                .setPaint(paint)
                .setSize(84)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF | Align.CENTER_OF,textSignsInTheAir ).build();


        textSurface.play(
                new Sequential(
                        ShapeReveal.create(textDaai, 750, SideCut.show(Side.LEFT), false),
                        new Parallel(ShapeReveal.create(textDaai, 600, SideCut.hide(Side.LEFT), false), new Sequential(Delay.duration(300), ShapeReveal.create(textDaai, 600, SideCut.show(Side.LEFT), false))),
                        new Parallel(new TransSurface(500, textBraAnies, Pivot.CENTER), ShapeReveal.create(textBraAnies, 100, SideCut.show(Side.LEFT), false)),
                        Delay.duration(500),
                        new Parallel(
                                ShapeReveal.create(textThrowDamn, 1500, SideCut.hide(Side.LEFT), true),
                                new Sequential(Delay.duration(250), ShapeReveal.create(textDevilishGang, 1500, SideCut.hide(Side.LEFT), true)),
                                new Sequential(Delay.duration(500), ShapeReveal.create(textSignsInTheAir, 1500, SideCut.hide(Side.LEFT), true)),
                                Alpha.hide(texThyLamInnie, 1500),
                                Alpha.hide(textDaaiAnies, 1500),
                                Alpha.hide(textFokkenGamBra, 1500),
                                Alpha.hide(textHaai, 1500)
                               // new Parallel(TransSurface.toCenter(texThyLamInnie, 750), Slide.showFrom(Side.LEFT, texThyLamInnie, 500))

                                //new Sequential(Delay.duration(500), ShapeReveal.create(text1, 1500, SideCut.hide(Side.LEFT), true))

                        )


                         /*
                          new Parallel(
                                //ShapeReveal.create(text1, 1500, SideCut.hide(Side.LEFT), false),
                                new Sequential(Delay.duration(250), ShapeReveal.create(text1, 1500, SideCut.hide(Side.LEFT), false))
                        ),
                        new Parallel(new TransSurface(150, textFokkenGamBra, Pivot.CENTER), Slide.showFrom(Side.LEFT, textFokkenGamBra, 750), ChangeColor.to(textFokkenGamBra, 750, Color.WHITE)),

                        new Parallel(TransSurface.toCenter(textHaai, 500), Rotate3D.showFromSide(textHaai, 750, Pivot.TOP))
                        new Parallel(TransSurface.toCenter(textDaaiAnies, 500), Slide.showFrom(Side.TOP, textDaaiAnies, 500)),
                        new Parallel(TransSurface.toCenter(texThyLamInnie, 750), Slide.showFrom(Side.LEFT, texThyLamInnie, 500)),
                        Delay.duration(500),
                        new Parallel(
                                new TransSurface(1500, textSignsInTheAir, Pivot.CENTER),
                                new Sequential(
                                        new Sequential(ShapeReveal.create(textThrowDamn, 500, Circle.show(Side.CENTER, Direction.OUT), false)),
                                        new Sequential(ShapeReveal.create(textDevilishGang, 500, Circle.show(Side.CENTER, Direction.OUT), false)),
                                        new Sequential(ShapeReveal.create(textSignsInTheAir, 500, Circle.show(Side.CENTER, Direction.OUT), false))
                                )
                        ),
                        Delay.duration(200),
                        new Parallel(
                                ShapeReveal.create(textThrowDamn, 1500, SideCut.hide(Side.LEFT), true),
                                new Sequential(Delay.duration(250), ShapeReveal.create(textDevilishGang, 1500, SideCut.hide(Side.LEFT), true)),
                                new Sequential(Delay.duration(500), ShapeReveal.create(textSignsInTheAir, 1500, SideCut.hide(Side.LEFT), true)),
                                Alpha.hide(texThyLamInnie, 1500),
                                Alpha.hide(textDaaiAnies, 1500),
                                Alpha.hide(textFokkenGamBra, 1500),
                                Alpha.hide(textHaai, 1500)
                                //new Sequential(Delay.duration(500), ShapeReveal.create(text1, 1500, SideCut.hide(Side.LEFT), true))


                                ),
                        //new Parallel(TransSurface.toCenter(text1,500),Slide.showFrom(Side.CENTER,text1,500)),
                        //new Parallel(ShapeReveal.create(text1, 600, SideCut.hide(Side.LEFT), false), new Sequential(Delay.duration(100), ShapeReveal.create(text1, 600, SideCut.show(Side.LEFT), false)))
                        new Parallel(
                                //ShapeReveal.create(text1, 1500, SideCut.hide(Side.LEFT), false),
                                new Sequential(Delay.duration(250), ShapeReveal.create(text1, 1500, SideCut.hide(Side.LEFT), false))
                        )

                         */

                )
        );

    }



}
