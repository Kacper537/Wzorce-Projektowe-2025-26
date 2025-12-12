package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class MyGraphicsView extends JPanel implements IView {
    private String text = "";

    @Override
    public void setText(String data) {
        this.text = data;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        String formatted = "00000.00";

        try {
            double value = Double.parseDouble(text);
            double absValue = Math.abs(value);

            int digits = (absValue < 1) ? 1 : (int) Math.log10(absValue) + 1;

            if (digits > 5) {
                double factor = Math.pow(10, digits - 5);
                absValue = Math.round(absValue / factor * 100.0) / 100.0;
            } else {
                absValue = Math.round(absValue * 100.0) / 100.0;
            }

            long intPart = (long) absValue;
            int decimalPart = (int) Math.round((absValue - intPart) * 100);

            formatted = String.format(Locale.US, "%05d.%02d", intPart, decimalPart);

            if (value < 0) formatted = "-" + formatted;

        } catch (NumberFormatException ignored) {}

        boolean negative = formatted.startsWith("-");
        String core = negative ? formatted.substring(1) : formatted;
        String[] parts = core.split("\\.");
        String intPartStr = parts[0];
        String decPartStr = parts[1];

        g.setFont(new Font("Consolas", Font.BOLD, 40));
        FontMetrics fm = g.getFontMetrics();
        int totalWidth = fm.stringWidth((negative ? "-" : "") + intPartStr + "." + decPartStr);
        int x = Math.max(10, (getWidth() - totalWidth) / 2);
        int y = getHeight() / 2 + fm.getAscent() / 2 - 4;

        if (negative) {
            g.setColor(Color.BLACK);
            g.drawString("-", x, y);
            x += fm.stringWidth("-");
        }

        g.setColor(Color.BLUE);
        g.drawString(intPartStr, x, y);
        x += fm.stringWidth(intPartStr);

        g.setColor(Color.BLACK);
        g.drawString(".", x, y);
        x += fm.stringWidth(".");

        g.setColor(Color.RED);
        g.drawString(decPartStr, x, y);
    }
}
