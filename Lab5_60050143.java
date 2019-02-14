import java.awt.*;
import javax.swing.*;

class Lab5_60050143 extends JPanel {

    public static void main(String[] args) {
        Lab5_60050143 m = new Lab5_60050143();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Lab5");
        // f.setBackground(Color.WHITE);
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

    public void paintComponent(Graphics g) {
        midpointEllipse(g, new Point(300, 300), 300, 100, Color.BLACK);

    }

    // draw dot Graphics
    public void plot(Graphics g, Color c, int x, int y) {

        g.setColor(c);
        g.fillRect(x, y, 1, 1);

    }

    public void midpointEllipse(Graphics g, Point M, int a, int b, Color color) {
        int a2 = a * a, b2 = b * b, twoA2 = 2 * a2, twoB2 = 2 * b2;

        // REGION1
        int x = 0;
        int y = b;
        int Dx = 0, Dy = twoA2 * y, D = (int) (b2 - a2 * b + a2 / 4);

        while (Dx <= Dy) {
            //
            // plot(g, color, M.x + x, M.y + y);
            // plot(g, color, M.x + x, M.y - y);
            // plot(g, color, M.x - x, M.y + y);
            // plot(g, color, M.x - x, M.y - y);
            g.drawLine(M.x, M.y, M.x + x, M.y + y);
            g.drawLine(M.x, M.y, M.x - x, M.y + y);
            g.drawLine(M.x, M.y, M.x + x, M.y - y);
            g.drawLine(M.x, M.y, M.x - x, M.y - y);

            x++;
            Dx += twoB2;
            D += Dx + b2;

            if (D >= 0) {
                y--;
                Dy -= twoA2;
                D -= Dy;
            }
        }

        // REGION 2
        x = a;
        y = 0;
        Dy = 0;
        Dx = twoB2 * x;
        D = (int) (a2 - b2 * a + b2 / 4);
        while (Dx >= Dy) {
            //
            plot(g, color, M.x + x, M.y + y);
            plot(g, color, M.x + x, M.y - y);
            plot(g, color, M.x - x, M.y + y);
            plot(g, color, M.x - x, M.y - y);

            g.drawLine(M.x, M.y, M.x + x, M.y + y);
            g.drawLine(M.x, M.y, M.x - x, M.y + y);
            g.drawLine(M.x, M.y, M.x + x, M.y - y);
            g.drawLine(M.x, M.y, M.x - x, M.y - y);

            y++;
            Dy += twoA2;
            D += Dy + a2;

            if (D >= 0) {
                x--;
                Dx -= twoB2;
                D -= Dx;
            }
        }
    }
}
