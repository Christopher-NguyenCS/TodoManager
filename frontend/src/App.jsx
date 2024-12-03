import { useState,useEffect } from 'react'
import './App.css'

function App() {
  const [users, setUsers] = useState();
  const [tasks,setTasks] = useState();
  useEffect(()=>{
    const fetchUsers = async()=>{
      try {
        const response = await fetch("http://localhost:8080/users");
        const users = await response.json();
        setUsers(users);
        
      } catch (error) {
        return <div>{error}</div>
      }
    }
    fetchUsers();
  },[]);

  useEffect(()=>{
    const fetchTasks = async() =>{
      try {
        const response = await fetch("http://localhost:8080/tasks");
        const tasks = await response.json();
        console.log("Tasks:",tasks);
        setTasks(tasks);
      } catch (error) {
        return <div>{error}</div>
      }
    }
    fetchTasks();
  },[]);

  if(!users){
    return <div>no users</div>
  }

  return (
    <>
    {console.log(tasks)}
      <div>
        {users.map(user =>(
          <li key={user.id}>{user.firstName}</li>
        ))}
        {}
      </div>
      <div>
        {
          tasks && tasks.length>0 ? tasks.map(task=>(
            <li key={task.id}>{task.title}</li>
          ))
          :
          <div>not able to grab tasks</div>
        }</div>
    </>
  )
}

export default App
