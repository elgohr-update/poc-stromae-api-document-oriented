package insee.stage.demo.controller;

import insee.stage.demo.model.Expense;
import insee.stage.demo.model.Metadata;
import insee.stage.demo.model.Personalization;
import insee.stage.demo.model.Statedata;
import insee.stage.demo.service.ExpenseService;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survey-units")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }






    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
       return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    /** GET /survey-unit**/
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable String id) {
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    /**GET nomenclature rep **/
    /**GET nomenclature  **/

    /**GET questionnaire modele **/

    /**GET metadata **/



    /**GET personalization **/

    /** PUT state-data **/

    @PutMapping("/{id}/state-data")
    public ResponseEntity updateStateDataById(@PathVariable String id, @RequestBody Statedata  stateData){
        Expense expense = expenseService.getExpenseById(id);
        expenseService.updateExpenseStateData(expense, stateData);
        return ResponseEntity.ok().build();
    }

    /** PUT data **/

    @PutMapping("/{id}/data")
    public ResponseEntity updateDataById(@PathVariable String id, @RequestBody JSONObject  data){
      Expense expense = expenseService.getExpenseById(id);
      expenseService.updateExpenseData(expense, data);
      return ResponseEntity.ok().build();
    }



    /** PUT survey unit **/
    @PutMapping
    public ResponseEntity<Object> updateExpense(@RequestBody Expense expense) {
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }







    /** GET personalization **/

    @GetMapping("/{id}/personalization")
    public ResponseEntity<Personalization> getDataByPersonalization(@PathVariable String id) {
        return  ResponseEntity.ok(expenseService.getExpenseById(id).getPersonalization());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExpense(@PathVariable String  id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
