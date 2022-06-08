import javafx.scene.control.ListCell;

public class DatumCell extends ListCell<Spieltag> {
    Spieltag s = new Spieltag();

    @Override
    protected void updateItem(Spieltag item, boolean empty) {
        super.updateItem(item, empty);
        if (item==null&!empty) setText(item.getspieltag() + "        " + item.getLocalDate());
    }
}
