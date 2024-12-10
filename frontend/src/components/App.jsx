import { useState,useEffect } from 'react'
import "../index.css";
import { useLoaderData } from 'react-router';


export default function App() {
  const [users, setUsers] = useState();
  const [tasks,setTasks] = useState();


  useEffect(()=>{
    const {userData} = useLoaderData();
    setUsers(userData);
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
      <div className="bg-white flex ">
        <ul>
          {users.map(user =>(
            <li className="odd:bg-red-50 even:bg-blue-50 "key={user.id}>{user.firstName}</li>
          ))}
        </ul>
      </div>

      <div className="bg-pink-100 flex">
        {
          tasks && tasks.length>0 ? 
            <ul>
              {tasks.map(task => (
              <li className="odd:bg-red-50 even:bg-blue-50" key={task.id}>{task.title}</li>
              ))}
            </ul>
          :
          <div>not able to grab tasks</div>
        }
        </div>
    </>
  )
}


