package co.com.NunezJuanJoseHTTP.service;

import co.com.NunezJuanJoseHTTP.model.GroceryItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ItemService {

    private List<GroceryItem> groceryItems;
    private boolean started = false;

    // Inicializa la lista de items si no ha sido iniciada
    public void setGroceryItems() {
        if (!this.started) {
            this.groceryItems = new ArrayList<>();
            groceryItems.add(new GroceryItem("Whole", "Whole Wheat Biscuit", 5, "snacks"));
            groceryItems.add(new GroceryItem("Dried", "Dried Whole Red Chilli", 2, "spices"));
            groceryItems.add(new GroceryItem("Pearl", "Healthy Pearl Millet", 1, "millets"));
            groceryItems.add(new GroceryItem("Cheese", "Bonny Cheese Crackers Plain", 6, "snacks"));
            this.started = true;
        }
    }

    // Devuelve todos los items en la lista
    public String getAll() {
        setGroceryItems();
        return "---ITEMS EXISTENTES---\n" + groceryItems.toString();
    }

    // Inserta un nuevo item en la lista
    public String insert(GroceryItem groceryItem) {
        setGroceryItems();
        groceryItems.add(new GroceryItem(groceryItem.getId(), groceryItem.getName(), groceryItem.getQuantity(), groceryItem.getCategory()));
        return "---ITEM INSERTADO---\n" + groceryItem.toString();
    }

    // Actualiza un item existente en la lista
    public String update(GroceryItem groceryItem) {
        setGroceryItems();
        Iterator<GroceryItem> iterator = groceryItems.iterator();
        while (iterator.hasNext()) {
            GroceryItem item = iterator.next();
            if (item.getId().equals(groceryItem.getId())) {
                item.setName(groceryItem.getName());
                item.setQuantity(groceryItem.getQuantity());
                item.setCategory(groceryItem.getCategory());
                return "---ITEM ACTUALIZADO---\n" + item.toString();
            }
        }
        return "---ITEM NO ENCONTRADO---";
    }

    // Elimina un item de la lista por ID
    public String delete(String id) {
        setGroceryItems();
        Iterator<GroceryItem> iterator = groceryItems.iterator();
        while (iterator.hasNext()) {
            GroceryItem item = iterator.next();
            if (item.getId().equals(id)) {
                iterator.remove();
                return "---ITEM ELIMINADO---";
            }
        }
        return "---ITEM NO ENCONTRADO---";
    }

    // Actualiza parcialmente los datos de un item por ID
    public String updateData(String id, GroceryItem groceryItem) {
        setGroceryItems();
        Iterator<GroceryItem> iterator = groceryItems.iterator();
        while (iterator.hasNext()) {
            GroceryItem item = iterator.next();
            if (item.getId().equals(id)) {
                if (groceryItem.getName() != null) {
                    item.setName(groceryItem.getName());
                }
                if (groceryItem.getCategory() != null) {
                    item.setCategory(groceryItem.getCategory());
                }
                return "---ITEM ACTUALIZADO---\n" + item.toString();
            }
        }
        return "---ITEM NO ENCONTRADO---";
    }

    // Devuelve las opciones disponibles para la actualización
    public String optionsUpdate() {
        return "OPTIONS: It inserts a new grocery item. If the grocery item doesn't exist, it will be created automatically.";
    }
}
