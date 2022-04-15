package insee.stage.demo.service;

import insee.stage.demo.model.Expense;
import insee.stage.demo.model.Metadata;
import insee.stage.demo.model.Personalization;
import insee.stage.demo.model.Statedata;
import insee.stage.demo.repository.ExpenseRepository;
import insee.stage.demo.repository.MetadataRepository;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }




    public void updateExpense(Expense expense) {
        Expense savedExpense = expenseRepository.findById(expense.getId()).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find survey units by ID %s", expense.getId())));

        savedExpense.setComment(expense.getComment());
        savedExpense.setData(expense.getData());
        savedExpense.setPersonalization(expense.getPersonalization());
        savedExpense.setStateData(expense.getStateData());

        expenseRepository.save(expense);
    }


    public void updateExpenseData(Expense expense, JSONObject data) {
        expense.setData(data);
        expenseRepository.save(expense);
    }

    public void updateExpenseComment(Expense expense, String comment) {
        expense.setComment(comment);
        expenseRepository.save(expense);
    }

    public void updateExpenseStateData(Expense expense, Statedata stateData) {
        expense.setStateData(stateData);
        expenseRepository.save(expense);
    }

    public void updateExpensePersonalization(Expense expense, Personalization personalization) {
        expense.setPersonalization(personalization);
        expenseRepository.save(expense);
    }


    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(
                String.format("Cannot fin survey units by name %s", name)));

    }

    public Expense getExpenseById(String id) {
        return expenseRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Cannot fin survey units by Id %s", id)));
    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);

    }
}
