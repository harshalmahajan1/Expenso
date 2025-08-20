import "./App.css";
import React, { useState, useEffect } from "react";
import Expenses from "./components/Expenses";
import NewExpense from "./components/NewExpense";
function App() {
  let dummyData = [
    {
      title: "Car Insurance",
      amount: 294.67,
      date: new Date(2022, 2, 28),
    },
    {
      title: "Health Insurance",
      amount: 294.67,
      date: new Date(2022, 2, 28),
    },
    {
      title: "Home Insurance",
      amount: 294.67,
      date: new Date(2022, 2, 28),
    },
  ];

  const [expenses, setExpenses] = useState(dummyData);

  function fetchExpenseData() {
    fetch("http://localhost:8080/expense/get-all-expenses")
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        const expenseData = data.map((item) => {
          return {
            title: item.title,
            amount: item.amount,
            date: new Date(item.date),
          };
        });
        setExpenses(expenseData);
      });
  }

  useEffect(() => {
    fetchExpenseData();
  }, []);

  const addExpenseHandler = (expense) => {
    //  const updatedExpense = [expense,...expenses];
    //   setExpenses(updatedExpense);

    fetch("http://localhost:8080/expense/save-expense", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(expense),
    }).then((response) => {
      fetchExpenseData();
    });
  };

  return (
    <div>
      <h2 className="app-title">Expenso</h2>
      <NewExpense onAddExpense={addExpenseHandler} />
      <Expenses items={expenses} />
    </div>
  );
}

export default App;
