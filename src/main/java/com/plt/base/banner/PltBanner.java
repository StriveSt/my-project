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

    private static final String[] BANNER =
            {
                    "  ____            _                   _   ",
                    " |  _ \\   _   _  | |   __ _   _ __   | |_ ",
                    " | |_) | | | | | | |  / _` | | '_ \\  | __|",
                    " |  __/  | |_| | | | | (_| | | | | | | |_ ",
                    " |_|      \\__,_| |_|  \\__,_| |_| |_|  \\__|",
            };

    private static final String SPRING_BOOT = " :: Base :: ";

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        out.println(AnsiOutput.toString(AnsiColor.BRIGHT_BLUE, BANNER[0]));
        out.println(AnsiOutput.toString(AnsiColor.BRIGHT_GREEN, BANNER[1]));
        out.println(AnsiOutput.toString(AnsiColor.BRIGHT_YELLOW, BANNER[2]));
        out.println(AnsiOutput.toString(AnsiColor.BRIGHT_MAGENTA, BANNER[3]));
        out.println(AnsiOutput.toString(AnsiColor.BRIGHT_RED, BANNER[4]));
        out.println(AnsiOutput.toString(AnsiColor.GREEN, SPRING_BOOT));
    }
}
