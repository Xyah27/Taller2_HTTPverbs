package co.com.NunezJuanJoseHTTP.controller;
import co.com.NunezJuanJoseHTTP.service.ItemService;
import co.com.NunezJuanJoseHTTP.model.GroceryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    // 1. Método de ejemplo para verbo GET
    @GetMapping("/getAll")
    public String getAll(){
        return itemService.getAll();
    }

    // 2. Método de ejemplo para verbo POST
    @PostMapping("/insert")
    public String insert(@RequestBody GroceryItem groceryItem){
        return itemService.insert(groceryItem);
    }

    // 3. Método de ejemplo para verbo UPDATE
    @PutMapping("/update")
    public String update(@RequestBody GroceryItem groceryItem){
        return itemService.update(groceryItem);
    }

    // 4. Método de ejemplo para verbo DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") String id) {
        return itemService.delete(id);
    }

    // 5. Método de ejemplo para verbo PATCH
    @PatchMapping("/updateData/{id}")
    public String updateData(@PathVariable String id, @RequestBody GroceryItem groceryItem){
        return itemService.updateData(id, groceryItem);
    }

    // 6. Método de ejemplo para verbo HEAD
    @RequestMapping(value = "/getAll", method = RequestMethod.HEAD)
    public ResponseEntity<?> handleHeadRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}