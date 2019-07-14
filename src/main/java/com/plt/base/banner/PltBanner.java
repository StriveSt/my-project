package com.plt.base.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * @author zxq
 */
public class PltBanner implements Banner {

    private static final String BANNER =
            "  ____    _   _   _          _      _   _   _____ \n" +
            " |  _ \\  | | | | | |        / \\    | \\ | | |_   _|\n" +
            " | |_) | | | | | | |       / _ \\   |  \\| |   | |  \n" +
            " |  __/  | |_| | | |___   / ___ \\  | |\\  |   | |  \n" +
            " |_|      \\___/  |_____| /_/   \\_\\ |_| \\_|   |_|";

    private static final String SPRING_BOOT = " :: Base :: ";

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        out.println(BANNER);
        out.println(AnsiOutput.toString(AnsiColor.GREEN, SPRING_BOOT));
    }
}
