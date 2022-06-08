import javafx.scene.control.ListCell;

public class DatumCell extends ListCell<Spieltag> {
    Spieltag s = new Spieltag();

    @Override
    //Formatierung der Listview listdate; zeigt nun name und datum des ft an
    protected void updateItem(Spieltag item, boolean empty) {
        super.updateItem(item, empty);
        if (item!=null&&!empty) setText(item.getnameSpieltag() + "        " + item.getLocalDate());
    }
}
