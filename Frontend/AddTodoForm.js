import React, { useState } from "react";
import axios from "axios";
import "./style.css";

const AddTodoForm = () => {
  const [task, setTask] = useState("");
  const [completed, setCompleted] = useState(false);
  const [todos, setTodos] = useState([]);
  const [showTodos, setShowTodos] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8080/todos", { task, completed });
      setTask("");
      setCompleted(false);
    } catch (error) {
      console.error("Error adding todo:", error);
    }
  };

  const handleFetchTodos = async () => {
    try {
      const res = await axios.get("http://localhost:8080/todos");
      setTodos(res.data);
      setShowTodos(true);
    } catch (error) {
      console.error("Error fetching todos:", error);
    }
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/todos/${id}`);
      // Refresh the list after delete
      setTodos((prev) => prev.filter((todo) => todo.id !== id));
    } catch (error) {
      console.error("Error deleting todo:", error);
    }
  };

  return (
    <div className="add-todo-container">
      <form onSubmit={handleSubmit} className="add-todo-form">
        <input
          type="text"
          placeholder="Task"
          value={task}
          onChange={(e) => setTask(e.target.value)}
          className="input-task"
          required
        />
        <div className="checkbox-container">
          <input
            type="checkbox"
            checked={completed}
            onChange={(e) => setCompleted(e.target.checked)}
          />
          <label>Completed</label>
        </div>
        <button type="submit" className="submit-button">
          Add Todo
        </button>
      </form>

      <div style={{ marginTop: "1rem", textAlign: "center" }}>
        <button onClick={handleFetchTodos} className="submit-button">
          Show Todos
        </button>
      </div>

      {showTodos && (
        <div className="response-container">
          <h3>All Todos:</h3>
          <ul>
            {todos.map((todo) => (
              <li key={todo.id} style={{ marginBottom: "0.5rem" }}>
                <strong>{todo.task}</strong> -{" "}
                {todo.completed ? "Completed" : "Pending"}{" "}
                <button
                  onClick={() => handleDelete(todo.id)}
                  style={{
                    marginLeft: "1rem",
                    backgroundColor: "red",
                    color: "white",
                    border: "none",
                    padding: "4px 8px",
                    cursor: "pointer",
                    borderRadius: "4px",
                  }}
                >
                  Delete
                </button>
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
};

export default AddTodoForm;
