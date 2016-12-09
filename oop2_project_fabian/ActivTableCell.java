package ch.fhnw.oop2.DepartureBoard;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.HashMap;
import java.util.Map;
import ch.fhnw.oop2.DepartureBoard.*;

/**
 * Created by LORENZO MANN
 */
public class ActivTableCell extends TableCell<Result, String> {
    private static final Map<String, Image> Aktiv = new HashMap<>();

    private static final Insets INSETS = new Insets(1, 8, 1, 5);

    @Override
    protected void updateItem(String item, boolean empty) {
        setText("");
        setGraphic(null);
        if (!empty) {
            Image img = Aktiv.get(item);
            if (img == null) {
                img = new Image(getClass().getResource("marks/Mark_Green.png")
                        .toExternalForm(), 10, 10, true, true, true);
                Aktiv.put(item, img);
            }

            ImageView imageView = new ImageView(img);

            setGraphic(imageView);
            setTooltip(new Tooltip(item));
            setAlignment(Pos.CENTER);
            setPadding(INSETS);
        }

    }
}


