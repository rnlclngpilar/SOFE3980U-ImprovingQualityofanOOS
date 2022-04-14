package pack;

import javax.swing.*;
import java.awt.*;
// taken from https://www.ece.uvic.ca/~shsaad/seng426/resources/Lab%20Slides/Lab4-SENG09.pdf
public class TestUtils {

    public static Component getChildNamed(Component parent, String name) {

        if (name.equals(parent.getName())) { return parent; }

        if (parent instanceof Container) {
            Component[] children = (parent instanceof JMenu) ? ((JMenu)parent).getMenuComponents() : ((Container)parent).getComponents();
            for (int i = 0; i < children.length; ++i) {
                Component child = getChildNamed(children[i], name);
                if (child != null) { return child; }
            }
        }
        return null;
    }
}
