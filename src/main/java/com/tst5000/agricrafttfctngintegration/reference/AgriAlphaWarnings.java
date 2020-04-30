/*
 */
package com.tst5000.agricrafttfctngintegration.reference;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Random;
import java.util.function.Consumer;

/**
 *
 * @author Ryan
 */
public final class AgriAlphaWarnings {

    private static final Random RAND = new Random();

    private static final String BORING_WARNING = "AgriCraftTFCTNGIntegration is still in alpha. Bugs are to be expected.";

    private static final String[][] WARNINGS = new String[][]{
        new String[]{
            "AgriCraftTFCTNGIntegration is still in alpha.",
            "Support us by supporting the world we live in.",
            "Find a charity here: https://www.give.org"
        },
        new String[]{
            "Q: What's the difference between this version of AgriCraftTFCTNGIntegration and a Beta release?",
            "A: A Beta release is more betta!"
        },
        new String[]{
            "AgriCraftTFCTNGIntegration alphas are the first step to improving Minecraft agriculture!",
            "You could be the first step to improving real-world agriculture!",
            "Donate here: https://www.heifer.org"
        },
        new String[]{
            "AgriCraftTFCTNGIntegration has almost been completely rewritten for version 2.0.0!",
            "It even involved the creation of a whole new render system!",
            "This alpha version helps us test out all that new code."
        },
        new String[]{
            "The AgriCraftTFCTNGIntegration team thanks you for your patience in testing the alpha release!",
            "Your bug reports help us ensure release versions will be as awesome as you!",
            "Submit them here: https://github.com/InfinityRaider/AgriCraft/issues"
        },
        new String[]{
            "AgriCraftTFCTNGIntegration is continually evolving!",
            "Much like starter plants, it can be improved!",
            "(This alpha release is probaby only 5/5/5)"
        },
        new String[]{
            "AgriCraftTFCTNGIntegration Alpha release missing something?",
            "We need your help making JSON files for all the plants!",
            "Submit your JSON files at: https://github.com/AgriCraft/AgriPlants"
        },};

    public static int chooseMessageNumber() {
        return RAND.nextInt(WARNINGS.length);
    }

    public static void chooseMessage(Consumer<String> consumer) {
        if (AgriCraftConfig.disableLinks) {
            consumer.accept(ChatFormatting.DARK_AQUA + BORING_WARNING);
        } else {
            for (String line : WARNINGS[chooseMessageNumber()]) {
                consumer.accept(ChatFormatting.DARK_AQUA + line);
            }
        }
    }

}
