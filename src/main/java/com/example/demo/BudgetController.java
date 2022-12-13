package com.example.demo;

import com.example.demo.model.BudgetHistory;
import com.example.demo.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/budget")
public class BudgetController {
//    @Autowired BudgetService service;
//    private double totalBudget = 1000;
//    private ArrayList<BudgetHistory> history = new ArrayList<>();


    @GetMapping("/show")
    public BudgetHistory showHistoryOne(@RequestParam int id) throws SQLException, ClassNotFoundException {
        var service = new BudgetService();
        return service.selectById(id);
    }

    @GetMapping("/showAll")
    public Iterable<BudgetHistory> showHistory() throws SQLException {
        var service = new BudgetService();
        return service.showAll();
    }

    @GetMapping("/income")
    public Iterable<BudgetHistory> income(@RequestParam double moneyAmount,@RequestParam String description,@RequestParam int BranchOfficeId) throws SQLException {
        // http://localhost:8080/budget/income?action=14&description=ohmy
        var service = new BudgetService();
        service.Add(new BudgetHistory(-1,moneyAmount, description,BranchOfficeId));
        return service.showAll();
    }

//    @GetMapping("/outcome")
//    public ArrayList<BudgetHistory> outcome(double moneyAmount, String description) {
//        BudgetHistory budgetHistory = new BudgetHistory(moneyAmount, description);
//        history.add(budgetHistory);
//        return history;
//    }
    @GetMapping("/delete")
    BudgetHistory delete(@RequestParam int id) throws SQLException {
        var service = new BudgetService();
        return service.delete(id);
    }
}
